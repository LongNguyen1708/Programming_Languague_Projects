package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SimpleHeartGenerator {

    public static void generateHeartImages(int size) {
        /**
         * Save the image to a file
         * @param image The image to save
         * @param filePath The file path
         * Setup graphics with anti-aliasing
         * @param g2d Graphics context
         * @param size Image size
         * Generate heart images and save them to the data directory
         * @param size The size of the heart images
         */generateFullHeart(size);

         generateEmptyHeart(size);
        System.out.println("Heart images generated successfully in the 'data' directory");
    }


    private static void generateFullHeart(int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        setupGraphics(g2d, size);

        // Draw filled heart
        g2d.setColor(new Color(220, 20, 60)); // Crimson red
        g2d.fill(createHeartShape(size));

        // Draw outline
        g2d.setColor(new Color(120, 0, 0)); // Dark red
        g2d.setStroke(new BasicStroke(size / 16f));
        g2d.draw(createHeartShape(size));

        g2d.dispose();
        saveImage(image, "data/full_heart.png");
    }

   static void generateEmptyHeart(int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        setupGraphics(g2d, size);

        // Draw empty heart with light fill
        g2d.setColor(new Color(120, 0, 0, 40)); // Very transparent dark red
        g2d.fill(createHeartShape(size));

        // Draw outline
        g2d.setColor(new Color(120, 0, 0)); // Dark red
        g2d.setStroke(new BasicStroke(size / 16f));
        g2d.draw(createHeartShape(size));

        g2d.dispose();
        saveImage(image, "data/empty_heart.png");
    }


    private static void setupGraphics(Graphics2D g2d, int size) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }


    private static GeneralPath createHeartShape(int size) {
        float scale = size * 0.8f;
        float xOffset = size * 0.1f;
        float yOffset = size * 0.1f;

        GeneralPath heart = new GeneralPath();

        // Heart curve coordinates (scaled from a 0-1 coordinate system)
        heart.moveTo(0.5f * scale + xOffset, 0.25f * scale + yOffset);

        // Left bump
        heart.curveTo(
                0.4f * scale + xOffset, 0.1f * scale + yOffset,
                0.1f * scale + xOffset, 0.2f * scale + yOffset,
                0.2f * scale + xOffset, 0.5f * scale + yOffset
        );

        // Left to bottom point
        heart.curveTo(
                0.3f * scale + xOffset, 0.7f * scale + yOffset,
                0.4f * scale + xOffset, 0.8f * scale + yOffset,
                0.5f * scale + xOffset, 0.9f * scale + yOffset
        );

        // Right to bottom point
        heart.curveTo(
                0.6f * scale + xOffset, 0.8f * scale + yOffset,
                0.7f * scale + xOffset, 0.7f * scale + yOffset,
                0.8f * scale + xOffset, 0.5f * scale + yOffset
        );

        // Right bump
        heart.curveTo(
                0.9f * scale + xOffset, 0.2f * scale + yOffset,
                0.6f * scale + xOffset, 0.1f * scale + yOffset,
                0.5f * scale + xOffset, 0.25f * scale + yOffset
        );

        return heart;
    }


    private static void saveImage(BufferedImage image, String filePath) {
        try {
            File file = new File(filePath);
            // Create directory if it doesn't exist
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            ImageIO.write(image, "PNG", file);
        } catch (IOException e) {
            System.err.println("Error saving heart image: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        generateHeartImages(32); // Generate 32x32 heart images
    }
}