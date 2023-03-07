package com.prozenda.pages;

import com.prozenda.selectors.LogsPage;
import com.prozenda.selectors.MainPage;
import com.prozenda.selectors.NotificationSettingsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
}
