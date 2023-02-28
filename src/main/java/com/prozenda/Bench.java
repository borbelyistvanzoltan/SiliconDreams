package com.prozenda;

import com.prozenda.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Bench {

    public static Bench bench;
    private WebDriver webDriver;
    private static final int TIMEOUT = 10;

    public Bench() {
        bench = this;
    }

    public void openBrowserTest() {
        webDriver = DriverManager.getInstance().getDriver();
        webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public void closeTest() {
        if(webDriver != null) {
            DriverManager.getInstance().closeDriver();
            webDriver = null;
        }
    }
}
