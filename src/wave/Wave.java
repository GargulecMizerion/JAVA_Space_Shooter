package wave;

import entity.CommonEnemy;

import java.awt.*;
import java.util.ArrayList;

public class Wave {
    public ArrayList<CommonEnemy> enemies;


    public Wave() {
        enemies = new ArrayList<>();
        loadEnemies();
        setValues();
    }

    public void loadEnemies() {
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

    public void setValues() {
        int col = -1;
        int row = 0;
        for (int i = 0; i < enemies.size(); i++) {

            if (i % 2 == 0) {
                row = 0;
                col++;
            }
            if (i % 2 == 1) row = 1;
            enemies.get(i).entityX = 100 + 250 * col;
            enemies.get(i).entityY = 100 + 150 * row;
            enemies.get(i).speed = 1;
        }
    }

    public void update(){
        for(CommonEnemy enemy : enemies){
            enemy.move();
        }
    }

    public void draw(Graphics2D g2) {

        for (CommonEnemy enemy : enemies) {
            if (enemy.isAlive) {
                g2.drawImage(enemy.img, enemy.entityX, enemy.entityY, enemy.img.getWidth(), enemy.img.getHeight(), null);
            }
        }

    }

    public boolean isEmpty(){
        for (CommonEnemy enemy:enemies) {
            if(enemy.isAlive){
                return false;
            }
        }

        return true;
    }

}
