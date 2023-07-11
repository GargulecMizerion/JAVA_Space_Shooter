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
        int row = 0;
        for (int i = 0; i < enemies.size(); i++) {
            g2.drawImage(enemies.get(i).img, 20 + i * 100, 300 + 100 * row, enemies.get(i).img.getWidth(), enemies.get(i).img.getHeight(), null);
        }
    }

}
