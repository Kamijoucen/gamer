package com.lisicen.gamer.view.controller;

import com.lisicen.gamer.model.ActiveScene;
import com.lisicen.gamer.model.GameItem;
import com.lisicen.gamer.view.MainFrame;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.awt.*;

/**
 * Created by X6TI on 2017/5/28.
 */
@Component("draw")
public class DrawCallBack {

    @Resource(name = "scene")
    private ActiveScene scene;

    public void draw(Graphics graphics) {
        for (GameItem item : scene.items) {
            item.draw(graphics);
        }
    }
}
