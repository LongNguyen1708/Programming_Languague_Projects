package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Level2 extends GameWorld {
    private List<Enemy2> enemies2;
    public Level2(GameFrame gameFrame) {
        super(gameFrame, 2);
        this.enemies2 = new ArrayList<>();
    }

    @Override
    protected Vec2 getPlayerStartPosition() {
        return new Vec2(-22, 5.75f);
    }

    @Override
    protected void createPlatforms() {
        Shape leftGroundShape = new BoxShape(0f, 2f);
        StaticBody leftGround = new StaticBody(this, leftGroundShape);
        leftGround.setPosition(new Vec2(-20, -12.2f));
        leftGround.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape1 = new BoxShape(0f, 2f);
        StaticBody leftGround1 = new StaticBody(this, leftGroundShape1);
        leftGround1.setPosition(new Vec2(-20, -8.2f));
        leftGround1.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape2 = new BoxShape(0, 2f);
        StaticBody leftGround2 = new StaticBody(this, leftGroundShape2);
        leftGround2.setPosition(new Vec2(-16, -12.2f));
        leftGround2.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape3 = new BoxShape(0f, 2f);
        StaticBody leftGround3 = new StaticBody(this, leftGroundShape3);
        leftGround3.setPosition(new Vec2(-16, -8.2f));
        leftGround3.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape4 = new BoxShape(0f, 2f);
        StaticBody leftGround4 = new StaticBody(this, leftGroundShape4);
        leftGround4.setPosition(new Vec2(-12, -12.2f));
        leftGround4.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape5 = new BoxShape(0f, 2f);
        StaticBody leftGround5 = new StaticBody(this, leftGroundShape5);
        leftGround5.setPosition(new Vec2(-12, -8.2f));
        leftGround5.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));





        Shape leftGroundShape10 = new BoxShape(0, 2f);
        StaticBody leftGround10 = new StaticBody(this, leftGroundShape10);
        leftGround10.setPosition(new Vec2(0, -12.2f));
        leftGround10.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape11 = new BoxShape(40f, 2f);
        StaticBody leftGround11 = new StaticBody(this, leftGroundShape11);
        leftGround11.setPosition(new Vec2(0, -8.2f));
        leftGround11.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape12 = new BoxShape(0f, 2f);
        StaticBody leftGround12 = new StaticBody(this, leftGroundShape12);
        leftGround12.setPosition(new Vec2(4, -12.2f));
        leftGround12.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape13 = new BoxShape(0f, 2f);
        StaticBody leftGround13 = new StaticBody(this, leftGroundShape13);
        leftGround13.setPosition(new Vec2(4, -8.2f));
        leftGround13.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape14 = new BoxShape(0f, 2f);
        StaticBody leftGround14 = new StaticBody(this, leftGroundShape14);
        leftGround14.setPosition(new Vec2(8, -12.2f));
        leftGround14.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));


        Shape leftGroundShape15 = new BoxShape(0f, 2f);
        StaticBody leftGround15 = new StaticBody(this, leftGroundShape15);
        leftGround15.setPosition(new Vec2(8, -8.2f));
        leftGround15.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape16 = new BoxShape(0f, 2f);
        StaticBody leftGround16 = new StaticBody(this, leftGroundShape16);
        leftGround16.setPosition(new Vec2(12, -12.2f));
        leftGround16.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape17 = new BoxShape(0f, 2f);
        StaticBody leftGround17 = new StaticBody(this, leftGroundShape17);
        leftGround17.setPosition(new Vec2(12, -8.2f));
        leftGround17.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape18 = new BoxShape(0f, 2f);
        StaticBody leftGround18 = new StaticBody(this, leftGroundShape18);
        leftGround18.setPosition(new Vec2(16, -12.2f));
        leftGround18.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));


        Shape leftGroundShape19 = new BoxShape(0f, 2f);
        StaticBody leftGround19 = new StaticBody(this, leftGroundShape19);
        leftGround19.setPosition(new Vec2(16, -8.2f));
        leftGround19.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape20 = new BoxShape(0f, 2f);
        StaticBody leftGround20 = new StaticBody(this, leftGroundShape20);
        leftGround20.setPosition(new Vec2(20, -12.2f));
        leftGround20.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));


        Shape leftGroundShape21 = new BoxShape(0f, 2f);
        StaticBody leftGround21 = new StaticBody(this, leftGroundShape21);
        leftGround21.setPosition(new Vec2(20, -8.2f));
        leftGround21.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape22 = new BoxShape(0f, 2f);
        StaticBody leftGround22 = new StaticBody(this, leftGroundShape22);
        leftGround22.setPosition(new Vec2(24, -12.2f));
        leftGround22.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape23 = new BoxShape(0f, 2f);
        StaticBody leftGround23 = new StaticBody(this, leftGroundShape23);
        leftGround23.setPosition(new Vec2(24, -8.2f));
        leftGround23.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape24 = new BoxShape(0f, 2f);
        StaticBody leftGround24 = new StaticBody(this, leftGroundShape24);
        leftGround24.setPosition(new Vec2(28, -12.2f));
        leftGround24.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape25 = new BoxShape(0f, 2f);
        StaticBody leftGround25 = new StaticBody(this, leftGroundShape25);
        leftGround25.setPosition(new Vec2(28, -8.2f));
        leftGround25.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape26 = new BoxShape(0f, 2f);
        StaticBody leftGround26 = new StaticBody(this, leftGroundShape26);
        leftGround26.setPosition(new Vec2(32, -12.2f));
        leftGround26.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape27 = new BoxShape(0f, 2f);
        StaticBody leftGround27 = new StaticBody(this, leftGroundShape27);
        leftGround27.setPosition(new Vec2(32, -8.2f));
        leftGround27.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape28 = new BoxShape(0f, 2f);
        StaticBody leftGround28 = new StaticBody(this, leftGroundShape28);
        leftGround28.setPosition(new Vec2(36, -12.2f));
        leftGround28.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape29 = new BoxShape(0f, 2f);
        StaticBody leftGround29 = new StaticBody(this, leftGroundShape29);
        leftGround29.setPosition(new Vec2(36, -8.2f));
        leftGround29.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape30 = new BoxShape(0f, 2f);
        StaticBody leftGround30 = new StaticBody(this, leftGroundShape30);
        leftGround30.setPosition(new Vec2(36.5f, -12.2f));
        leftGround30.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));


        Shape leftGroundShape31 = new BoxShape(0f, 2f);
        StaticBody leftGround31 = new StaticBody(this, leftGroundShape31);
        leftGround31.setPosition(new Vec2(36.5f, -8.2f));
        leftGround31.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape32 = new BoxShape(0f, 2f);
        StaticBody leftGround32 = new StaticBody(this, leftGroundShape32);
        leftGround32.setPosition(new Vec2(-36.5f, -12.2f));
        leftGround32.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape33 = new BoxShape(0f, 2f);
        StaticBody leftGround33 = new StaticBody(this, leftGroundShape33);
        leftGround33.setPosition(new Vec2(-36.5f, -8.2f));
        leftGround33.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape34 = new BoxShape(0f, 2f);
        StaticBody leftGround34 = new StaticBody(this, leftGroundShape34);
        leftGround34.setPosition(new Vec2(-32f, -12.2f));
        leftGround34.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape35 = new BoxShape(0f, 2f);
        StaticBody leftGround35 = new StaticBody(this, leftGroundShape35);
        leftGround35.setPosition(new Vec2(-32f, -8.2f));
        leftGround35.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape36 = new BoxShape(0f, 2f);
        StaticBody leftGround36 = new StaticBody(this, leftGroundShape36);
        leftGround36.setPosition(new Vec2(-28f, -12.2f));
        leftGround36.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape37 = new BoxShape(0f, 2f);
        StaticBody leftGround37 = new StaticBody(this, leftGroundShape37);
        leftGround37.setPosition(new Vec2(-28f, -8.2f));
        leftGround37.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape38 = new BoxShape(0f, 2f);
        StaticBody leftGround38 = new StaticBody(this, leftGroundShape38);
        leftGround38.setPosition(new Vec2(-24f, -12.2f));
        leftGround38.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape39 = new BoxShape(0f, 2f);
        StaticBody leftGround39 = new StaticBody(this, leftGroundShape39);
        leftGround39.setPosition(new Vec2(-24f, -8.2f));
        leftGround39.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftGroundShape40 = new BoxShape(0f, 2f);
        StaticBody leftGround40 = new StaticBody(this, leftGroundShape40);
        leftGround40.setPosition(new Vec2(-36f, -12.2f));
        leftGround40.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape leftGroundShape41 = new BoxShape(20f, 2f);
        StaticBody leftGround41 = new StaticBody(this, leftGroundShape41);
        leftGround41.setPosition(new Vec2(-36f, -8.2f));
        leftGround41.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));
        /////

        Shape rightGroundShape = new BoxShape(2f, 2);
        StaticBody rightGround = new StaticBody(this, rightGroundShape);
        rightGround.setPosition(new Vec2(6, -8));
        rightGround.addImage(new BodyImage("BackgroundImage/Tile_4S.png", 4f));

        Shape rightGroundShape1 = new BoxShape(2f, 2);
        StaticBody rightGround1 = new StaticBody(this, rightGroundShape1);
        rightGround1.setPosition(new Vec2(6, -4));
        rightGround1.addImage(new BodyImage("BackgroundImage/Tile_1S.png", 4f));

        Shape rightGroundShape3 = new BoxShape(0f, 0);
        StaticBody rightGround3 = new StaticBody(this, rightGroundShape3);
        rightGround3.setPosition(new Vec2(18, -8));
        rightGround3.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape rightGroundShape4 = new BoxShape(0, 2);
        StaticBody rightGround4 = new StaticBody(this, rightGroundShape4);
        rightGround4.setPosition(new Vec2(18, -4));
        rightGround4.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape rightGroundShape6 = new BoxShape(5f, 0);
        StaticBody rightGround6 = new StaticBody(this, rightGroundShape6);
        rightGround6.setPosition(new Vec2(14, -8));
        rightGround6.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape rightGroundShape7 = new BoxShape(7f, 2);
        StaticBody rightGround7 = new StaticBody(this, rightGroundShape7);
        rightGround7.setPosition(new Vec2(14, -4));
        rightGround7.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape rightGroundShape9 = new BoxShape(7f, 2);
        StaticBody rightGround9 = new StaticBody(this, rightGroundShape9);
        rightGround9.setPosition(new Vec2(10, -8));
        rightGround9.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape rightGroundShape10 = new BoxShape(0f, 2);
        StaticBody rightGround10 = new StaticBody(this, rightGroundShape10);
        rightGround10.setPosition(new Vec2(10, -4));
        rightGround10.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape rightGroundShape12 = new BoxShape(0f, 0);
        StaticBody rightGround12 = new StaticBody(this, rightGroundShape12);
        rightGround12.setPosition(new Vec2(22, -4));
        rightGround12.addImage(new BodyImage("BackgroundImage/Tile_3S.png", 4f));

        Shape rightGroundShape14 = new BoxShape(0f, 0);
        StaticBody rightGround14 = new StaticBody(this, rightGroundShape14);
        rightGround14.setPosition(new Vec2(22, -8));
        rightGround14.addImage(new BodyImage("BackgroundImage/Tile_6S.png", 4f));

        // small land under the hill
        Shape SHill = new BoxShape(0f, 2);
        StaticBody smallHill = new StaticBody(this, SHill);
        smallHill.setPosition(new Vec2(-29.25f, -10));
        smallHill.addImage(new BodyImage("BackgroundImage/Tile_4S.png", 4f));

        Shape SHill2 = new BoxShape(0f, 2);
        StaticBody SmallHill2 = new StaticBody(this, SHill2);
        SmallHill2.setPosition(new Vec2(-29.25f, -6));
        SmallHill2.addImage(new BodyImage("BackgroundImage/Tile_1S.png", 4f));

        // Left hill
        Shape leftWallShape = new BoxShape(0f, 0);
        StaticBody leftLand = new StaticBody(this, leftWallShape);
        leftLand.setPosition(new Vec2(-19, -6));
        leftLand.addImage(new BodyImage("BackgroundImage/Tile_6S.png", 4f));

        Shape topWallShape = new BoxShape(0f, 0);
        StaticBody topLand = new StaticBody(this, topWallShape);
        topLand.setPosition(new Vec2(-19, -2));
        topLand.addImage(new BodyImage("BackgroundImage/Tile_3S.png", 4f));

        Shape leftWallShape1 = new BoxShape(0, 0);
        StaticBody leftLand1 = new StaticBody(this, leftWallShape1);
        leftLand1.setPosition(new Vec2(-23, -6));
        leftLand1.addImage(new BodyImage("BackgroundImage/Tile_5S.png", 4f));

        Shape topWallShape1 = new BoxShape(5f,2);
        StaticBody topLand1 = new StaticBody(this, topWallShape1);
        topLand1.setPosition(new Vec2(-23, -2));
        topLand1.addImage(new BodyImage("BackgroundImage/Tile_2S.png", 4f));

        Shape leftWallShape2 = new BoxShape(0, 0);
        StaticBody leftLand2 = new StaticBody(this, leftWallShape2);
        leftLand2.setPosition(new Vec2(-27, -6));
        leftLand2.addImage(new BodyImage("BackgroundImage/Tile_4S.png", 4f));

        Shape topWallShape2 = new BoxShape(0, 0);
        StaticBody topLand2 = new StaticBody(this, topWallShape2);
        topLand2.setPosition(new Vec2(-27, -2));
        topLand2.addImage(new BodyImage("BackgroundImage/Tile_1S.png", 4f));

        // Small floating island with tree (left)
        Shape smallIsland1 = new BoxShape(0, 2);
        StaticBody leftIsland = new StaticBody(this, smallIsland1);
        leftIsland.setPosition(new Vec2(-14, 8));
        leftIsland.addImage(new BodyImage("BackgroundImage/Tile_10S.png", 4f));

        Shape smallIsland2 = new BoxShape(5f, 2f);
        StaticBody leftIsland2 = new StaticBody(this, smallIsland2);
        leftIsland2.setPosition(new Vec2(-10, 8));
        leftIsland2.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape smallIsland3 = new BoxShape(0f, 2);
        StaticBody leftIsland3 = new StaticBody(this, smallIsland3);
        leftIsland3.setPosition(new Vec2(-6, 8));
        leftIsland3.addImage(new BodyImage("BackgroundImage/Tile_12S.png", 4f));

        // 2 left islands

        Shape smallIsland4 = new BoxShape(0, 0);
        StaticBody leftIsland4 = new StaticBody(this, smallIsland4);
        leftIsland4.setPosition(new Vec2(-35, 6));
        leftIsland4.addImage(new BodyImage("BackgroundImage/Tile_10S.png", 4f));

        Shape smallIsland5 = new BoxShape(5f, 2f);
        StaticBody leftIsland5 = new StaticBody(this, smallIsland5);
        leftIsland5.setPosition(new Vec2(-31, 6));
        leftIsland5.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape smallIsland6 = new BoxShape(0f, 0);
        StaticBody leftIsland6 = new StaticBody(this, smallIsland6);
        leftIsland6.setPosition(new Vec2(-27, 6));
        leftIsland6.addImage(new BodyImage("BackgroundImage/Tile_12S.png", 4f));


        Shape smallIsland7 = new BoxShape(0, 0);
        StaticBody leftIsland7 = new StaticBody(this, smallIsland7);
        leftIsland7.setPosition(new Vec2(-23, 8));
        leftIsland7.addImage(new BodyImage("BackgroundImage/Tile_10S.png", 4f));

        Shape smallIsland8 = new BoxShape(5f, 2f);
        StaticBody leftIsland8 = new StaticBody(this, smallIsland8);
        leftIsland8.setPosition(new Vec2(-19, 8));
        leftIsland8.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape smallIsland9 = new BoxShape(0f, 0);
        StaticBody leftIsland9 = new StaticBody(this, smallIsland9);
        leftIsland9.setPosition(new Vec2(-15, 8));
        leftIsland9.addImage(new BodyImage("BackgroundImage/Tile_12S.png", 4f));


        // Medium floating island center


        Shape mediumIslandShape = new BoxShape(2, 0);
        StaticBody mediumIsland = new StaticBody(this, mediumIslandShape);
        mediumIsland.setPosition(new Vec2(-2, 10));
        mediumIsland.addImage(new BodyImage("BackgroundImage/Tile_10S.png", 4f));

        Shape mediumIslandShape2 = new BoxShape(6, 2f);
        StaticBody mediumIsland2 = new StaticBody(this, mediumIslandShape2);
        mediumIsland2.setPosition(new Vec2(2, 10));
        mediumIsland2.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape mediumIslandShape3 = new BoxShape(6, 2f);
        StaticBody mediumIsland3 = new StaticBody(this, mediumIslandShape3);
        mediumIsland3.setPosition(new Vec2(6, 10));
        mediumIsland3.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape mediumIslandShape4 = new BoxShape(2f, 0);
        StaticBody mediumIsland4 = new StaticBody(this, mediumIslandShape4);
        mediumIsland4.setPosition(new Vec2(10, 10));
        mediumIsland4.addImage(new BodyImage("BackgroundImage/Tile_12S.png", 4f));


        // more islands
        Shape mediumIslandShape5 = new BoxShape(0, 2f);
        StaticBody mediumIsland5 = new StaticBody(this, mediumIslandShape5);
        mediumIsland5.setPosition(new Vec2(20, 10));
        mediumIsland5.addImage(new BodyImage("BackgroundImage/Tile_10S.png", 4f));

        Shape mediumIslandShape6 = new BoxShape(5f, 2f);
        StaticBody mediumIsland6 = new StaticBody(this, mediumIslandShape6);
        mediumIsland6.setPosition(new Vec2(24, 10));
        mediumIsland6.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape mediumIslandShape7 = new BoxShape(5f, 2f);
        StaticBody mediumIsland7 = new StaticBody(this, mediumIslandShape7);
        mediumIsland7.setPosition(new Vec2(28, 10));
        mediumIsland7.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));

        Shape mediumIslandShape8 = new BoxShape(0f, 2f);
        StaticBody mediumIsland8 = new StaticBody(this, mediumIslandShape8);
        mediumIsland8.setPosition(new Vec2(32, 10));
        mediumIsland8.addImage(new BodyImage("BackgroundImage/Tile_12S.png", 4f));

        //left small islands
        Shape rightIslandShape = new BoxShape(0f, 2f);
        StaticBody rightIsland = new StaticBody(this, rightIslandShape);
        rightIsland.setPosition(new Vec2(14, 3));
        rightIsland.addImage(new BodyImage("BackgroundImage/Tile_10S.png", 4f));

        Shape rightIslandShape2 = new BoxShape(5f, 2f);
        StaticBody rightIsland2 = new StaticBody(this, rightIslandShape2);
        rightIsland2.setPosition(new Vec2(18, 3));
        rightIsland2.addImage(new BodyImage("BackgroundImage/Tile_11S.png", 4f));


        Shape rightIslandShape1 = new BoxShape(0f, 2f);
        StaticBody rightIsland1 = new StaticBody(this, rightIslandShape1);
        rightIsland1.setPosition(new Vec2(22, 3));
        rightIsland1.addImage(new BodyImage("BackgroundImage/Tile_12S.png", 4f));
        // Very large Wall on Right
        Shape rightWallsShape = new BoxShape(10, 10); // One large box
        StaticBody rightWalls = new StaticBody(this, rightWallsShape);
        rightWalls.setPosition(new Vec2(-40, 0.75f));
        rightWalls.addImage(new BodyImage("BackgroundImage/Tile_6S.png", 30f));

        Shape leftWallsShape = new BoxShape(10, 10); // One large box
        StaticBody leftWalls = new StaticBody(this, leftWallsShape);
        leftWalls.setPosition(new Vec2(40, 0.75f));
        leftWalls.addImage(new BodyImage("BackgroundImage/Tile_4S.png", 30f));



    }

    @Override
    protected void createEnemies() {
        // Level 1 enemies

        Enemy2 enemy1 = new Enemy2(this, -13, -9);
        enemy1.setPosition(new Vec2(-11, -6));
        enemies2.add(enemy1);

        Enemy2 enemy2 = new Enemy2(this, 5, 9);
        enemy2.setPosition(new Vec2(7, 16));
        enemies2.add(enemy2);

        Enemy2 enemy3 = new Enemy2(this, 10, 19);
        enemy3.setPosition(new Vec2(15, 2f));
        enemies2.add(enemy3);

        Enemy2 enemy4 = new Enemy2(this, -19, -15);
        enemy4.setPosition(new Vec2(-17, 9));
        enemies2.add(enemy4);

        Enemy2 enemy5 = new Enemy2(this, 14, 20);
        enemy5.setPosition(new Vec2(18, 6));
        enemies2.add(enemy4);
    }

    @Override
    protected void createCoins() {
        // Level 1 coins (original layout)
        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(0, -4f));
        coins.add(coin1);

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(3, -4f));
        coins.add(coin2);

        Coin coin3 = new Coin(this);
        coin3.setPosition(new Vec2(12, 12.75f));
        coins.add(coin3);

        Coin coin4 = new Coin(this);
        coin4.setPosition(new Vec2(11, 12.75f));
        coins.add(coin4);

        Coin coin5 = new Coin(this);
        coin5.setPosition(new Vec2(-10, 12.75f));
        coins.add(coin5);


        Coin coin6 = new Coin(this);
        coin6.setPosition(new Vec2(0, 12.75f));
        coins.add(coin6);

        Coin coin7 = new Coin(this);
        coin7.setPosition(new Vec2(2, 6f));
        coins.add(coin7);

        Coin coin8 = new Coin(this);
        coin5.setPosition(new Vec2(2, 12.75f));
        coins.add(coin8);
    }

    @Override
    protected void createDecorations() {
        addDecoration("BackgroundImage/17.png",-8,-8.2f, 4f );
        addDecoration("BackgroundImage/19.png",-3,-8.2f, 4f );
        addDecoration("BackgroundImage/18.png",-4,-12.2f, 4f );
        addDecoration("BackgroundImage/18.png",-8,-12.2f, 4f );
        addDecoration("BackgroundImage/Sign_2.png",-23,2f, 4f );
        addDecoration("BackgroundImage/Crystal.png",-21,2f, 4f );
    }
    @Override
    protected void createTreasureAndDoor() {
        // Create treasure - position on the left side of the level
        treasure = new Treasure(this,true);
        treasure.setPosition(new Vec2(-25, 12f));

        // Create door - position on the right side of the level
        door = new Door(this, gameFrame,2);
        door.setPosition(new Vec2(25, 13.5f));
    }

    @Override
    protected void createHealthPotions() {
        HealthPotion potion1 = new HealthPotion(this,1);
        potion1.setPosition(new Vec2(20, 14));
        healthPotions.add(potion1);

        // Add more health potions as needed
        HealthPotion potion2 = new HealthPotion(this,1);
        potion2.setPosition(new Vec2(-23, 12f));
        healthPotions.add(potion2);
    }
    @Override
    public void cleanup() {
        // Clean up the standard enemies
        super.cleanup();

        // Also clean up level 2 specific enemies
        for (Enemy2 enemy : enemies2) {
            enemy.cleanup();
        }
    }
}
