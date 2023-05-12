package com.prozenda.selectors;

import org.openqa.selenium.By;

public class MainPage {

    private MainPage() {}

    public static final By favoriteButton = By.id("add-to-favorite-btn");
    public static final By settingsButton = By.xpath("//span[text()='Beállítások']");
    public static final By logsButton = By.xpath("//span[text()='Napló']");
    public static final By notificationSettingsButton = By.xpath("//span[text()='Értesítési központ']");
    public static final By generalButton = By.cssSelector(".kt-menu__content > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");
    public static final By newButton = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    public static final By products = By.xpath("/html/body/div[3]/div/div[2]/header/div[1]/div/ul/li[1]/div/ul/li[4]/a/span[2]");
    public static final By newProductButton = By.xpath("/html/body/div[3]/div/div[2]/header/div[1]/div/ul/li[1]/div/ul/li[4]/div/ul/li/a/span");
    public static final By saleButton = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/ul/li[7]/a/span[2]");
    public static final By newCustomerReceiptButton = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/ul/li[7]/div/ul/li[2]/a/span");

}
