package com.lisicen.gamer.model;

import com.lisicen.gamer.common.ConfigUtils;
import com.lisicen.gamer.common.Refresh;
import com.lisicen.gamer.common.Resource;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by X6TI on 2017/5/28.
 */
public class MainUser extends GameItem {

    private ExecutorService service = Executors.newFixedThreadPool(3);

    @Override
    public void right() {
        service.execute(() -> {
            int loop = 25;
            while (--loop >= 0) {
                try {
                    Thread.sleep(25L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    x += 2;
                }
            }
        });
    }

    @Override
    public void left() {
        service.execute(() -> {
            int loop = 25;
            while (--loop >= 0) {
                try {
                    Thread.sleep(25L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    x -= 2;
                }
            }
        });
    }

    @Override
    public void up() {
        service.execute(() -> {
            int loop = 25;
            while (--loop >= 0) {
                try {
                    Thread.sleep(25L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    y -= 2;
                }
            }
        });
    }

    @Override
    public void down() {
        service.execute(() -> {
            int loop = 25;
            while (--loop >= 0) {
                try {
                    Thread.sleep(25L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    y += 2;
                }
            }
        });
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(getX(), getY(), 50, 50);
    }

}
