package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class EnemyCollision implements CollisionListener {
    private Player player;
    private GameFrame gameFrame;


    public EnemyCollision(Player player, GameFrame gameFrame) {
        this.player = player;
        this.gameFrame = gameFrame;
    }

    @Override
    public void collide(CollisionEvent e) {
        // Check if collision is with any type of enemy
        if (e.getOtherBody() instanceof Enemy || e.getOtherBody() instanceof Enemy2  || e.getOtherBody() instanceof BigBoss) {
            // Check if player is invulnerable
            if (player.isInvulnerable()) {
                return;
            }

            // Calculate knockback direction
            Vec2 playerPos = player.getPosition();
            Vec2 enemyPos = e.getOtherBody().getPosition();
            Vec2 knockbackDir = new Vec2(playerPos.x - enemyPos.x, playerPos.y - enemyPos.y);

            // Normalize direction and apply knockback force
            float length = (float) Math.sqrt(knockbackDir.x * knockbackDir.x + knockbackDir.y * knockbackDir.y);
            if (length > 0) {
                knockbackDir.x /= length;
                knockbackDir.y /= length;
            }

            float knockbackForce = 10f;
            player.applyImpulse(new Vec2(knockbackDir.x * knockbackForce, knockbackDir.y * knockbackForce));

            // Apply damage to player (always 1 full heart per hit)
            boolean playerSurvived = player.takeDamage();

            // Check if player died
            if (!playerSurvived) {
                gameFrame.playerDied();
            }
        }
    }
}