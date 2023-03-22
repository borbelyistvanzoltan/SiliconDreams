package com.prozenda.selectors;

import org.openqa.selenium.By;

public class LoginPage {

    private LoginPage() {}

    public static final By email = By.name("email");
    public static final By password = By.name("password");
    public static final By loginButton = By.id("kt_login_signin_submit");
    public static final By incorrectLoginAlertMessage = By.xpath("//span[text()='Helytelen felhasználónév vagy jelszó. Kérjük próbálja újra.']");
}
