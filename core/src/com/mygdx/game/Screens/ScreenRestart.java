package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Bird;
import com.mygdx.game.components.Background;
import com.mygdx.game.components.PointCounter;
import com.mygdx.game.components.TextButton;
public class ScreenRestart implements Screen {
    int points;
    MyGdxGame myGdxGame;
    Background background;
    TextButton restartButton, menuButton;
    PointCounter pointCounter;
    public ScreenRestart(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        restartButton = new TextButton(640, 150, "Restart");
        menuButton = new TextButton(640, 350, "Menu");
        background = new Background(new Texture("backgrounds/restart_bg.png"), 2);
        pointCounter = new PointCounter(640, 650, points);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(restartButton.isHit(myGdxGame)){
            myGdxGame.setScreen(myGdxGame.screenGame);
        }
        if(menuButton.isHit(myGdxGame)){
            myGdxGame.setScreen(myGdxGame.screenMenu);
        }

        ScreenUtils.clear(1,0,0,1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        restartButton.draw(myGdxGame.batch);
        menuButton.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, points);
        myGdxGame.batch.end();
        background.move();
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
        background.dispose();
        restartButton.dispose();
        pointCounter.dispose();
        menuButton.dispose();
    }
}
