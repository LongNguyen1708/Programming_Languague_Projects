package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enemy2 extends EnemyBase {
    // Different shape for level 2 enemies
    private static final Shape enemy2Shape = new BoxShape(1.2f, 1.2f);
    // Enemy movement and animation properties
    private boolean facingRight = false;
    private int currentFrame = 0;
    private Timer animationTimer;
    private Timer movementTimer;

    // Patrol boundaries
    private float leftBound;
    private float rightBound;
    private static final float ENEMY_SPEED = 4; // Slightly faster than regular enemies

    // Different images for level 2 enemies
    private static final BodyImage[] walkRightImages = {
            new BodyImage("Enemy/skeletonlord_right_1.png", 2.5f),
            new BodyImage("Enemy/skeletonlord_right_2.png", 2.5f)

    };

    private static final BodyImage[] walkLeftImages = {
            new BodyImage("Enemy/skeletonlord_left_1.png", 2.5f),
            new BodyImage("Enemy/skeletonlord_left_2.png", 2.5f)

    };


    public Enemy2(World world, float leftBound, float rightBound) {
        super(world, enemy2Shape, leftBound, rightBound, 20);
        this.leftBound = leftBound;
        this.rightBound = rightBound;

        // Start with left-facing image
        this.addImage(walkLeftImages[0]);

        // Setup animation timer
        animationTimer = new Timer(150, new ActionListener() { // Faster animation
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimation();
            }
        });
        animationTimer.start();

        // Setup patrol movement
        startPatrolling();
    }

    // Update enemy animation frames
    private void updateAnimation() {
        this.removeAllImages();
        BodyImage[] currentImageSet = facingRight ? walkRightImages : walkLeftImages;
        currentFrame = (currentFrame + 1) % currentImageSet.length;
        this.addImage(currentImageSet[currentFrame]);
    }

    // Start enemy patrolling behavior
    private void startPatrolling() {
        // Initial movement
        startWalking(-ENEMY_SPEED);

        // Create collision listener to handle direction changes
//        this.addCollisionListener(new CollisionListener() {
//            @Override
//            public void collide(CollisionEvent e) {
//                // If the enemy collides with anything, change direction
//                if (!(e.getOtherBody() instanceof Player)) {
//                    changeDirection();
//                }
//            }
//        });

        // Create timer to check position and change direction if needed
        movementTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBounds();
            }
        });
        movementTimer.start();
    }

    // Check enemy position to ensure it stays within patrol bounds
    private void checkBounds() {
        Vec2 position = getPosition();

        if (position.x <= leftBound && !facingRight) {
            changeDirection();
        } else if (position.x >= rightBound && facingRight) {
            changeDirection();
        }
    }

    // Change enemy movement direction
    private void changeDirection() {
        facingRight = !facingRight;
        startWalking(facingRight ? ENEMY_SPEED : -ENEMY_SPEED);
    }

    // Method to stop all timers when enemy is destroyed
    public void cleanup() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        if (movementTimer != null) {
            movementTimer.stop();
        }
    }

    @Override
    public void destroy() {
        cleanup();
        super.destroy();
    }
}