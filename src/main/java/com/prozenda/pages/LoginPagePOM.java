package com.prozenda.pages;

import com.prozenda.selectors.LoginPage;
import com.prozenda.selectors.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.prozenda.selectors.LoginPage.*;

public class LoginPagePOM extends AbstractPage {

    public void navigate() {
        getDriver().navigate().to("https://test.d4s.hu/");
    }

    public void login() {
        if(getDriver().findElements(email).size() > 0) {
            getDriver().findElement(email).sendKeys("istvan.borbely@prozenda.com");
            getDriver().findElement(password).sendKeys("@Prozenda2023@");
            getDriver().findElement(loginButton).click();
        }
        waitUntil(ExpectedConditions.visibilityOfElementLocated(MainPage.favoriteButton));
    }

    public void loginNegative() {
        getDriver().findElement(email).sendKeys("istvan.borbely@prozenda.com");
        getDriver().findElement(password).sendKeys("Prozenda2023");
        getDriver().findElement(loginButton).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(LoginPage.incorrectLoginAlertMessage));
    }
}
