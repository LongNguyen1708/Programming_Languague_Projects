package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Treasure extends StaticBody {
    private static final Shape treasureShape = new BoxShape(1.0f, 0.7f);
    private static final BodyImage closedImage = new BodyImage("BackgroundImage/ChestClosed.png", 3.5f);
    private static final BodyImage openImage = new BodyImage("BackgroundImage/ChestOpened.png", 3.5f);

    private boolean isOpen = false;
    private boolean hasKey = false;


    public Treasure(World world, boolean hasKey) {
        super(world, treasureShape);
        addImage(closedImage);
        this.hasKey = hasKey;
    }


    public void interact(Player player) {
        if (!isOpen) {
            isOpen = true;

            // Change image to open treasure
            removeAllImages();
            addImage(openImage);

            // If treasure contains a key
            if (hasKey) {
                // Give the key to the player
                player.setHasKey(true);

                // Play key pickup sound
                try {
                    SoundManager.getInstance().playSoundEffect(SoundEffects.KEY_PICKUP);
                } catch (Exception e) {
                    System.out.println("Key found!");
                }

                // Show message
                JOptionPane.showMessageDialog(null,
                        "You found a key!",
                        "Go open the door",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // If no key, give a health potion instead
                if (player.getCurrentHearts() < player.getMaxHearts()) {
                    player.heal();

                    // Show message
                    JOptionPane.showMessageDialog(null,
                            "You found a health potion!",
                            "Health Restored",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Show message when health is full
                    JOptionPane.showMessageDialog(null,
                            "You found a health potion, but your health is already full!",
                            "Health Full",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    /**
     * Check if treasure is open
     * @return True if treasure is open
     */
    public boolean isOpen() {
        return isOpen;
    }
}