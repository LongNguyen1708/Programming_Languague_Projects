package game;

import city.cs.engine.Walker;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PlayerController extends KeyAdapter {
    private static final float WALK_SPEED = 5;
    private static final float JUMP_SPEED = 12;

    private Player player;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // Handle key presses
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = true;
            updateWalking();
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = true;
            updateWalking();
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {

            if (Math.abs(player.getLinearVelocity().y) < 0.1f) {
                player.jump(JUMP_SPEED);
            }
        }
        if(code == KeyEvent.VK_J){
            player.shoot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Handle key releases
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = false;
            updateWalking();
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = false;
            updateWalking();
        }
    }

    /**
     * Update the player's walking based on which keys are pressed
     */
    private void updateWalking() {
        if (leftPressed && !rightPressed) {
            // Walk left
            player.startWalking(-WALK_SPEED);
        } else if (rightPressed && !leftPressed) {
            // Walk right
            player.startWalking(WALK_SPEED);
        } else {
            // Stop walking
            player.stopWalking();
        }
    }
}