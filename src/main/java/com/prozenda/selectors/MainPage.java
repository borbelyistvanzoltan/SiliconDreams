package com.prozenda.selectors;

import org.openqa.selenium.By;

public class MainPage {

    public static final By favoriteButton = By.id("add-to-favorite-btn");
    public static final By settingsButton = By.xpath("//span[text()='Beállítások']");
    public static final By logsButton = By.xpath("//span[text()='Napló']");
    public static final By notificationSettingsButton = By.xpath("//span[text()='Értesítési központ']");

}
