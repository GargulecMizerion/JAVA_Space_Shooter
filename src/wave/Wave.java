package wave;

import entity.CommonEnemy;

import java.awt.*;
import java.util.ArrayList;

public class Wave {
    ArrayList<CommonEnemy> enemies;

    public Wave() {
        enemies = new ArrayList<>();
        loadEnemies();
    }

    public void loadEnemies(){
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
        enemies.add(new CommonEnemy(1));
    }

    public void draw(Graphics2D g2){

        int col = -1;
        int row = 0;
        for(int i = 0; i < enemies.size(); i++){
            if(!enemies.get(i).isAlive){
                continue;
            }
            if(i % 2 == 0) {
                row = 0;
                col++;
            }
            if(i % 2 == 1) row = 1;

            g2.drawImage(enemies.get(i).img, 100 + 250 * col, 100 + 150 * row, enemies.get(i).img.getWidth(), enemies.get(i).img.getHeight(), null);
        }

    }

}
