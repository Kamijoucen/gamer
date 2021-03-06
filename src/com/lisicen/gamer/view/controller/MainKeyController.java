package com.lisicen.gamer.view.controller;

import com.lisicen.gamer.model.ActiveScene;
import com.lisicen.gamer.model.MainUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by X6TI on 2017/5/29.
 */
@Component("MainKeyController")
public class MainKeyController extends KeyAdapter {

    @Resource
    private ActiveScene scene;

    @Resource
    private MainUser mainUser;

    public void init() {
        scene.items.add(mainUser);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                mainUser.up();
                break;
            case KeyEvent.VK_DOWN:
                mainUser.down();
                break;
            case KeyEvent.VK_LEFT:
                mainUser.left();
                break;
            case KeyEvent.VK_RIGHT:
                mainUser.right();
                break;
        }
    }

}
