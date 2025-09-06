package game;

import city.cs.engine.*;
import javax.swing.JOptionPane;

public class Door extends StaticBody {
    private static final Shape doorShape = new BoxShape(1, 2);
    private static final BodyImage door_1 = new BodyImage("BackgroundImage/Door.png", 7f);
    private static final BodyImage door_2 = new BodyImage("BackgroundImage/House.png", 3f);
    private static final BodyImage door_3 = new BodyImage("BackgroundImage/Door.png", 7f);
    private GameFrame gameFrame;
    private int levelNumber;

    public Door(World world, GameFrame gameFrame, int levelNumber) {
        /**
         * Creates a new door
         * @param world Game world
         * @param gameFrame Game frame
         * @param levelNumber Current level
         * @param player The player
         */
        super(world, doorShape);
        if (levelNumber == 2) {
            addImage(door_2);
        } else if (levelNumber == 3) {
            addImage(door_3);
        } else {
            // Default for level 1 or any other level
            addImage(door_1);
        }
        this.gameFrame = gameFrame;
        this.levelNumber = levelNumber;
    }


    public void interact(Player player) {
        if (player.hasKey()) {
            // For level 2, check if player has collected at least 4 coins
            if (levelNumber == 2 && player.getScore() < 4) {
                // Show message that more coins are needed
                JOptionPane.showMessageDialog(null,
                        "You need to collect at least 4 gold coins to proceed to Level 3!",
                        "More Coins Needed",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Play door open sound if available
            try {

            } catch (Exception e) {
                // Sound manager might not be initialized
                System.out.println("Door opened! Level completed!");
            }

            // Save the player's score before transitioning
            int currentScore = player.getScore();

            // Close the current level and move to the next one
            gameFrame.nextLevel(currentScore);
        } else {
            // Show message that key is needed
            JOptionPane.showMessageDialog(null,
                    "You need a key to open this door!",
                    "Locked Door",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}