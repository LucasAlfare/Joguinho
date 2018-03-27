package com.bomesmo.joguinho;

/**
 * Created by Lucas on 27/03/2018.
 */

public abstract class Entity {

    private String name;
    private float x, y;

    public Entity(String name) {
        this.name = name;
    }

    public Entity(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public abstract void update(float nX, float nY);

    public String getName() {
        return name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
