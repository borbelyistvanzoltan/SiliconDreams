package com.prozenda.pages;

import com.prozenda.selectors.GeneralPage;
import com.prozenda.selectors.LogsPage;
import com.prozenda.selectors.MainPage;
import com.prozenda.selectors.NotificationSettingsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.prozenda.selectors.MainPage.*;
import static com.prozenda.utils.UIActions.elementClick;

public class MainPagePOM extends AbstractPage {

    public void navigateToLogsPage() {
        getDriver().findElement(MainPage.settingsButton).click();
        getDriver().findElement(MainPage.logsButton).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(LogsPage.logTable));
    }

    public void navigateToNotificationsSettingsPage() {
        getDriver().findElement(MainPage.settingsButton).click();
        getDriver().findElement(MainPage.notificationSettingsButton).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(NotificationSettingsPage.tabList));
    }

    public void navigateToSettingsGeneralPage() {
        getDriver().findElement(MainPage.settingsButton).click();
        getDriver().findElement(MainPage.generalButton).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(GeneralPage.table));
    }

    public void navigateToNewProductPageFromNewButton() {
        elementClick(newButton);
        elementClick(products);
        elementClick(newProductButton);
    }

    public void clickOnSaleOnTheLeftMenu() {
        getDriver().findElement(MainPage.saleButton).click();
    }

    public void clickOnNewCustomerReceipt() {
        getDriver().findElement(MainPage.newCustomerReceiptButton).click();
    }

    public void waitForLoadingReceipts() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(MainPage.newCustomerReceiptButton));
    }

    public void moveOverNewButton() {
        WebElement element = getDriver().findElement(mainPageNewButton);
        Actions a = new Actions(getDriver());
        a.moveToElement(element).perform();
    }

    public void moveOverSaleButton() {
        WebElement element = getDriver().findElement(mainPageNewButtonSales);
        Actions a = new Actions(getDriver());
        a.moveToElement(element).perform();
    }

    public void clickOnNewCustomerReceiptInNewButtonSubMenu() {
        WebElement element = getDriver().findElement(mainPageNewButtonSalesNewCustomerReceipt);
        Actions a = new Actions(getDriver());
        a.moveToElement(element).perform();
        a.click(element).perform();
    }
}
