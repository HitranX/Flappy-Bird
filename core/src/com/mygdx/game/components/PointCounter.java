package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PointCounter {
    int x, y;
    BitmapFont font;
    public PointCounter(int x, int y, int points){

        font = new BitmapFont();
        font.getData().setScale(7);
        font.setColor(Color.PURPLE);

        GlyphLayout gl = new GlyphLayout(font, "" + points);
        int textWidth = (int) gl.width;
        int textHeight = (int) gl.height;

        System.out.println(textWidth + " " + textHeight);

        this.x = x - textWidth / 2;
        this.y = y - textHeight / 2;
    }

    public PointCounter(int x, int y){
        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().setScale(7);
        font.setColor(Color.PURPLE);
    }

    public void draw(Batch batch, int pointsCount){
        font.draw(batch, "" + pointsCount, x, y);
    }

    public void dispose(){
        font.dispose();
    }
}
