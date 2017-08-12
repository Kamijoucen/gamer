package com.lisicen.gamer.common;

import com.alibaba.fastjson.JSON;
import com.kamijoucen.xml.ast.result.DocumentResult;
import com.lisicen.gamer.config.MainConfig;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.File;


public class ConfigUtils {

//    private static final String content;
    private static MainConfig config;
    private static final URL CONFIG_URL = ConfigUtils.class.getClassLoader().getResource("config.xml");

    static {
        URI uri = null;
        try {
            uri = CONFIG_URL.toURI();
        } catch (URISyntaxException e) {
            System.exit(-1);
        }
        File file = new File(uri);
        DocumentResult result = DocumentResult.load(file.getAbsolutePath());
        config = new MainConfig();
        config.setFps(Integer.parseInt(result.child("config").child("fps").attr("val").val()));
        config.setWidth(Integer.parseInt(result.child("config").child("width").attr("val").val()));
        config.setHeight(Integer.parseInt(result.child("config").child("height").attr("val").val()));
    }

    public static MainConfig getConfig() {
        return config;
    }
}
