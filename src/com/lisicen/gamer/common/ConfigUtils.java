package com.lisicen.gamer.common;

import com.alibaba.fastjson.JSON;
import com.lisicen.gamer.config.MainConfig;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by X6TI on 2017/5/27.
 */
public class ConfigUtils {

    private static final String content;
    private static final MainConfig config;
    private static final URL CONFIG_URL = ConfigUtils.class.getClassLoader().getResource("config.json");

    static {
        URI uri = null;
        try {
            uri = CONFIG_URL.toURI();
        } catch (URISyntaxException e) {
            System.exit(-1);
        }
        Path configPath = Paths.get(uri);
        content = FileUtils.readFile(configPath);
        config = JSON.parseObject(content, MainConfig.class);
    }

    public static MainConfig getConfig() {
        return config;
    }
}
