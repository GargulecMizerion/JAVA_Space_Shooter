package main;

import bullet.Bullet;
import entity.CommonEnemy;
import wave.Wave;

public class EnemyColissionChecker {

    Wave wave;
    Bullet bullet;

    public EnemyColissionChecker(Wave wave, Bullet bullet) {
        this.wave = wave;
        this.bullet = bullet;
    }




    public void destroyEnemy(){

        CommonEnemy enemy;

        for (int i = 0; i < wave.enemies.size(); i++) {
            enemy = wave.enemies.get(i);
            if(enemy.isAlive){
                if(bullet.bulletY < enemy.entityY + enemy.img.getHeight() && bullet.bulletY > enemy.entityY){
                    if(enemy.entityX < bullet.bulletX && enemy.entityX + enemy.img.getWidth() > bullet.bulletX){
                        enemy.isAlive = false;
                        bullet.isActive = false;
                        bullet.bulletY = -10;
                        bullet.bulletX = -10;
                    }
                }
            }

        }


    }


}
