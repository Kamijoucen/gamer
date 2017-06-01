package com.lisicen.gamer.model;

import com.lisicen.gamer.common.Refresh;

/**
 * Created by X6TI on 2017/5/28.
 */
public abstract class GameItem implements Draw, Move {

    private Refresh refresh = Refresh.create(60, 3);
    private final int stepPX = 2;
    protected int x;
    protected int y;

    @Override
    public void right() {
        refresh.execute(25, (objs) -> {
            synchronized (this) {
                x += stepPX;
            }
        });
    }

    @Override
    public void left() {
        refresh.execute(25, (objs) -> {
            synchronized (this) {
                x -= stepPX;
            }
        });
    }

    @Override
    public void up() {
        refresh.execute(25, (objs) -> {
            synchronized (this) {
                y -= stepPX;
            }
        });
    }

    @Override
    public void down() {
        refresh.execute(25, (objs) -> {
            synchronized (this) {
                y += stepPX;
            }
        });
    }

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
