package com.prozenda.selectors;

import org.openqa.selenium.By;

public class ProductsPage {

    private ProductsPage() {}

    public static final By filterInputForTitle = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/table/thead/tr/th[3]/input");
    public static final By productsTable = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/table");
    public static final By allDeleteButton = By.id("all_delete");
    public static final By acceptDeleteButton = By.xpath("/html/body/div[12]/div/div[3]/button[1]");
}
