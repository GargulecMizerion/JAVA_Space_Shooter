package bullet;

import entity.CommonEnemy;
import main.GamePanel;

import java.awt.*;

public class CommonEnemyBullet extends Bullet{

    GamePanel gp;

    public CommonEnemyBullet(GamePanel gp) {
        this.gp = gp;
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

    public void shoot(CommonEnemy enemy){
        isActive = true;
        bulletX = enemy.entityX + enemy.img.getWidth() / 2;
        bulletY = enemy.entityY + enemy.img.getHeight();
    }

    public void update(){
        bulletY += speed;
        if (bulletY > gp.screenHeight) isActive = false;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillOval(bulletX, bulletY, bulletWidth, bulletHeight);
    }
}
