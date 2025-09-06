package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {
    private Player player;
    private Image background;
    private int gameTime; // Add game time
    private Font timerFont;
    private int currentLevel;
    private int heartSize = 32;
    private final int heartSpacing = 4;
    private Image fullHeartImage;
    private Image emptyHeartImage;
    public GameView(World world, int width, int height , int level) {
        super(world, width, height);
        this.player = ((GameWorld) world).getPlayer();
        this.currentLevel = level;
        if (level == 2) {
            background = new ImageIcon("BackgroundImage/BackGroundLevel2.png").getImage();
        } else if (level == 3) {
            background = new ImageIcon("BackgroundImage/BackgroundLevel3.png").getImage();
        } else {
            // Default background for level 1 or any other level
            background = new ImageIcon("BackgroundImage/Background.png").getImage();
        }
        fullHeartImage = new ImageIcon("BackgroundImage/FullHealth.png").getImage();
        emptyHeartImage = new ImageIcon("BackgroundImage/EmptyHealth.png").getImage();
        timerFont = new Font("Arial", Font.BOLD, 20);
    }
    private void drawHearts(Graphics2D g) {
        // Position in top-right corner with some padding
        int startX = getWidth() - 20 - (heartSize * 4 + heartSpacing * 3);
        int startY = 20;

        // Get player's current health in hearts
        int currentHearts = player.getCurrentHearts();

        // Draw all 4 hearts
        for (int i = 0; i < 4; i++) {
            int x = startX + i * (heartSize + heartSpacing);

            if (i < currentHearts) {
                // Full heart
                g.drawImage(fullHeartImage, x, startY, heartSize, heartSize, null);
            } else {
                // Empty heart
                g.drawImage(emptyHeartImage, x, startY, heartSize, heartSize, null);
            }
        }
    }
    @Override
    protected void paintBackground(Graphics2D g) {
        // Draw the background image to fill the entire view
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }


    protected void paintForeground(Graphics2D g) {
        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + player.getScore(), 20, 30);

        // Draw timer
        g.setFont(timerFont);
        g.setColor(Color.WHITE);

        // Format time as minutes:seconds
        int minutes = gameTime / 60;
        int seconds = gameTime % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        g.drawString("Time: " + timeString, 20, 60);
        drawHearts(g);
    }

    // Method to update game time
    public void setGameTime(int time) {
        this.gameTime = time;
    }
}
