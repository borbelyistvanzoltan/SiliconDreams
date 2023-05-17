package com.prozenda.selectors;

import org.openqa.selenium.By;

public class ReceiptPage {

    private ReceiptPage() {}

    public static final By okButtonOnDataSheet = By.cssSelector(".swal2-confirm");
    public static final By cancelButtonOnDataSheet = By.cssSelector(".swal2-cancel");
    public static final By dataSheetDropDownList = By.cssSelector(".swal2-select");

    public static final By table = By.id("kt_content");
    public static final By saveButton = By.cssSelector("#save_btn");
    public static final By alertForm = By.cssSelector(".form-error");

    public static final By dataSheetChooserTitle = By.id("swal2-title");
    public static final By bizonylattombDropDownList = By.name("szamlatomb");
    public static final By customerNameField = By.name("nev");
    public static final By getCustomerNameFieldFirstElement = By.cssSelector(".vbst-item");
    public static final By zerothItem = By.name("items[0][megnevezes]");
    public static final By raktarField = By.name("items[0][raktarbol]");
    public static final By successMessage = By.id("swal2-title");

    public static final By backToListViewButton = By.cssSelector("button.d-flex:nth-child(4)");
}
