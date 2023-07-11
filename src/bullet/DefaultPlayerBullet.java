package bullet;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class DefaultPlayerBullet extends Bullet{

    GamePanel gp;
    KeyHandler keyH;
    Player player;

    public DefaultPlayerBullet(GamePanel gp, KeyHandler keyH, Player player) {
        this.gp = gp;
        this.keyH = keyH;
        this.player = player;

        setDefaultValues();
    }

    public void setDefaultValues(){
        bulletX = -10;
        bulletY = -10;
        bulletWidth = 10;
        bulletHeight = 10;
        speed = 15;
        isActive = false;
    }

    public void update(){

        if(isActive){
            bulletY -= speed;
            if(bulletY < -10) isActive = false;
        }

        if(!isActive){
            if(keyH.spacePressed){
                bulletY = player.entityY;
                bulletX = player.entityX + player.img.getWidth()/2 - 5;
                isActive = true;
            }
        }

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.GREEN);
        g2.fillOval(bulletX, bulletY, bulletWidth, bulletHeight);
    }


}
