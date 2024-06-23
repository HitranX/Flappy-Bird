package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.Background;
import com.mygdx.game.components.TextButton;

public class ScreenMenu implements Screen {
    Background background;
    MyGdxGame myGdxGame;

    TextButton startButton, exitButton;
    public ScreenMenu(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;

        background = new Background(new Texture("backgrounds/restart_bg.png"), 2);
        startButton = new TextButton(380, 360, "Start");
        exitButton = new TextButton(900, 360, "Exit");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,0,0,1);
        if(startButton.isHit(myGdxGame)){
            myGdxGame.setScreen(myGdxGame.screenGame);
        }
        if(exitButton.isHit(myGdxGame)){
            Gdx.app.exit();
        }
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        startButton.draw(myGdxGame.batch);
        exitButton.draw(myGdxGame.batch);
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
        exitButton.dispose();
        startButton.dispose();
        background.dispose();
    }
}
