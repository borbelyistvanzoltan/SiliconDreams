package com.prozenda.pages;

import com.prozenda.selectors.GeneralPage;
import com.prozenda.selectors.LogsPage;
import com.prozenda.selectors.MainPage;
import com.prozenda.selectors.NotificationSettingsPage;
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
}
