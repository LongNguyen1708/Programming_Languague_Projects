package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;


public abstract class EnemyBase extends Walker {
    /**
     * Creates a new enemy with specified properties.
     * @param world Game world
     * @param shape Enemy's physical shape
     * @param leftBound Left patrol boundary
     * @param rightBound Right patrol boundary
     * @param damage Damage inflicted on player
     */

    protected int damage;

    // Patrol boundaries
    protected float leftBound;
    protected float rightBound;

    // Timers for animation and movement
    protected Timer animationTimer;
    protected Timer movementTimer;

    public EnemyBase(World world, Shape shape, float leftBound, float rightBound, int damage) {

        super(world, shape);

        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.damage = damage;
    }


    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }


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