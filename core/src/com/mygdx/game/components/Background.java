package com.mygdx.game.components;

import static com.mygdx.game.MyGdxGame.SCREEN_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCREEN_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Background {
    Texture texture;
    int x;
    int speed;
    public Background(Texture texture, int speed){
        this.texture = texture;
        this.speed = speed;
        x = 0;
    }
    public void draw(Batch batch){
        batch.draw(texture, x, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        batch.draw(texture, x + SCREEN_WIDTH, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
    public void move(){
        x -= speed;
        if(x <= -SCREEN_WIDTH){
            x += SCREEN_WIDTH;
        }
    }
    public void dispose(){
        texture.dispose();
    }
}
