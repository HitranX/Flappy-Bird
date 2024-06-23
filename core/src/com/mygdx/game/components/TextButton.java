package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screens.ScreenRestart;

public class TextButton {

    BitmapFont font;

    String text;
    Texture texture;

    int x, y;
    int textX, textY;
    int buttonWidth, buttonHeight;
    int textWidth, textHeight;

    public TextButton(int x, int y, String text) {
        this.text = text;

        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);

        GlyphLayout gl = new GlyphLayout(font, text);
        textWidth = (int) gl.width;
        textHeight = (int) gl.height;

        texture = new Texture("button_bg.png");
        buttonWidth = texture.getWidth();
        buttonHeight = texture.getHeight();
        this.x = x - buttonWidth / 2;
        this.y = y - buttonHeight / 2;

        textX = this.x + (buttonWidth - textWidth) / 2;
        textY = this.y + (buttonHeight + textHeight) / 2;
    }

    public boolean isHit(MyGdxGame myGdxGame){
        Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        return touch.x >= x && touch.x <= x + buttonWidth && touch.y >= y && touch.y <= y + buttonHeight && Gdx.input.justTouched();
    }

    public void draw(Batch batch) {
        batch.draw(texture, x, y, buttonWidth, buttonHeight);
        font.draw(batch, text, textX, textY);
    }

    public void dispose() {
        texture.dispose();
        font.dispose();
    }
}