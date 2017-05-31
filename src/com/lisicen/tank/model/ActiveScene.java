package com.lisicen.tank.model;

import com.lisicen.tank.common.Utils;
import org.springframework.stereotype.Component;

/**
 * 活动场景
 * 1，当前场景的全部地图
 * 2，当前画布显示的地图
 * 3，主角
 * 4，可活动的人物
 */
@Component("scene")
public class ActiveScene {
    public java.util.List<GameItem> items = Utils.list();
}
