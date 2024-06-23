package com.mygdx.game.characters;

import static com.mygdx.game.MyGdxGame.SCREEN_HEIGHT;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird{
    public static final int g = 1;
    int frameCounter = 0;
    int sizeX = 50;
    int sizeY = 50;
    Texture[] framesArray;
    int x, y;
    int speedy;

    public void onClick(){
        frameCounter = 20;
        speedy = 20;
    }
    public Bird(int x, int y, int speedy){
        this.x = x;
        this.y = y;
        this.framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
        this.speedy = speedy;
    }
    public void fly(){
        y += speedy;
        speedy -= g;
    }
    public void draw(Batch batch){
        int frameMultiplier = 10;
        batch.draw(framesArray[(frameCounter++ / frameMultiplier) % 4], x, y, sizeX, sizeY);
    }
    public void dispose() {
        for(Texture t : framesArray){
            t.dispose();
        }
    }

    public boolean isInField(){
        return (y > 0) && (y + sizeY < SCREEN_HEIGHT);
    }

}
