package com.prozenda.selectors;

import org.openqa.selenium.By;

public class ProductsPage {

    private ProductsPage() {}

    public static final By filterInputForTitle = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/table/thead/tr/th[3]/input");
    public static final By productsTable = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/table");
    public static final By allDeleteButton = By.id("all_delete");
    public static final By acceptDeleteButton = By.xpath("/html/body/div[12]/div/div[3]/button[1]");
    public static final By importExportButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[3]/a");
    public static final By importButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[3]/div/ul/li[2]/a");
    public static final By fileInput = By.name("excelFile");
    public static final By doImportButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div/fieldset/div/div/form/button");
    public static final By importSuccessDiv = By.className("import-success");
    public static final By jumpToProductsListButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div/fieldset/div/div/div[2]/a");
    public static final By newProductButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/a");
    public static final By firstProductName = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/a");
    public static final By foundNameActions = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/a");
    public static final By editProductButton = By.xpath("/html/body/div[12]/a[1]");
    public static final By attachTab = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/ul/li[5]");
    public static final By documentDropDownDiv = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/div[2]/div[5]/div/div/div/fieldset/div/div[2]/div/div[2]/div/div/div/button");
    public static final By attachedFile = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/div[2]/div[5]/div/div/div/fieldset/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/a");
    public static final By errorMark = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/div[2]/div[5]/div/div/div/fieldset/div/div[2]/div/div[2]/div/div/div[2]/div[6]");
}
