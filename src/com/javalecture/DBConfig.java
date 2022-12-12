package com.javalecture;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {

    private static Properties propFile;

    static {

        propFile = new Properties();

        try {
            propFile.load(new FileInputStream("src\\resources\\config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String key) {

        return propFile.getProperty(key);
    }
}
