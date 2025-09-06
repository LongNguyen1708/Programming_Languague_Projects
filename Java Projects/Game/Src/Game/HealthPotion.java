package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthPotion extends StaticBody {
    private static final Shape potionShape = new CircleShape(0.5f);
    private static final BodyImage potionImage = new BodyImage("BackgroundImage/health_potion.png", 1.2f);

    private int healAmount;
    private Timer floatTimer;


    public HealthPotion(World world, int healAmount) {
        super(world, potionShape);
        this.healAmount = healAmount;
        addImage(potionImage);

        // Add a gentle floating effect to make it noticeable
//        startFloatingAnimation();
    }

    public int getHealAmount() {
        return healAmount;
    }


    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }


//    private void startFloatingAnimation() {
//        final float originalY = getPosition().y;
//        final float floatHeight = 0.2f;
//        final int floatCycleTime = 2000; // 2 seconds for a complete up-down cycle
//
//        // Create timer for floating animation
//        floatTimer = new Timer(50, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Calculate a sine wave for smooth floating
//                double time = System.currentTimeMillis() % floatCycleTime;
//                double normalizedTime = time / floatCycleTime;
//                double sinValue = Math.sin(normalizedTime * 2 * Math.PI);
//
//                // Update position
//                Vec2 pos = getPosition();
//                setPosition(new Vec2(
//                        pos.x,
//                        (float)(originalY + sinValue * floatHeight)
//                ));
//            }
//        });
//        floatTimer.start();
//    }


    private void cleanup() {
        if (floatTimer != null) {
            floatTimer.stop();
            floatTimer = null;
        }
    }

    @Override
    public void destroy() {
        cleanup();
        super.destroy();
    }
}