
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BigBoss extends EnemyBase implements EnemyWithHealth {
    /**
     * Creates a boss enemy
     * @param world Game world
     * @param leftBound Left patrol boundary
     * @param rightBound Right patrol boundary
     * @param amount Damage amount
     */
    // Animation and movement properties
    private boolean facingRight = false;
    private int currentFrame = 0;
    private Timer animationTimer;
    private Timer movementTimer;

    // Health system
    private int health = 20;

    // Boss is slower but stronger
    private static final float BOSS_SPEED = 5;// Define a larger shape for the boss enemy
    private static final Shape bossShape = new BoxShape(2f, 2f);

    // Boss-specific images - use different images than regular enemies
    private static final BodyImage[] walkRightImages = {
            new BodyImage("Enemy/redslime_down_1.png", 6f),
            new BodyImage("Enemy/redslime_down_2.png", 6f)
    };

    private static final BodyImage[] walkLeftImages = {
            new BodyImage("Enemy/redslime_down_1.png", 6f),
            new BodyImage("Enemy/redslime_down_2.png", 6f)
    };



    public BigBoss(World world, float leftBound, float rightBound) {
        super(world, bossShape,leftBound, rightBound,20);

        // Start with left-facing image
        this.addImage(walkLeftImages[0]);

        // Setup animation timer
        animationTimer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimation();
            }
        });
        animationTimer.start();
        this.addImage(walkLeftImages[0]);
        // Start patrolling
        startPatrolling();
    }

    // Update animation frames
    private void updateAnimation() {
        this.removeAllImages();
        BodyImage[] currentImageSet = facingRight ? walkRightImages : walkLeftImages;
        currentFrame = (currentFrame + 1) % currentImageSet.length;
        this.addImage(currentImageSet[currentFrame]);
    }

    // Start patrolling behavior
    public void startPatrolling() {
        // Initial movement
        startWalking(-BOSS_SPEED);

        // Create timer to check position and change direction if needed
        movementTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBounds();
            }
        });
        movementTimer.start();
    }

    // Check position bounds
    private void checkBounds() {
        Vec2 position = getPosition();

        if (position.x <= leftBound && !facingRight) {
            changeDirection();
        } else if (position.x >= rightBound && facingRight) {
            changeDirection();
        }
    }

    // Change direction
    private void changeDirection() {
        facingRight = !facingRight;
        startWalking(facingRight ? BOSS_SPEED : -BOSS_SPEED);
    }

    @Override
    public boolean takeDamage(int amount) {
        health -= amount;

        // Visual feedback when hit
        setAlwaysOutline(true);
        Timer flashTimer = new Timer(200, e -> setAlwaysOutline(false));
        flashTimer.setRepeats(false);
        flashTimer.start();

        // Check if enemy died
        if (health <= 0) {
            // Play death sound
            try {
                SoundManager.getInstance().playSoundEffect(SoundEffects.Boss);
            } catch (Exception e) {
                System.out.println("Boss defeated!");
            }

            // Drop a key at the boss's position
            Vec2 position = this.getPosition();
            Key key = new Key(this.getWorld());
            key.setPosition(position);

            // Get the player from the world to set up the collision
            GameWorld gameWorld = (GameWorld)this.getWorld();
            Player player = gameWorld.getPlayer();
            key.setupCollision(player);

            // Show a message that the boss dropped a key
            JOptionPane.showMessageDialog(null,
                    "The boss has been defeated and dropped a key!",
                    "Boss Defeated",
                    JOptionPane.INFORMATION_MESSAGE);

            // Destroy the boss
            destroy();
            return false;
        }
        return true;
    }

    @Override
    public int getHealth() {
        return health;
    }

    // Cleanup when destroyed
    @Override
    public void cleanup() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        if (movementTimer != null) {
            movementTimer.stop();
        }
    }
}
