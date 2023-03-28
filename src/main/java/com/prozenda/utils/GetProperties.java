package com.prozenda.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class GetProperties {

    private GetProperties(){}

    public static String getProperty(String key) {
        Properties prop = new Properties();
        try {
            InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"));
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}