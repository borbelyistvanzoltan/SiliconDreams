package com.prozenda.selectors;

import org.openqa.selenium.By;

public class CustomerReceiptListViewPage {

    private CustomerReceiptListViewPage() {}

    public static final By plusButton = By.id("new_invoice_btn");
    public static final By name = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/a");
    public static final By threeDots = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/a");
    public static final By edit = By.xpath("/html/body/div[17]/a[1]");
    public static final By clone = By.xpath("/html/body/div[17]/a[2]");
    public static final By delete = By.xpath("/html/body/div[17]/a[3]");
    public static final By confirmationQuestion = By.id("swal2-title");
    public static final By confirmationOkButton = By.cssSelector(".swal2-confirm");
    public static final By deletedSuccessfullyMessage = By.xpath("/html/body/div[17]");
}
