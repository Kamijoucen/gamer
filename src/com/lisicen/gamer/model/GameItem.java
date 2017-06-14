package com.lisicen.gamer.model;

import com.lisicen.gamer.common.Refresh;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by X6TI on 2017/5/28.
 */
public abstract class GameItem implements Draw, Move {

    private final Refresh refresh = Refresh.create(60, 3);
    private final int stepPX = 2;
    private final int stepCount = 20;

    private final AtomicInteger x = new AtomicInteger(0);
    private final AtomicInteger y = new AtomicInteger(0);

    @Override
    public void right() {
        refresh.execute(stepCount, (objs) -> x.addAndGet(stepPX));
    }

    @Override
    public void left() {
        refresh.execute(stepCount, (objs) -> x.addAndGet(-stepPX));
    }

    @Override
    public void up() {
        refresh.execute(stepCount, (objs) -> y.addAndGet(-stepPX));
    }

    @Override
    public void down() {
        refresh.execute(stepCount, (objs) -> y.addAndGet(stepPX));
    }

    public int getX() {
        return x.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }
}
