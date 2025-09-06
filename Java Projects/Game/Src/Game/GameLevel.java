package game;

import city.cs.engine.World;
import game.Door;
import game.Player;
import game.Treasure;
import java.util.List;


public interface GameLevel {


    void initialize(int playerScore);


    Player getPlayer();


    int getLevelNumber();


    World getWorld();


    Door getDoor();


    Treasure getTreasure();


    void cleanup();
}