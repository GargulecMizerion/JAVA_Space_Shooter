package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;

    KeyHandler keyH;
    BufferedImage hpImg;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        loadBitmap();
        setDefaultValues();
    }

    public void loadBitmap(){
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
            hpImg = ImageIO.read(getClass().getResourceAsStream("/player/heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDefaultValues(){
        entityX = gp.screenWidth / 2;
        entityY = gp.screenHeight - 100;
        speed = 15;
        hp = 3;

    }


    public void update(){

        if(keyH.leftPressed){
            entityX -= speed;
            if(entityX < 0) entityX = 0;
        }

        if(keyH.rightPressed){
            entityX += speed;

            if (entityX > gp.screenWidth - img.getWidth()) entityX = gp.screenWidth - img.getWidth();

        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img, entityX, entityY, img.getWidth(), img.getHeight(), null);

        for (int i = 0; i < hp; i++) {
            g2.drawImage(hpImg, 10 + (hpImg.getWidth()) * i, 10, hpImg.getWidth(), hpImg.getHeight(), null);
        }

    }


}
