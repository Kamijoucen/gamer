package com.lisicen.gamer.view;

import com.lisicen.gamer.view.controller.DrawCallBack;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

/**
 * Created by X6TI on 2017/5/27.
 */

@Component("panel")
public class ContentPanel extends JPanel {

    @Resource
    private DrawCallBack callBack;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 920, 800); // 边框
        callBack.draw(g);
    }

}
