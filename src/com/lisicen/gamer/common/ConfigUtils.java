package com.lisicen.gamer.common;

import com.alibaba.fastjson.JSON;
import com.lisicen.gamer.config.MainConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by X6TI on 2017/5/27.
 */
public class ConfigUtils {

    private static final String configName = "config.json";
    private static final String content;
    private static final MainConfig config;

    static {
        Path configPath = Paths.get(FileUtils.CLASS_PATH + configName);
        content = FileUtils.readFile(configPath);
        config = JSON.parseObject(content, MainConfig.class);
    }

    public static MainConfig getConfig() {
        return config;
    }

}
