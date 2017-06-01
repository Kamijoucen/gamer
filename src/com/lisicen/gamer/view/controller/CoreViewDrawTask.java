package com.lisicen.gamer.view.controller;

import com.lisicen.gamer.common.CallBack;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * Created by X6TI on 2017/5/28.
 */
@Component("CoreViewDrawTask")
public class CoreViewDrawTask implements CallBack {

    @Resource(name = "panel")
    private JPanel panel;

    @Override
    public void call(Object ... objects) {
        while (true) {
            try {
                Thread.sleep(25L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.repaint();
        }
    }
}
