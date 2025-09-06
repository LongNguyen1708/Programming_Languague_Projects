package Menus;

import game.GameFrame;
import game.SoundManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    private SoundManager soundManager;
    private Image backgroundImage;
    private Image playButtonImage;
    private Image settingsButtonImage;
    private Image instructionsButtonImage;
    private Image exitButtonImage;

    public GameMenu() {
        // Get the sound manager instance
        soundManager = SoundManager.getInstance();

        // Load images
        loadImages();

        setTitle("The Risk - Game Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel with background
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw background image
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    // Fallback if image fails to load
                    g.setColor(new Color(50, 50, 100));  // Dark blue background
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        // Create title panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        JLabel titleLabel = new JLabel("THE RISK");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 20));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));

        // Play button
        JButton playButton = createImageButton(
                playButtonImage,
                "Play Game",
                e -> {
                    soundManager.playSoundEffect("sounds/press.wav");
                    startGame();
                }
        );

        // Settings button
        JButton settingsButton = createImageButton(
                settingsButtonImage,
                "Settings",
                e -> {
                    soundManager.playSoundEffect("sounds/press.wav");
                    openSettings();
                }
        );

        // Instructions button
        JButton instructionsButton = createImageButton(
                instructionsButtonImage,
                "Instructions",
                e -> {
                    soundManager.playSoundEffect("sounds/press.wav");
                    showInstructions();
                }
        );

        // Exit button
        JButton exitButton = createImageButton(
                exitButtonImage,
                "Exit Game",
                e -> {
                    soundManager.playSoundEffect("sounds/press.wav");
                    System.exit(0);
                }
        );

        // Add buttons to panel
        buttonPanel.add(playButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(exitButton);

        // Add panels to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Set content pane
        setContentPane(mainPanel);


        // Display the frame
        setVisible(true);

        // Play menu music when the menu opens
        soundManager.playBackgroundMusic("sounds/menu_music.wav");
    }


    private void loadImages() {
        try {
            // Try to load background image
            backgroundImage = new ImageIcon("BackgroundImage/ForestBG.jpg").getImage();

            // Try to load button images
            playButtonImage = new ImageIcon("BackgroundImage/play button.png").getImage();
            settingsButtonImage = new ImageIcon("BackgroundImage/Option button.png").getImage();
            instructionsButtonImage = new ImageIcon("BackgroundImage/Help button.png").getImage();
            exitButtonImage = new ImageIcon("BackgroundImage/Quit button 2.png").getImage();
        } catch (Exception e) {
            System.err.println("Error loading menu images: " + e.getMessage());
            // We'll fall back to standard buttons if images don't load
        }
    }


    private JButton createImageButton(Image buttonImage, String buttonText, ActionListener actionListener) {
        JButton button;

        if (buttonImage != null) {
            // Create an image button
            button = new JButton(new ImageIcon(buttonImage));
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setOpaque(false);

            // Add accessibility text
            button.setToolTipText(buttonText);
        } else {
            // Fallback to text button if image isn't available
            button = new JButton(buttonText);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(new Color(70, 130, 180));  // Steel blue
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setContentAreaFilled(true);
            button.setOpaque(true);
        }

        // Add action listener
        button.addActionListener(actionListener);

        return button;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(70, 130, 180));  // Steel blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
    }




    private void startGame() {
        // Stop menu music before starting the game
        soundManager.stopBackgroundMusic();
        dispose(); // Close the menu
        new GameFrame(); // Start the game
    }

    private void openSettings() {
        // Open the settings menu
        new SettingsMenu(this);
    }

    private void showInstructions() {
        JOptionPane.showMessageDialog(this,
                "Instructions:\n\n" +
                        "- Use arrow keys or WASD to move\n" +
                        "- Space to jump\n" +
                        "- Collect coins to increase your score\n" +
                        "- Find the key and reach the door to complete each level\n" +
                        "- Avoid enemies and obstacles\n",
                "How to Play",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenu();
            }
        });
    }
}