package com.bomesmo.joguinho;

import android.annotation.SuppressLint;

/**
 * Created by Lucas on 27/03/2018.
 */

public class Player extends Entity{

    public Player(String name) {
        super(name);
    }

    public Player(String name, float x, float y) {
        super(name, x, y);
    }

    @Override
    public void update(float nX, float nY) {
        setX(nX);
        setY(nY);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return Debugger.debug(String.format("%s, X: %f|Y: %f", this.getName(), this.getX(), this.getY()), Debugger.Level.INFO);
    }
}
