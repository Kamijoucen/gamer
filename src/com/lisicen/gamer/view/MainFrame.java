package com.lisicen.gamer.view;

import com.lisicen.gamer.common.ConfigUtils;
import com.lisicen.gamer.common.SpringUtils;
import com.lisicen.gamer.config.MainConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(((int) screenSize.getWidth() >> 1) - (WIDTH >> 1), ((int) screenSize.getHeight() >> 1) - (HEIGHT >> 1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        this.setContentPane(contentPanel);
        KeyAdapter mainKeyController = SpringUtils.getBean("MainKeyController"); // 界面主控制器
        this.addKeyListener(mainKeyController);
        Runnable runnable = SpringUtils.getBean("CoreViewDrawTask"); // fps控制线程
        new Thread(runnable).start();
    }

}
