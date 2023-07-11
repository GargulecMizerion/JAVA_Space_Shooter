package entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CommonEnemy extends Entity{



    int difficult;

    public CommonEnemy(int difficult) {
        this.difficult = difficult;

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



}

