package com.bomesmo.joguinho;

/**
 * Created by Lucas on 27/03/2018.
 */

public class Enemie extends Entity {

    public Enemie(String name) {
        super(name);
    }

    public Enemie(String name, float x, float y) {
        super(name, x, y);
    }

    @Override
    public void update(float nX, float nY) {
        setX(nX);
        setY(nY);
    }
}
