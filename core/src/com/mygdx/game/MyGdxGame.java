package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.ScreenGame;
import com.mygdx.game.Screens.ScreenMenu;
import com.mygdx.game.Screens.ScreenRestart;

import java.util.Random;
public class MyGdxGame extends Game {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public ScreenGame screenGame;
	public ScreenRestart screenRestart;
	public ScreenMenu screenMenu;
	public static final Random random = new Random();
	public OrthographicCamera camera;
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

		screenGame = new ScreenGame(this);
		screenRestart = new ScreenRestart(this);
		screenMenu = new ScreenMenu(this);

		setScreen(screenMenu);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
