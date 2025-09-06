
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.ArrayList;
import java.util.List;


public abstract class GameWorld extends World {

    protected Player player;
    protected List<Enemy> enemies;
    protected List<Coin> coins;
    protected Door door;
    protected Treasure treasure;
    protected GameFrame gameFrame;
    protected int levelNumber;
    protected List<HealthPotion> healthPotions;

    /**
     * Create a new game world
     * @param gameFrame The game frame
     * @param levelNumber The level number
     */
    public GameWorld(GameFrame gameFrame, int levelNumber) {
        super();
        this.gameFrame = gameFrame;
        this.levelNumber = levelNumber;
        this.enemies = new ArrayList<>();
        this.coins = new ArrayList<>();
        this.healthPotions = new ArrayList<>();

    }


    public void initialize(int playerScore) {
        // Create player
        player = new Player(this);
        player.setPosition(getPlayerStartPosition());

        // Set player's score based on previous level
        if (playerScore > 0) {
            player.setScore(playerScore);
        }

        // Add coin pickup listener
        player.addCollisionListener(new CoinPickup(player));

        // Add interaction listener
        player.addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent e) {
                if (e.getOtherBody() instanceof Treasure) {
                    Treasure treasure = (Treasure)e.getOtherBody();
                    treasure.interact(player);
                }

                if (e.getOtherBody() instanceof Door) {
                    Door door = (Door)e.getOtherBody();
                    door.interact(player);
                }
            }
        });

        // Create level-specific elements
        createPlatforms();
        createEnemies();
        createCoins();
        createDecorations();
        createHealthPotions();
        // Create treasure and door
        createTreasureAndDoor();
    }


    protected void addDecoration(String imagePath, float x, float y, float scale) {
        // Create a body with no collision shape
        StaticBody decoration = new StaticBody(this);
        decoration.setPosition(new Vec2(x, y));
        decoration.addImage(new BodyImage(imagePath, scale));
    }

    /**
     * Clean up resources when level is finished
     */
    public void cleanup() {
        // Stop all enemies
        for (Enemy enemy : enemies) {
            enemy.cleanup();
        }

        // Stop the world
        stop();
    }

    /**
     * Get the player
     * @return The player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the door
     * @return The door
     */
    public Door getDoor() {
        return door;
    }

    /**
     * Get the treasure
     * @return The treasure
     */
    public Treasure getTreasure() {
        return treasure;
    }

    /**
     * Get the level number
     * @return The level number
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * Get the list of enemies
     * @return The enemies
     */
    public List<Enemy> getEnemies() {
        return enemies;
    }


    /**
     * Get the list of coins
     * @return The coins
     */
    public List<Coin> getCoins() {
        return coins;
    }

    /**
     * Get the starting position for the player
     * @return The starting position
     */
    protected abstract Vec2 getPlayerStartPosition();

    /**
     * Create the platforms for this level
     */
    protected abstract void createPlatforms();

    /**
     * Create the enemies for this level
     */
    protected abstract void createEnemies();

    /**
     * Create the coins for this level
     */
    protected abstract void createCoins();

    /**
     * Create the decorations for this level
     */
    protected abstract void createDecorations();

    /**
     * Create the treasure and door for this level
     */
    protected abstract void createTreasureAndDoor();

    protected abstract void createHealthPotions();

}
