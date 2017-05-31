package com.lisicen.tank.view.controller;

import com.lisicen.tank.model.ActiveScene;
import com.lisicen.tank.model.MainUser;
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

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                scene.items.add(new MainUser());
                break;
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
        }
    }

}
