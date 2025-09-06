package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker {
    private boolean hasKey = false;
    private int score = 0;
    private boolean facingRight = true;
    private static final Shape shape = new BoxShape(1, 1);
    private JLabel keyLabel;
    private boolean canShoot = false; // Only allow shooting in level 3
    private long lastShotTime = 0;
    private final long shootCooldown = 500; // 0.5 seconds between shots

    // Health system
    private int maxHearts = 4;     // Total hearts
    private int currentHearts = 4; // Current hearts (whole numbers only)
    private boolean isInvulnerable = false;
    private long invulnerabilityEndTime = 0;
    private final long invulnerabilityDuration = 1500; // 1.5 seconds
    private Timer flashingTimer;
    private static final float WALK_SPEED = 8;
    private static final float JUMP_FORCE = 9;

    private int currentFrame = 0;
    private boolean isMoving = false;
    private javax.swing.Timer animationTimer;
    // Array of images for animation
    private static final BodyImage[] rightImages = {
            new BodyImage("data/boy_right_1.png", 2f),
            new BodyImage("data/boy_right_2.png", 2f)
    };

    private static final BodyImage[] leftImages = {
            new BodyImage("data/boy_left_1.png", 2f),
            new BodyImage("data/boy_left_2.png", 2f)
    };


    /**
     * Creates a new player in the specified world
     * @param world The game world
     */
    public Player(World world) {
        super(world, shape);
        this.addImage(rightImages[0]);

        // Initialize health at max
        this.currentHearts = maxHearts;

        // Setup animation timer
        animationTimer = new javax.swing.Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimation();
            }
        });
        animationTimer.start();
    }
    /**
     * Updates player animation based on state
     */
    private void updateAnimation() {
        // Only animate if moving or in a more dynamic state
        if (isMoving || isJumping()) {
            this.removeAllImages();
            BodyImage[] currentImageSet = facingRight ? rightImages : leftImages;
            currentFrame = (currentFrame + 1) % currentImageSet.length;
            this.addImage(currentImageSet[currentFrame]);
        }
    }
     /**
     * Starts the player walking in a direction
     * @param speed Speed and direction value
     */
    public void startWalking(float speed) {
        super.startWalking(speed);
        isMoving = true;
        facingRight = speed > 0;
    }
     /**
     * Stops player movement
     */
    public void stopWalking() {
        super.stopWalking();
        isMoving = false;
        // Reset to first frame when stopping
        this.removeAllImages();
        this.addImage(facingRight ? rightImages[0] : leftImages[0]);
    }
    /**
     * Makes the player jump
     * @param jumpSpeed Upward force
     */
    public void jump(float jumpSpeed) {
        super.jump(jumpSpeed);
        isMoving = true;
    }
    /**
     * Checks if player is facing right
     * @return True if facing right
     */
    public boolean isFacingRight() {
        return facingRight;
    }
     /**
     * Gets standard walking speed
     * @return Walk speed
     */
    public static float getWalkSpeed() {
        return WALK_SPEED;
    }
    /**
     * Gets standard jump force
     * @return Jump force
     */
    public static float getJumpForce() {
        return JUMP_FORCE;
    }

    // Check if player is currently jumping
    private boolean isJumping() {
        return false;
    }
     /**
     * Updates score when collecting a coin
     */
    public void collectCoin() {
        score++;
        System.out.println("Score: " + score);
    }
        /**
     * Gets player's current score
     * @return The score
     */

    public int getScore() {
        return score;
    }
    /**
     * Sets player's score
     * @param newScore The new score
     */
    public void setScore(int newScore) {
        this.score = newScore;
    }
    /**
     * Gives the player a key
     */
    public void obtainKey() {
        hasKey = true;
        JOptionPane.showMessageDialog(null,
                "You found a key!",
                "Key Obtained",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void shoot() {
        // Only allow shooting if in level 3
        if (!canShoot) {
            return;
        }

        // Check cooldown
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime < shootCooldown) {
            return;
        }

        // Update last shot time
        lastShotTime = currentTime;

        // Determine shooting direction based on which way player is facing
        float direction = facingRight ? 1.0f : -1.0f;

        // Create a new bullet
        Bullet bullet = new Bullet(this.getWorld(), direction, this);

        // Play shooting sound
    }
    /**
     * Enables/disables shooting ability
     * @param canShoot True to enable shooting
     */
    // Add setter for enabling shooting (call this in level 3)
    public void setCanShoot(boolean canShoot) {

        this.canShoot = canShoot;
    }

    /**
     * Sets key possession status
     * @param hasKey True if player has key
     */
    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;

        // Play key pickup sound if getting the key
        if (hasKey) {
            try {
                SoundManager.getInstance().playSoundEffect(SoundEffects.KEY_PICKUP);
            } catch (Exception e) {
                // Sound manager might not be initialized yet
                System.out.println("Key collected!");
            }
        }
    }
      /**
     * Checks if player has a key
     * @return True if player has key
     */
    public boolean hasKey() {
        return hasKey;
    }

    // HEALTH SYSTEM METHODS


    public int getCurrentHearts() {
        return currentHearts;
    }


    public int getMaxHearts() {
        return maxHearts;
    }

     /**
     * Applies damage to player
     * @return True if player is still alive
     */
    public boolean takeDamage() {
        // Skip if invulnerable
        if (isInvulnerable()) {
            return true;
        }

        // Reduce health by 1 heart
        currentHearts--;

        // Make sure it doesn't go below zero
        if (currentHearts < 0) {
            currentHearts = 0;
        }

        // Play hurt sound
        try {
            SoundManager.getInstance().playSoundEffect(SoundEffects.PLAYER_HURT);
        } catch (Exception e) {
            System.out.println("Player took damage!");
        }

        // Make player invulnerable for a short time
        setInvulnerable(true);

        // Check if player is still alive
        return currentHearts > 0;
    }

     /**
     * Heals player by adding one heart
     */
    public void heal() {
        // Add one heart, up to maximum
        if (currentHearts < maxHearts) {
            currentHearts++;

            // Play healing sound
            try {
                SoundManager.getInstance().playSoundEffect(SoundEffects.HEALTH_PICKUP);
            } catch (Exception e) {
                System.out.println("Player healed!");
            }
        }
    }

    /**
     * Makes player temporarily invulnerable
     * @param invulnerable Invulnerability state
     */
    public void setInvulnerable(boolean invulnerable) {
        isInvulnerable = invulnerable;

        if (invulnerable) {
            // Set end time for invulnerability
            invulnerabilityEndTime = System.currentTimeMillis() + invulnerabilityDuration;

            // Start flashing effect
            startFlashing();
        } else {
            stopFlashing();
        }
    }


    public boolean isInvulnerable() {
        // Check if invulnerability has expired
        if (isInvulnerable && System.currentTimeMillis() > invulnerabilityEndTime) {
            isInvulnerable = false;
            stopFlashing(); // Stop flashing effect
        }
        return isInvulnerable;
    }

    private void startFlashing() {
        // Stop any existing flashing timer
        stopFlashing();

        // Start a timer to flash the player while invulnerable
        flashingTimer = new Timer(150, e -> {
            // Only continue if still invulnerable
            if (!isInvulnerable()) {
                stopFlashing();
                return;
            }

            // Toggle outline effect to create flashing
            setAlwaysOutline(!isAlwaysOutline());
        });
        flashingTimer.start();
    }


    private void stopFlashing() {
        if (flashingTimer != null) {
            flashingTimer.stop();
            flashingTimer = null;
        }
        setAlwaysOutline(false);
    }

     /**
     * Gets current health as percentage
     * @return Health percentage
     */
    public int getHealth() {
        return (int)((currentHearts / (float)maxHearts) * 100);
    }
     /**
     * Gets max possible health
     * @return Maximum health
     */
    public int getMaxHealth() {
        return 100;
    }


    public void cleanup() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        stopFlashing();
    }

    /**
     * Cleans up resources
     */
    @Override
    public void destroy() {
        cleanup();
        super.destroy();
    }
}
