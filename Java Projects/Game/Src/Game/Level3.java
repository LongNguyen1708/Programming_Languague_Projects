package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level3 extends GameWorld {
    private Map<Body, Integer> enemyHealth = new HashMap<>();
    private List<BigBoss> bosses = new ArrayList<>();
    public Level3(GameFrame gameFrame) {
        super(gameFrame, 1);
    }

    @Override
    protected Vec2 getPlayerStartPosition() {
        return new Vec2(-13, -4);
    }

    @Override
    protected void createPlatforms() {
        Shape leftGroundShape = new BoxShape(0f, 0f);
        StaticBody leftGround = new StaticBody(this, leftGroundShape);
        leftGround.setPosition(new Vec2(-20, -12.2f));
        leftGround.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape1 = new BoxShape(0f, 0f);
        StaticBody leftGround1 = new StaticBody(this, leftGroundShape1);
        leftGround1.setPosition(new Vec2(-20, -8.2f));
        leftGround1.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape2 = new BoxShape(0, 0f);
        StaticBody leftGround2 = new StaticBody(this, leftGroundShape2);
        leftGround2.setPosition(new Vec2(-16, -12.2f));
        leftGround2.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape3 = new BoxShape(0f, 0f);
        StaticBody leftGround3 = new StaticBody(this, leftGroundShape3);
        leftGround3.setPosition(new Vec2(-16, -8.2f));
        leftGround3.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape4 = new BoxShape(0f, 0f);
        StaticBody leftGround4 = new StaticBody(this, leftGroundShape4);
        leftGround4.setPosition(new Vec2(-12, -12.2f));
        leftGround4.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape5 = new BoxShape(0f, 0f);
        StaticBody leftGround5 = new StaticBody(this, leftGroundShape5);
        leftGround5.setPosition(new Vec2(-12, -8.2f));
        leftGround5.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape6 = new BoxShape(0f, 0f);
        StaticBody leftGround6 = new StaticBody(this, leftGroundShape6);
        leftGround6.setPosition(new Vec2(-8, -12.2f));
        leftGround6.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape7 = new BoxShape(0f, 0f);
        StaticBody leftGround7 = new StaticBody(this, leftGroundShape7);
        leftGround7.setPosition(new Vec2(-8, -8.2f));
        leftGround7.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape8 = new BoxShape(0f, 0f);
        StaticBody leftGround8 = new StaticBody(this, leftGroundShape8);
        leftGround8.setPosition(new Vec2(-4, -12.2f));
        leftGround8.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape9 = new BoxShape(0f, 0f);
        StaticBody leftGround9 = new StaticBody(this, leftGroundShape9);
        leftGround9.setPosition(new Vec2(-4, -8.2f));
        leftGround9.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape10 = new BoxShape(0, 0f);
        StaticBody leftGround10 = new StaticBody(this, leftGroundShape10);
        leftGround10.setPosition(new Vec2(0, -12.2f));
        leftGround10.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape11 = new BoxShape(40f, 0f);
        StaticBody leftGround11 = new StaticBody(this, leftGroundShape11);
        leftGround11.setPosition(new Vec2(0, -8.2f));
        leftGround11.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape12 = new BoxShape(0f, 0f);
        StaticBody leftGround12 = new StaticBody(this, leftGroundShape12);
        leftGround12.setPosition(new Vec2(4, -12.2f));
        leftGround12.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape13 = new BoxShape(0f, 0f);
        StaticBody leftGround13 = new StaticBody(this, leftGroundShape13);
        leftGround13.setPosition(new Vec2(4, -8.2f));
        leftGround13.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape14 = new BoxShape(0f, 0f);
        StaticBody leftGround14 = new StaticBody(this, leftGroundShape14);
        leftGround14.setPosition(new Vec2(8, -12.2f));
        leftGround14.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));


        Shape leftGroundShape15 = new BoxShape(0f, 0f);
        StaticBody leftGround15 = new StaticBody(this, leftGroundShape15);
        leftGround15.setPosition(new Vec2(8, -8.2f));
        leftGround15.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape16 = new BoxShape(0f, 0f);
        StaticBody leftGround16 = new StaticBody(this, leftGroundShape16);
        leftGround16.setPosition(new Vec2(12, -12.2f));
        leftGround16.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));


        Shape leftGroundShape17 = new BoxShape(0f, 0f);
        StaticBody leftGround17 = new StaticBody(this, leftGroundShape17);
        leftGround17.setPosition(new Vec2(12, -8.2f));
        leftGround17.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape18 = new BoxShape(0f, 0f);
        StaticBody leftGround18 = new StaticBody(this, leftGroundShape18);
        leftGround18.setPosition(new Vec2(16, -12.2f));
        leftGround18.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));


        Shape leftGroundShape19 = new BoxShape(0f, 0f);
        StaticBody leftGround19 = new StaticBody(this, leftGroundShape19);
        leftGround19.setPosition(new Vec2(16, -8.2f));
        leftGround19.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape20 = new BoxShape(0f, 0f);
        StaticBody leftGround20 = new StaticBody(this, leftGroundShape20);
        leftGround20.setPosition(new Vec2(20, -12.2f));
        leftGround20.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));


        Shape leftGroundShape21 = new BoxShape(0f, 0f);
        StaticBody leftGround21 = new StaticBody(this, leftGroundShape21);
        leftGround21.setPosition(new Vec2(20, -8.2f));
        leftGround21.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape22 = new BoxShape(0f, 0f);
        StaticBody leftGround22 = new StaticBody(this, leftGroundShape22);
        leftGround22.setPosition(new Vec2(24, -12.2f));
        leftGround22.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape23 = new BoxShape(0f, 0f);
        StaticBody leftGround23 = new StaticBody(this, leftGroundShape23);
        leftGround23.setPosition(new Vec2(24, -8.2f));
        leftGround23.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape24 = new BoxShape(0f, 0f);
        StaticBody leftGround24 = new StaticBody(this, leftGroundShape24);
        leftGround24.setPosition(new Vec2(28, -12.2f));
        leftGround24.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape25 = new BoxShape(0f, 0f);
        StaticBody leftGround25 = new StaticBody(this, leftGroundShape25);
        leftGround25.setPosition(new Vec2(28, -8.2f));
        leftGround25.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape26 = new BoxShape(0f, 0f);
        StaticBody leftGround26 = new StaticBody(this, leftGroundShape26);
        leftGround26.setPosition(new Vec2(32, -12.2f));
        leftGround26.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape27 = new BoxShape(0f, 0f);
        StaticBody leftGround27 = new StaticBody(this, leftGroundShape27);
        leftGround27.setPosition(new Vec2(32, -8.2f));
        leftGround27.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape28 = new BoxShape(0f, 0f);
        StaticBody leftGround28 = new StaticBody(this, leftGroundShape28);
        leftGround28.setPosition(new Vec2(36, -12.2f));
        leftGround28.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape29 = new BoxShape(0f, 0f);
        StaticBody leftGround29 = new StaticBody(this, leftGroundShape29);
        leftGround29.setPosition(new Vec2(36, -8.2f));
        leftGround29.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape30 = new BoxShape(0f, 0f);
        StaticBody leftGround30 = new StaticBody(this, leftGroundShape30);
        leftGround30.setPosition(new Vec2(36.5f, -12.2f));
        leftGround30.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));


        Shape leftGroundShape31 = new BoxShape(0f, 0f);
        StaticBody leftGround31 = new StaticBody(this, leftGroundShape31);
        leftGround31.setPosition(new Vec2(36.5f, -8.2f));
        leftGround31.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape32 = new BoxShape(0f, 0f);
        StaticBody leftGround32 = new StaticBody(this, leftGroundShape32);
        leftGround32.setPosition(new Vec2(-36.5f, -12.2f));
        leftGround32.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape33 = new BoxShape(0f, 0f);
        StaticBody leftGround33 = new StaticBody(this, leftGroundShape33);
        leftGround33.setPosition(new Vec2(-36.5f, -8.2f));
        leftGround33.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape34 = new BoxShape(0f, 0f);
        StaticBody leftGround34 = new StaticBody(this, leftGroundShape34);
        leftGround34.setPosition(new Vec2(-32f, -12.2f));
        leftGround34.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape35 = new BoxShape(0f, 0f);
        StaticBody leftGround35 = new StaticBody(this, leftGroundShape35);
        leftGround35.setPosition(new Vec2(-32f, -8.2f));
        leftGround35.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape36 = new BoxShape(0f, 0f);
        StaticBody leftGround36 = new StaticBody(this, leftGroundShape36);
        leftGround36.setPosition(new Vec2(-28f, -12.2f));
        leftGround36.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape37 = new BoxShape(0f, 0f);
        StaticBody leftGround37 = new StaticBody(this, leftGroundShape37);
        leftGround37.setPosition(new Vec2(-28f, -8.2f));
        leftGround37.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape38 = new BoxShape(0f, 0f);
        StaticBody leftGround38 = new StaticBody(this, leftGroundShape38);
        leftGround38.setPosition(new Vec2(-24f, -12.2f));
        leftGround38.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape39 = new BoxShape(0f, 0f);
        StaticBody leftGround39 = new StaticBody(this, leftGroundShape39);
        leftGround39.setPosition(new Vec2(-24f, -8.2f));
        leftGround39.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));

        Shape leftGroundShape40 = new BoxShape(0f, 0f);
        StaticBody leftGround40 = new StaticBody(this, leftGroundShape40);
        leftGround40.setPosition(new Vec2(-36f, -12.2f));
        leftGround40.addImage(new BodyImage("BackgroundImage/Tile_5.png", 4f));

        Shape leftGroundShape41 = new BoxShape(20f, 0f);
        StaticBody leftGround41 = new StaticBody(this, leftGroundShape41);
        leftGround41.setPosition(new Vec2(-36f, -8.2f));
        leftGround41.addImage(new BodyImage("BackgroundImage/Tile_2.png", 4f));
        //right large islands

        Shape rightWallsShape = new BoxShape(0, 0); // One large box
        StaticBody rightWalls = new StaticBody(this, rightWallsShape);
        rightWalls.setPosition(new Vec2(-40, 0.75f));
        rightWalls.addImage(new BodyImage("BackgroundImage/Tile_6.png", 30f));
        // Very large wall on the left
        Shape leftWallsShape = new BoxShape(0, 0); // One large box
        StaticBody leftWalls = new StaticBody(this, leftWallsShape);
        leftWalls.setPosition(new Vec2(40, 0.75f));
        leftWalls.addImage(new BodyImage("BackgroundImage/Tile_4.png", 30f));



    }
    @Override
    public void initialize(int playerScore) {
        super.initialize(playerScore);
        player.setCanShoot(true);

    }
    @Override
    protected void createEnemies() {
        // Create a boss enemy
        BigBoss bossEnemy = new BigBoss(this, -30, 30);
        bossEnemy.setPosition(new Vec2(29, -4f));
        bosses.add(bossEnemy);
    }

    @Override
    protected void createCoins() {

    }

    @Override
    protected void createDecorations() {
    }

    @Override
    protected void createTreasureAndDoor() {
        // Create treasure - position on the left side of the level
        treasure = new Treasure(this,false);
        treasure.setPosition(new Vec2(-39, -6f));

        // Create door - position on the right side of the level
        door = new Door(this, gameFrame,3);
        door.setPosition(new Vec2(38, -5.75f));
    }
    @Override
    protected void createHealthPotions() {
        // No health potions in this level
    }
    @Override
    public void cleanup() {
        super.cleanup();

        // Also clean up bosses
        for (BigBoss boss : bosses) {
            boss.cleanup();
        }
    }
    public Map<Body, Integer> getEnemyHealth() {
        return enemyHealth;
    }
    public List<BigBoss> getBosses() {
        return bosses;
    }
}
