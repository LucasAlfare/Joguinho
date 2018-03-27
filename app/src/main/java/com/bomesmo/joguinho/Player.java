package com.bomesmo.joguinho;

import android.annotation.SuppressLint;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Lucas on 27/03/2018.
 */

public class Player {

    private float posX;
    private float posY;

    public Player() {
        this.posX = 100;
        this.posY = 100;
    }

    public Player(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void update(float newX, float newY){
        setPosX(newX);
        setPosY(newY);
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return Debugger.debug(String.format("X: %f|Y: %f", this.getPosX(), this.getPosY()), Debugger.Level.INFO);
    }
}
