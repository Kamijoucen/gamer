package com.lisicen.gamer.view;

import com.lisicen.gamer.common.ConfigUtils;
import com.lisicen.gamer.common.SpringUtils;
import com.lisicen.gamer.config.MainConfig;
import com.lisicen.gamer.view.controller.MainKeyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.concurrent.Executors;

/**
 * Created by X6TI on 2017/5/27.
 */
public class MainFrame extends JFrame {

    public static final MainConfig config = ConfigUtils.getConfig();
    public static final int WIDTH = config.getWidth();
    public static final int HEIGHT = config.getHeight();
    public JPanel contentPanel = SpringUtils.getBean("panel");

    public MainFrame() {
        init();
        this.setContentPane(contentPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(((int) screenSize.getWidth() >> 1) - (WIDTH >> 1), ((int) screenSize.getHeight() >> 1) - (HEIGHT >> 1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        MainKeyController mainKeyController = SpringUtils.getBean("MainKeyController"); // 界面主控制器
        mainKeyController.init();
        this.addKeyListener(mainKeyController);
        Runnable runnable = SpringUtils.getBean("CoreViewDrawTask"); // fps控制线程
        Executors.newSingleThreadExecutor().execute(runnable);
    }

}
