package com.lisicen.gamer.view;

import com.lisicen.gamer.common.ConfigUtils;
import com.lisicen.gamer.common.Refresh;
import com.lisicen.gamer.common.SpringUtils;
import com.lisicen.gamer.config.MainConfig;
import com.lisicen.gamer.view.controller.MainKeyController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by X6TI on 2017/5/27.
 */
public class MainFrame extends JFrame {

    public static final MainConfig config = ConfigUtils.getConfig();
    public static final int WIDTH = config.getWidth();
    public static final int HEIGHT = config.getHeight();
    public JPanel contentPanel = SpringUtils.getBean("panel");
    public static int FPS = config.fps;

    public MainFrame() {
        init();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(contentPanel);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(((int) screenSize.getWidth() >> 1) - (WIDTH >> 1), ((int) screenSize.getHeight() >> 1) - (HEIGHT >> 1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void init() {
        MainKeyController mainKeyController = SpringUtils.getBean("MainKeyController"); // 界面主控制器
        mainKeyController.init();
        this.addKeyListener(mainKeyController);
        Refresh.create(FPS).execute((args) -> contentPanel.repaint());
    }
}
