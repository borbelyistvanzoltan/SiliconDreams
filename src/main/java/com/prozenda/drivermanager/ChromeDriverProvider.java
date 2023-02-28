package com.prozenda.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeDriverProvider implements DriverProvider{

    WebDriver driver;

    public WebDriver getDriver() {
        if(driver == null) {
            driver = WebDriverManager.chromedriver().create();
        }

        return driver;
    }
}