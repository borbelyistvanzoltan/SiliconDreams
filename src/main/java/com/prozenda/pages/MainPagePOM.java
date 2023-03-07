package com.prozenda.pages;

import com.prozenda.selectors.LogsPage;
import com.prozenda.selectors.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPagePOM extends AbstractPage {

    public void navigateToLogsPage() {
        getDriver().findElement(MainPage.settingsButton).click();
        getDriver().findElement(MainPage.logsButton).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(LogsPage.logTable));
    }
}
