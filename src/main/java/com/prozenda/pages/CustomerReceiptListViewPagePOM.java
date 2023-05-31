package com.prozenda.pages;

import com.prozenda.selectors.CustomerReceiptListViewPage;
import com.prozenda.selectors.ReceiptPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.prozenda.utils.UIActions.elementClick;

public class CustomerReceiptListViewPagePOM extends AbstractPage {

    public void clickOnPlusButtonInListView() {
        elementClick(CustomerReceiptListViewPage.plusButton);
    }

    public void clickOnFirstReceiptName() {
        elementClick(CustomerReceiptListViewPage.name);
    }

    public void clickOnThreeDotsAndEditOnFirstReceipt() {
        elementClick(CustomerReceiptListViewPage.threeDots);
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.edit));
        elementClick(CustomerReceiptListViewPage.edit);
    }

    public void clickOnThreeDotsAndCloneOnFirstReceipt() {
        elementClick(CustomerReceiptListViewPage.threeDots);
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.clone));
        elementClick(CustomerReceiptListViewPage.clone);
    }

    public void clickOnThreeDotsAndDeleteNewlyCreatedReceipt() {
        elementClick(CustomerReceiptListViewPage.threeDots);
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.delete));
        elementClick(CustomerReceiptListViewPage.delete);
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.confirmationQuestion));
        elementClick(CustomerReceiptListViewPage.confirmationOkButton);
    }

    public void clickOnCheckBoxAndDeleteNewlyCreatedReceipt() {
        elementClick(CustomerReceiptListViewPage.checkbox);
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.deleteButton));
        elementClick(CustomerReceiptListViewPage.deleteButton);
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.confirmationQuestion));
        elementClick(CustomerReceiptListViewPage.confirmationOkButton);
    }

    public void assertReceiptDeletedSuccessfully() {
        waitUntil(ExpectedConditions.elementToBeClickable(CustomerReceiptListViewPage.deletedSuccessfullyMessage));
    }
}
