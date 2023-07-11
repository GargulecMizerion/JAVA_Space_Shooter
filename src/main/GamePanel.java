package main;

import bullet.DefaultPlayerBullet;
import entity.Player;
import wave.Wave;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{

    public int screenWidth = 1280;
    public int screenHeight = 720;
    int FPS = 60;





    BufferedImage background;

    KeyHandler keyH = new KeyHandler();

    Player player = new Player(this, keyH);

    DefaultPlayerBullet bullet = new DefaultPlayerBullet(this, keyH, player);

    Wave wave_0 = new Wave();
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
        player.update();
        bullet.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(background, 0, 0, screenWidth, screenHeight, null);
        bullet.draw(g2);
        player.draw(g2);
        wave_0.draw(g2);

    }

}
