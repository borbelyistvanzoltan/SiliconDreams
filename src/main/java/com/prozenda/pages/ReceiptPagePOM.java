package com.prozenda.pages;

import com.prozenda.selectors.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.prozenda.utils.UIActions.elementClick;

public class ReceiptPagePOM extends AbstractPage {

    public void clickOkButtonOnDataSheet() {
        getDriver().findElement(ReceiptPage.okButtonOnDataSheet).click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(ReceiptPage.table));
    }

    public void waitForLoadingReceiptPage() throws InterruptedException {
        Thread.sleep(17000);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(ReceiptPage.saveButton));
    }

    public void clickSaveButton() {
        elementClick(ReceiptPage.saveButton);
    }

    public void assertingAlertForm() throws InterruptedException {
        Thread.sleep(5000);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(ReceiptPage.alertForm));
    }

    public void waitForLoadingDataSheetChooser() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(ReceiptPage.dataSheetChooserTitle));
    }

    public void selectFromDropdownList(String formName) {
        Select select = new Select(getDriver().findElement(ReceiptPage.dataSheetDropDownList));
        select.selectByVisibleText(formName);
    }

    public void selectBizonylattomb(String bizonylattomb) {
        Select select = new Select(getDriver().findElement(ReceiptPage.bizonylattombDropDownList));
        select.selectByVisibleText(bizonylattomb);
    }

    public void typeCustomerName(String customerName) {
        elementClick(ReceiptPage.customerNameField);
        getDriver().findElement(ReceiptPage.customerNameField).sendKeys(customerName);
        elementClick(ReceiptPage.getCustomerNameFieldFirstElement);
    }

    public void typeIntoItemField(String itemName) {
        elementClick(ReceiptPage.zerothItem);
        getDriver().findElement(ReceiptPage.zerothItem).sendKeys(itemName);
    }

    public void selectRaktar(String raktar) {
        Select select = new Select(getDriver().findElement(ReceiptPage.raktarField));
        select.selectByVisibleText(raktar);
    }

    public void assertFormSavedSuccessfully() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(ReceiptPage.successMessage));
    }

    public void navigateBackToListView() {
        elementClick(ReceiptPage.backToListViewButton);
    }
}
