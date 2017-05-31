package com.lisicen.gamer.model;

import java.awt.*;

/**
 * 表示一个能够绘制的对象
 */
public interface Draw {
    /**
     * 绘制自己
     * @param g
     */
    void draw(Graphics g);
}
