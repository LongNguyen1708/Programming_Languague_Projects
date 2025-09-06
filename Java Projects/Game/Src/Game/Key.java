package game;

import city.cs.engine.*;
import javax.swing.JOptionPane;

public class Key extends StaticBody {
    private static final Shape keyShape = new BoxShape(0.5f, 0.5f);
    private static final BodyImage keyImage = new BodyImage("BackgroundImage/goldenkey.png", 2f);

    public Key(World world) {
        super(world, keyShape);
        addImage(keyImage);

        // Optional: add a slight rotation to make it look more interesting
        setAngleDegrees(15);
    }

    // Method to set up the collision listener for auto-collecting the key
    public void setupCollision(final Player player) {
        this.addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent e) {
                if (e.getOtherBody() == player) {
                    // Give the key to the player
                    player.setHasKey(true);

                    // Play key pickup sound
                    try {
                        SoundManager.getInstance().playSoundEffect(SoundEffects.KEY_PICKUP);
                    } catch (Exception ex) {
                        System.out.println("Key collected!");
                    }

                    // Show a message
                    JOptionPane.showMessageDialog(null,
                            "You found a key!",
                            "Key Obtained",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Destroy the key after collection
                    destroy();
                }
            }
        });
    }
}