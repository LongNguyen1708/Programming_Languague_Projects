package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class HealthPickup implements CollisionListener {
    private Player player;

    public HealthPickup(Player player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof HealthPotion) {
            HealthPotion healthPotion = (HealthPotion) e.getOtherBody();

            // Only heal if player's health is not already full
            if (player.getCurrentHearts() < player.getMaxHearts()) {
                // Apply healing (always one heart)
                player.heal();

                // Play pickup sound
                try {
                    SoundManager.getInstance().playSoundEffect(SoundEffects.HEALTH_PICKUP);
                } catch (Exception ex) {
                    System.out.println("Health potion collected!");
                }

                // Destroy the health potion
                healthPotion.destroy();
            }
        }
    }
}