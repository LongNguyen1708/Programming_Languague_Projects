package game;

public interface EnemyWithHealth {
    /**
     * Take damage from a bullet
     * @param amount Amount of damage to take
     * @return True if enemy is still alive
     */
    public boolean takeDamage(int amount);

    /**
     * Get current health
     * @return Current health
     */
    public int getHealth();
}
