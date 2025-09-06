package game;

import city.cs.engine.*;
import org.jbox2d.dynamics.Filter;  // Correct import for filter
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coin extends StaticBody {
    private static final Shape coinShape = new CircleShape(0.5f);

    // Array of coin images for rotation
    private static final BodyImage[] coinImages = {
            new BodyImage("CoinImage/coin_01.png", 1f),
            new BodyImage("CoinImage/coin_02.png", 1f),
            new BodyImage("CoinImage/coin_03.png", 1f),
            new BodyImage("CoinImage/coin_04.png", 1f),
            new BodyImage("CoinImage/coin_05.png", 1f),
            new BodyImage("CoinImage/coin_06.png", 1f)
    };

    private int currentFrame = 0;
    private Timer animationTimer;

    public Coin(World world) {
        super(world, coinShape);

        // Make the coin a sensor so it doesn't physically collide with objects
        // but still triggers collision events
        Fixture coinFixture = new GhostlyFixture(this, coinShape);

        // Initially add the first coin image
        addImage(coinImages[0]);

        // Create animation timer
        animationTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCoinAnimation();
            }
        });
        animationTimer.start();
    }

    private void updateCoinAnimation() {
        // Remove current image and add next frame
        this.removeAllImages();
        currentFrame = (currentFrame + 1) % coinImages.length;
        this.addImage(coinImages[currentFrame]);
    }

    // Optional: Method to stop animation if needed
    public void stopAnimation() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
    }

    // Optional: Method to restart animation
    public void restartAnimation() {
        if (animationTimer != null) {
            animationTimer.start();
        }
    }
}