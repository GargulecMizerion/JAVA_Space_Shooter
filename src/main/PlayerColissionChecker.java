package main;

import bullet.Bullet;
import entity.Player;

public class PlayerColissionChecker {

    Bullet bullet;

    Player player;

    public PlayerColissionChecker(Bullet bullet, Player player) {
        this.bullet = bullet;
        this.player = player;
    }

    public void destroyPlayer(){
        if(bullet.bulletY > player.entityY + 20){
            if(bullet.bulletX > player.entityX && bullet.bulletX < player.entityX + player.img.getWidth()){
                player.hp--;
                bullet.isActive = false;
            }
        }
    }
}
