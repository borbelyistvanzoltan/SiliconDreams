package com.prozenda.selectors;

import org.openqa.selenium.By;

public class ControlPanelPage {

    private ControlPanelPage() {}

    public static final By incomesButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div/div[2]/ul/li[1]/a");
    public static final By settingButton = By.xpath("/html/body/div[3]/div/div[2]/header/div[1]/div/ul/li[3]/a");
    public static final By companyDetails = By.xpath("/html/body/div[3]/div/div[2]/header/div[1]/div/ul/li[3]/div/div/ul/li[1]/ul/li[1]/a");
    public static final By addressesTab = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/form/ul/li[2]/a");
    public static final By productToggle = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/ul/li[3]/a");
    public static final By newProductButton = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/ul/li[3]/div/ul/li[3]/a");
    public static final By allProductsButton = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/ul/li[3]/div/ul/li[2]/a/span");
    public static final By backToAllProductsListButton = By.xpath("/html/body/div[11]/div/div[2]/div[1]/div/button[1]/span");
}
