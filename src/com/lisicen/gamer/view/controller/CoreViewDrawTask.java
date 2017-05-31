package com.lisicen.gamer.view.controller;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * Created by X6TI on 2017/5/28.
 */
@Component("CoreViewDrawTask")
public class CoreViewDrawTask implements Runnable {

    @Resource(name = "panel")
    private JPanel panel;

    @Override
    public void run() {
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
