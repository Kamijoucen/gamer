package com.lisicen.tank.view;

import com.lisicen.tank.view.controller.DrawCallBack;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

/**
 * Created by X6TI on 2017/5/27.
 */

@Component("panel")
public class ContentPanel extends JPanel {

    private static int one = MainFrame.HEIGHT / 36;
    public static int WIDTH = 36 * one;
    public static int HEIGHT = MainFrame.HEIGHT;

    @Resource
    private DrawCallBack callBack;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        callBack.draw(g);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MainFrame.WIDTH, MainFrame.HEIGHT);
    }
}
