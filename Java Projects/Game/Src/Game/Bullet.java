
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;

public class Bullet extends DynamicBody {
    /**
     * Creates a new bullet
     * @param world Game world
     * @param direction Direction (1=right, -1=left)
     * @param shooter Player who shot the bullet
     */
    private static final Shape bulletShape = new CircleShape(0.2f);
    private static final BodyImage bulletImage = new BodyImage("BackgroundImage/bullet.png", 3f);

    private final float speed = 15f;
    private final int damage = 1; // Each bullet deals 1 damage
    private float lifespan = 2.0f; // Seconds the bullet lives
    private Timer destroyTimer;


    public Bullet(World world, float direction, Player shooter) {
        super(world, bulletShape);
        addImage(bulletImage);

        // Set bullet position slightly in front of the player
        Vec2 playerPos = shooter.getPosition();
        setPosition(new Vec2(playerPos.x + (direction * 1.0f), playerPos.y));

        // Apply velocity in the shooting direction
        setLinearVelocity(new Vec2(direction * speed, 0));

        // Set bullet lifespan (destroy after a certain time)
        destroyTimer = new Timer(Math.round(lifespan * 1000), e -> {
            destroy();
        });
        destroyTimer.setRepeats(false);
        destroyTimer.start();

        // Add collision listener to detect hits
        addCollisionListener(new BulletCollision(this));
    }

    /**
     * Get the bullet's damage amount
     * @return Damage amount
     */
    public int getDamage() {
        return damage;
    }

    @Override
    public void destroy() {
        if (destroyTimer != null) {
            destroyTimer.stop();
        }
        super.destroy();
    }
}
