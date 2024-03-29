package com.prozenda.utils;

import com.prozenda.pages.AbstractPage;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static com.prozenda.selectors.ProductsPage.filterInputForTitle;

public class GetProperties extends AbstractPage {

    public enum UploadFile {
        NORMAL("product-file-upload.path"),
        LARGE("product-large-file-upload.path");

        private String uploadFile;
        private UploadFile(String uploadFile) {
            this.uploadFile = uploadFile;
        }

        public String getUploadFile() {

            return this.uploadFile;
        }
    }

    private GetProperties(){}

    public static String getProperty(String key) {
        Properties prop = new Properties();
        String environment = System.getProperty("prop");
        String whichprop = environment != null && environment.equals("win") ? environment + "." : "";
        try {
            InputStream input = Files.newInputStream(Paths.get("src/main/resources/config/" + whichprop + "config.properties"));
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }

    public static String getProductFilePath(UploadFile uploadFile) {
        Path currentRelativePath = Paths.get("");
        String currentAbsolutePath = currentRelativePath.toAbsolutePath().toString();

        return currentAbsolutePath + GetProperties.getProperty(uploadFile.getUploadFile());
    }
}