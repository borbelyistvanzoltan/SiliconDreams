package com.prozenda.pages;

import com.prozenda.selectors.LoginPage;
import com.prozenda.selectors.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPagePOM extends AbstractPage {

    public void navigate() {
        getDriver().navigate().to("https://test.d4s.hu/");
    }

    public void login() {
        getDriver().findElement(LoginPage.email).sendKeys("istvan.borbely@prozenda.com");
        getDriver().findElement(LoginPage.password).sendKeys("@Prozenda2023@");
        getDriver().findElement(LoginPage.loginButton).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(MainPage.favoriteButton));
    }
}
