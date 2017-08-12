package com.lisicen.gamer.model;


import java.awt.*;

/**
 * 主角，玩家直接控制的对象
 */
@org.springframework.stereotype.Component
public class MainUser extends GameItem {

    @Override
    public void draw(Graphics g) {
        g.fillOval(getX(), getY(), 40, 40);
    }

}
