package game;

import city.cs.engine.*;


public class BulletCollision implements CollisionListener {
    private Bullet bullet;

    public BulletCollision(Bullet bullet) {
        this.bullet = bullet;
    }
    @Override
    public void collide(CollisionEvent e) {
        // Skip if bullet hit the player
        if (e.getOtherBody() instanceof Player) {
            return;
        }

        // If bullet hit an enemy with health system
        if (e.getOtherBody() instanceof EnemyWithHealth) {
            EnemyWithHealth enemy = (EnemyWithHealth) e.getOtherBody();
            enemy.takeDamage(bullet.getDamage());
            bullet.destroy();
        }
        // If bullet hit a static body
        else if (e.getOtherBody() instanceof StaticBody) {
            bullet.destroy();
        }
    }
}