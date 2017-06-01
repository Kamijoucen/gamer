package com.lisicen.gamer.model;

import com.lisicen.gamer.common.ConfigUtils;
import com.lisicen.gamer.common.Refresh;
import com.lisicen.gamer.common.Resource;
import com.lisicen.gamer.view.MainFrame;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by X6TI on 2017/5/28.
 */
public class MainUser extends GameItem {

    private ExecutorService service = Executors.newFixedThreadPool(3);
    private Refresh refresh = Refresh.create(60, 3);

    @Override
    public void right() {
        refresh.execute(25, (objs) -> x += 2);
    }

    @Override
    public void left() {
        refresh.execute(25, (objs) -> x -= 2);
    }

    @Override
    public void up() {
        refresh.execute(25, (objs) -> y -= 2);
    }

    @Override
    public void down() {
        refresh.execute(25, (objs) -> y += 2);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(getX(), getY(), 50, 50);
    }

}
