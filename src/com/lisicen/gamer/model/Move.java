package com.lisicen.gamer.model;

/**
 * 表示一个可移动的对象
 */
public interface Move {
    /**
     * 向上移动
     */
    void up();

    /**
     * 向下移动
     */
    void down();

    /**
     * 向左移动
     */
    void left();

    /**
     * 向右移动
     */
    void right();
}
