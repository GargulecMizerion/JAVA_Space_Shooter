package main;

import bullet.CommonEnemyBullet;
import bullet.DefaultPlayerBullet;
import entity.Player;
import wave.Wave;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    public int screenWidth = 1280;
    public int screenHeight = 720;
    int FPS = 60;

    Random random;

    int shootingEnemy;





    BufferedImage background;

    KeyHandler keyH = new KeyHandler();

    Player player = new Player(this, keyH);

    DefaultPlayerBullet playerBullet = new DefaultPlayerBullet(this, keyH, player);

    CommonEnemyBullet enemyBullet = new CommonEnemyBullet(this);

    Wave wave_0 = new Wave();

    EnemyColissionChecker enemyColissionChecker = new EnemyColissionChecker(wave_0, playerBullet);
    PlayerColissionChecker playerColissionChecker = new PlayerColissionChecker(enemyBullet, player);
    Thread gameThread;

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void loadBackground(){

        try {
            background = ImageIO.read(getClass().getResourceAsStream("/background/space_background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
        this.random = new Random();
        loadBackground();

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        while (gameThread != null){

            update();

            repaint();

            try {
                Thread.sleep((long)drawInterval/1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public void update(){


        if (player.hp > 0) {
            player.update();
            playerBullet.update();
        }

        wave_0.update();

        if (!enemyBullet.isActive){
            shootingEnemy = random.nextInt(10);
            if(!wave_0.isEmpty()){
                while (!wave_0.enemies.get(shootingEnemy).isAlive) shootingEnemy = random.nextInt(10);
                enemyBullet.shoot(wave_0.enemies.get(shootingEnemy));
            }


        } else {
            enemyBullet.update();
        }

        if(playerBullet.isActive) enemyColissionChecker.destroyEnemy();
        playerColissionChecker.destroyPlayer();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(background, 0, 0, screenWidth, screenHeight, null);

        enemyBullet.draw(g2);

        if(player.hp > 0){
            playerBullet.draw(g2);
            player.draw(g2);

        }


        wave_0.draw(g2);




    }

}
