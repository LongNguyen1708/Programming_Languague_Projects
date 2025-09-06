package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class CoinPickup implements CollisionListener {
    private Player player;
    public CoinPickup(Player player) {
        this.player = player;
    }
    @Override
    public void collide(CollisionEvent e) {
        // Check if the other body is a coin
        if (e.getOtherBody() instanceof Coin) {
            // Collect the coin
            Coin coin = (Coin) e.getOtherBody();
            player.collectCoin();
            try {
                SoundManager.getInstance().playSoundEffect(SoundEffects.COIN_PICKUP);
            }catch(Exception ex){
                System.out.println("Coin collected!");
            }
            // Remove the coin from the world
           coin.destroy();
        }
    }
}