package com.prozenda.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.prozenda.selectors.ControlPanelPage.*;

public class ControlPanelPagePOM extends AbstractPage {

    public void waitForLoadingMainPage() {
        AbstractPage.waitUntil(ExpectedConditions.visibilityOfElementLocated(incomesButton));
    }

    public void navigateToCompanyDetails() {
        getDriver().findElement(settingButton).click();
        getDriver().findElement(companyDetails).click();
    }

    public void clickOnAddresses() {
        getDriver().findElement(addressesTab).click();
    }
}
