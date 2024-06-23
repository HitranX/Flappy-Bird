package com.mygdx.game.characters;

import static com.mygdx.game.MyGdxGame.SCREEN_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCREEN_WIDTH;
import static com.mygdx.game.MyGdxGame.random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Tube{
    int padding = 50, gapHeight = 1000, gapWidth = 100, upDistance = 300, gorizontalDistance;
    boolean isAddPoint = false;
    Texture upperTube;
    Texture downTube;
    int gapX;
    int gapY;
    int speed = 8;
    int frameCounter = 0;
    public Tube(int tubeCount, int tubeIdx){
        upperTube = new Texture("tube/tube_flipped.png");
        downTube = new Texture("tube/tube.png");
        gorizontalDistance = (SCREEN_WIDTH + gapWidth) / (tubeCount - 1);
        gapX = gorizontalDistance * tubeIdx + SCREEN_HEIGHT;
        gapY = padding + random.nextInt(SCREEN_HEIGHT - 2 * padding - upDistance);
    }

    public void draw(Batch batch){
        batch.draw(upperTube, gapX, gapY + upDistance, gapWidth, gapHeight);
        batch.draw(downTube, gapX, gapY - gapHeight, gapWidth, gapHeight);
    }

    public void move(){
        frameCounter++;
        gapX -= speed;
        if(frameCounter % 30 == 0) gapY = Math.min(SCREEN_HEIGHT - padding, Math.max(gapY + 20 * (random.nextInt(3) - 1), padding));
        if(gapX < -gapWidth) {
            isAddPoint = false;
            gapX = SCREEN_WIDTH + gorizontalDistance;
            gapY = padding + random.nextInt(SCREEN_HEIGHT - 2 * padding - upDistance);
        }
    }

    public void dispose(){
        this.upperTube.dispose();
        this.downTube.dispose();
    }

    public boolean isHit(Bird bird){
        boolean downTubeCollision = (bird.y <= this.gapY) && (bird.x + bird.sizeX >= gapX) && (bird.x <= gapX + gapWidth);
        boolean upperTubeCollision = (bird.y + bird.sizeY >= gapY + upDistance) && (bird.x + bird.sizeX >= gapX) && (bird.x <= gapX + gapWidth);
        return upperTubeCollision || downTubeCollision;
    }

    public boolean addPoint(Bird bird){
        if(gapX + gapWidth < bird.x && !isAddPoint){
            isAddPoint = true;
            return true;
        }
        return false;
    }
}
