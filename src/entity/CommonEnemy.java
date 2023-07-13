package entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CommonEnemy extends Entity{



    int difficult;
    int maxMove = 40; // Maksymalny ruch podany w pixelach
    int move = 0; // Wykonany juz ruch podany w pixelach

    public CommonEnemy(int difficult) {
        this.difficult = difficult;
        this.isAlive = true;
        loadBitmap(difficult);
    }

    public void loadBitmap(int difficult){
        try {
            switch (difficult){
                case 1:
                    img = ImageIO.read(getClass().getResourceAsStream("/enemies/ufo.png"));
                    break;
                case 2:
                    img = ImageIO.read(getClass().getResourceAsStream("/enemies/ufo_1.png"));
                    break;
                case 3:
                    img = ImageIO.read(getClass().getResourceAsStream("/enemies/ufo_2.png"));
                    break;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void move(){
        if(move < 0 || move > maxMove){
            speed = speed * -1;
            move = 0;
        }
        entityX += speed;
        move++;
    }



}

