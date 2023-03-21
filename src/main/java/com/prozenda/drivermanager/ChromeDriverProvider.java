package com.prozenda.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverProvider implements DriverProvider{

    WebDriver driver;

    public WebDriver getDriver() {
        if(driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = WebDriverManager.chromedriver().capabilities(options).create();
        }

        return driver;
    }
}