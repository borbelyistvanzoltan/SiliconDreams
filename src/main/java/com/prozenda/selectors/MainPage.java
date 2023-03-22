package com.prozenda.selectors;

import org.openqa.selenium.By;

public class MainPage {

    private MainPage() {}

    public static final By favoriteButton = By.id("add-to-favorite-btn");
    public static final By settingsButton = By.xpath("//span[text()='Beállítások']");
    public static final By logsButton = By.xpath("//span[text()='Napló']");
    public static final By notificationSettingsButton = By.xpath("//span[text()='Értesítési központ']");
    public static final By generalButton = By.cssSelector(".kt-menu__content > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");

}
