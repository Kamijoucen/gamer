package com.lisicen.gamer.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by X6TI on 2017/5/27.
 */
public class FileUtils {
    public static final String fg = File.separator;

    public static String readFile(Path path) {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return new String(bytes);
    }
}
