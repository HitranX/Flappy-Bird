package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.components.Background;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.PointCounter;
import com.mygdx.game.characters.Bird;
import com.mygdx.game.characters.Tube;

import java.util.Random;

public class ScreenGame implements Screen {

    PointCounter counterOfPoints;
    int points;
    public boolean isGameOver;
    boolean isPointGive;
    Random random = new Random();
    MyGdxGame myGdxGame;
    int tubeCount = 5;
    Tube[] tubes;
    Bird bird;
    Background background;
    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }
    @Override
    public void show() {
        initTubes();
        bird = new Bird(200, 360, 0);
        points = 0;
        isGameOver = false;
        isPointGive = false;
        counterOfPoints = new PointCounter(10, 710);
        background = new Background(new Texture("backgrounds/game_bg.png"), 2);
    }

    @Override
    public void render(float delta) {

        if(Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();
        moveTubes();
        background.move();

        for(Tube tube : tubes){
            isGameOver |= tube.isHit(bird);
            isPointGive |= tube.addPoint(bird);
        }
        isGameOver |= !bird.isInField();
        if(isGameOver) {
            myGdxGame.screenRestart.points = points;
            myGdxGame.setScreen(myGdxGame.screenRestart);
        }
        points += isPointGive? 1 : 0;
        isPointGive = false;

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        drawTubes();
        bird.draw(myGdxGame.batch);
        counterOfPoints.draw(myGdxGame.batch, points);
        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bird.dispose();
        disposeTubes();
        background.dispose();
    }

    private void initTubes(){
        tubes = new Tube[tubeCount];
        for(int i = 0; i < tubeCount; i++){
            tubes[i] = new Tube(tubeCount, i);
        }
    }
    private void drawTubes(){
        for(Tube tube : tubes) {
            tube.draw(myGdxGame.batch);
        }
    }
    private void moveTubes(){
        for(Tube tube : tubes) {
            tube.move();
        }
    }
    private void disposeTubes(){
        for(int i = 0; i < tubeCount; i++){
            tubes[i].dispose();
        }
    }
}
