package com.popcorntech.app.core.util;

import java.io.InputStream;
import java.util.Properties;

public class Env {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream in = Env.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
