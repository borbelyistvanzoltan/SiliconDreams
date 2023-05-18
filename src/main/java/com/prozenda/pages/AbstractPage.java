package com.prozenda.pages;


import com.prozenda.drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.prozenda.utils.UIActions.waitToElement;
import static com.prozenda.utils.WaitEnum.ELEMENTLOCATED;

public class AbstractPage{

    public static final Duration timeout = Duration.ofSeconds(15);
    public WebDriverWait wait = new WebDriverWait(getDriver(), timeout);

    public static WebDriver getDriver() {

        return DriverManager.getInstance().getDriver();
    }

    public static void wait(int timeout) throws InterruptedException {
        synchronized (getDriver()) {
            getDriver().wait(timeout);
        }
    }

    public static void waitUntil(ExpectedCondition condition) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(condition);
        } catch (Exception e) {
            Assert.fail("The web element could not be located");
        }
    }

    public void waitToAlert() {
        if (waitToElement(ExpectedConditions.alertIsPresent()) == ELEMENTLOCATED){
            Alert alert;
            alert = getDriver().switchTo().alert();
            alert.accept();
        }
    }
}
