package game;



public class LevelFactory {


    public static GameWorld createLevel(int levelNumber, GameFrame gameFrame) {
        switch (levelNumber) {
            case 1:
                return new Level1(gameFrame);
            case 2:
                return new Level2(gameFrame);
            case 3:
                return new Level3(gameFrame);
            default:
                // If we add more levels, we can extend this
                // For now, default to Level1 for invalid level numbers
                return new Level1(gameFrame);
        }
    }


    public static int getTotalLevels() {
        return 3; // Currently we have 3 levels
    }
}