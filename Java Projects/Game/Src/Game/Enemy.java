package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enemy extends EnemyBase {
    /**
     * Creates a new enemy
     * @param world Game world
     * @param leftBound Left patrol boundary
     * @param rightBound Right patrol boundary
     */
    // Define the shape of the enemy
    private static final Shape enemyShape = new BoxShape(1, 1);

    // Enemy images for animation
    private static final BodyImage[] walkRightImages = {
            new BodyImage("Enemy/blob_stand1.png", 3f),
            new BodyImage("Enemy/blob_jump1.png", 3f),
            new BodyImage("Enemy/blob_jump2.png", 3f),
            new BodyImage("Enemy/blob_jump3.png", 3f),
            new BodyImage("Enemy/blob_jump4.png", 3f),
            new BodyImage("Enemy/blob_stand2.png",3f)
    };

    private static final BodyImage[] walkLeftImages = {
            new BodyImage("Enemy/blob_stand1.png", 3f),
            new BodyImage("Enemy/blob_jump1.png", 3f),
            new BodyImage("Enemy/blob_jump2.png", 3f),
            new BodyImage("Enemy/blob_jump3.png", 3f),
            new BodyImage("Enemy/blob_jump4.png", 3f),
            new BodyImage("Enemy/blob_stand2.png",3f)
    };
    protected void addScaledImages(float scaleFactor) {

        addImage(new BodyImage("Enemy/blob_stand1.png", 3.0f * scaleFactor));
        addImage(new BodyImage("Enemy/blob_jump1.png" ,3f* scaleFactor));
        addImage(new BodyImage("Enemy/blob_jump1.png" ,3f* scaleFactor));
        addImage(new BodyImage("Enemy/blob_jump1.png" ,3f* scaleFactor));
        addImage(new BodyImage("Enemy/blob_jump1.png" ,3f* scaleFactor));
        addImage(new BodyImage("Enemy/blob_stand2.png", 3.0f * scaleFactor));
        // Add other images with the same scale factor
    }
    // Enemy movement and animation properties
    private boolean facingRight = false;
    private int currentFrame = 0;
    private Timer animationTimer;
    private Timer movementTimer;

    // Patrol boundaries
    private float leftBound;
    private float rightBound;
    private static final float ENEMY_SPEED = 2;

    public Enemy(World world, float leftBound, float rightBound) {
        super(world, enemyShape, leftBound, rightBound, 10);
        this.leftBound = leftBound;
        this.rightBound = rightBound;

        // Start with left-facing image
        this.addImage(walkLeftImages[0]);

        // Setup animation timer
        animationTimer = new Timer(200, new ActionListener() {
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


    void startPatrolling() {
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

    public BodyImage[] getWalkRightImages() {
        return walkRightImages;
    }

    public BodyImage[] getWalkLeftImages() {
        return walkLeftImages;
    }
}