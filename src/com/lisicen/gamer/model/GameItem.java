package com.lisicen.gamer.model;

/**
 * Created by X6TI on 2017/5/28.
 */
public abstract class GameItem implements Draw, Move {
    protected int x;
    protected int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
