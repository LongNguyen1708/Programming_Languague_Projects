package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameFrame extends JFrame {
    private UserView view;
    private GameWorld currentLevel;
    private Player player;
    private Timer gameTimer;
    private int remainingTime = 120; // 2 minutes game time
    private int currentLevelNumber = 1;
    private boolean paused = false;

    public GameFrame() {
    /**
     * Creates a game at specified level
     * @param levelNumber Level to start at
     * @param score Initial score
     */
        this(1, 0); // Start with level 1 and score 0
    }

    public GameFrame(int levelNumber, int score) {
    /**
     * Sets up the game window
     * @param score Initial score
     */
        currentLevelNumber = levelNumber;
        if (levelNumber == 1) {
            SoundManager.getInstance().playBackgroundMusic("sounds/level2_music.wav");
        } else if (levelNumber == 2) {
            SoundManager.getInstance().playBackgroundMusic("sounds/level2_music.wav");
        } else if (levelNumber == 3) {
            SoundManager.getInstance().playBackgroundMusic("sounds/level1_music.wav");
        }
        setupFrame(score);
    }
    
    private void setupFrame(int score) {
        setTitle("The Risk - Level " + currentLevelNumber);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create level using the LevelFactory
        currentLevel = LevelFactory.createLevel(currentLevelNumber, this);

        // Initialize the level with previous score
        currentLevel.initialize(score);

        // Get the player from the level
        player = currentLevel.getPlayer();
        player.addCollisionListener(new EnemyCollision(player, this));
        player.addCollisionListener(new HealthPickup(player));
        // Create view with world and dimensions
        view = new GameView(currentLevel, 800, 600, currentLevelNumber);

        // Add view to frame
        add(view);

        // Make view focusable for key inputs
        view.setFocusable(true);
        view.requestFocus();

        // Create player controller
        PlayerController controller = new PlayerController(player);
        view.addKeyListener(controller);

        // Setup game timer
        setupGameTimer();

        // Advanced smooth camera follow
        Timer cameraTimer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smoothCameraFollow();
            }
        });
        cameraTimer.start();

        // Add pause key listener
        view.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_P) {
                    togglePause();
                }
            }
        });

        // Final frame setup
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Start the world
        currentLevel.start();

        // Show level intro message
        showLevelIntro();
    }

    private void showLevelIntro() {
        // Pause the game while showing the message
        paused = true;
        currentLevel.stop();

        String message;
        if (currentLevelNumber == 2) {
            message = "Level " + currentLevelNumber + "\n\n" +
                    "Find the key and collect at least 4 gold coins to proceed to Level 3!\n" +
                    "Reach the door to complete the level!";
        } else if (currentLevelNumber == 3) {
            message = "Kill the  '' Boss '' " + "\n\n" + " Press J to attack " +    " Once you defeat it it will drops the key";

        } else {
            message = "Level " + currentLevelNumber + "\n\n" +
                    "Find the key and reach the door to complete the level!";
        }

        // Show introduction for the current level
        JOptionPane.showMessageDialog(this,
                message,
                "Level " + currentLevelNumber,
                JOptionPane.INFORMATION_MESSAGE);

        // Resume the game
        paused = false;
        currentLevel.start();
    }
     /**
     * Sets up game timer
     */
    private void setupGameTimer() {
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!paused) {
                    remainingTime--;

                    // Update view with current time
                    if (view instanceof GameView) {
                        ((GameView) view).setGameTime(remainingTime);
                    }

                    // Check if time is up
                    if (remainingTime <= 0) {
                        gameOver(false); // Time ran out
                    }
                }
            }
        });
        gameTimer.start();
    }
     /**
     * Advances to next level
     * @param currentScore Current player score
     */
    public void nextLevel(int currentScore) {
        // Stop the current level and timer
        SoundManager.getInstance().stopBackgroundMusic();
        currentLevel.cleanup();
        gameTimer.stop();

        int totalLevels = LevelFactory.getTotalLevels();

        if (currentLevelNumber < totalLevels) {
            // Advance to the next level
            currentLevelNumber++;

            if (currentLevelNumber == 2) {
                SoundManager.getInstance().playBackgroundMusic("sounds/level2_music.wav");
            } else if (currentLevelNumber == 3) {
                SoundManager.getInstance().playBackgroundMusic("sounds/level1_music.wav");
            }

            // Show level completion message
            JOptionPane.showMessageDialog(this,
                    "Level " + (currentLevelNumber - 1) + " completed!\n" +
                            "Your Score: " + currentScore + "\n\n" +
                            "Moving to Level " + currentLevelNumber,
                    "Level Complete",
                    JOptionPane.INFORMATION_MESSAGE);

            // Dispose of the current frame
            dispose();

            // Create a new game frame with the next level and current score
            new GameFrame(currentLevelNumber, currentScore);
        } else {
            // Player has completed all levels
            gameComplete(currentScore);
        }
        currentLevel.cleanup();
        System.gc();
    }
    /**
     * Shows game completion screen
     * @param finalScore Final player score
     */
    private void gameComplete(int finalScore) {
        JOptionPane.showMessageDialog(this,
                "Congratulations! You've completed all levels!\n" +
                        "Final Score: " + finalScore,
                "Game Complete",
                JOptionPane.INFORMATION_MESSAGE);

        // Ask if player wants to start over
        int response = JOptionPane.showConfirmDialog(this,
                "Would you like to play again?",
                "Play Again",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            dispose();
            new GameFrame(); // Start from level 1
        } else {
            // Exit to main menu
            dispose();
            new Menus.GameMenu();
        }
    }
    /**
     * Shows game over screen
     * @param completed Whether level was completed
     */
    private void gameOver(boolean completed) {
        // Stop the timer and current level
        gameTimer.stop();
        currentLevel.cleanup();

        String message = completed ?
                "Level " + currentLevelNumber + " completed!\nYour Score: " + player.getScore() :
                "Time's up!\nYour Score: " + player.getScore();

        String title = completed ? "Level Complete" : "Game Over";

        // Show game over dialog
        JOptionPane.showMessageDialog(this,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE);

        // Ask if player wants to try again
        int response = JOptionPane.showConfirmDialog(this,
                "Would you like to try again?",
                "Retry Level",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            restartLevel();
        } else {
            // Return to main menu
            dispose();
            new Menus.GameMenu();
        }
    }
    /**
     * Restarts current level
     */
    private void restartLevel() {
        // Dispose of current frame
        dispose();

        // Create a new game frame with the same level but reset score
        new GameFrame(currentLevelNumber, 0);
    }
    /**
     * Toggles game pause state
     */
    private void togglePause() {
        paused = !paused;
        if (paused) {
            currentLevel.stop();
            JOptionPane.showMessageDialog(this,
                    "Game Paused\nPress 'P' to resume",
                    "Paused",
                    JOptionPane.INFORMATION_MESSAGE);
            paused = false; // Automatically unpause after dialog
            currentLevel.start();
        } else {
            currentLevel.start();
        }
    }
    /**
     * Updates camera to follow player
     */
    private void smoothCameraFollow() {
        // Only update camera if game is not paused
        if (!paused && view instanceof GameView) {
            GameView gameView = (GameView) view;

            // Get current camera position
            Vec2 currentCameraPos = gameView.getCentre();

            // Get player position
            Vec2 playerPos = player.getPosition();

            // Calculate interpolated position
            float x = currentCameraPos.x + (playerPos.x - currentCameraPos.x) * 0.1f;
            float y = currentCameraPos.y + (playerPos.y - currentCameraPos.y) * 0.1f;

            // Set new camera position
            gameView.setCentre(new Vec2(x, y));
        }
    }
    public void playerDied() {
        // Play death sound
        try {
            SoundManager.getInstance().playSoundEffect(SoundEffects.GAME_OVER);
        } catch (Exception e) {
            System.out.println("Game over!");
        }

        // Stop the timer and current level
        gameTimer.stop();
        currentLevel.cleanup();

        // Show game over dialog
        JOptionPane.showMessageDialog(this,
                "Game Over!\nYour Score: " + player.getScore(),
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE);

        // Ask if player wants to try again
        int response = JOptionPane.showConfirmDialog(this,
                "Would you like to try again?",
                "Retry Level",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            restartLevel();
        } else {
            // Return to main menu
            dispose();
            new Menus.GameMenu();
        }
    }


}
