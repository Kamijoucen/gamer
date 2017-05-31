package com.lisicen.tank.model;

import java.awt.*;

/**
 * Created by X6TI on 2017/5/28.
 */
public class MainUser extends GameItem {

    @Override
    public void draw(Graphics g) {
        g.fillOval(getX(), getY(), 50, 50);
    }
}
