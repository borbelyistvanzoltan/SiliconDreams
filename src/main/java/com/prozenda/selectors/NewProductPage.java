package com.prozenda.selectors;

import org.openqa.selenium.By;

public class NewProductPage {

    private NewProductPage() {}

    public static final By productTitleInput = By.name("megnevezes[hu]");
    public static final By normalTypeRadioButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/div[2]/div[1]/div/div/div/div[1]/div/div/div[1]/div[1]/div/fieldset/div/div/div[2]/div[1]/div/div[2]/div[1]/label/span");
    public static final By serviceTypeRadioButton = By.id("tipus-9");
    public static final By hourAmountUnit = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/div[2]/div[1]/div/div/div/div[1]/div/div/div[2]/div[2]/div/fieldset/div/div[1]/div[1]/div/div/div[2]/select/option[9]");
    public static final By saveButton = By.id("save_btn");
    public static final By confirmDataSheetSelectorButton = By.xpath("//*[ text() = 'OK']");
    public static final By errorAlert =  By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div/form/div[1]");

}
