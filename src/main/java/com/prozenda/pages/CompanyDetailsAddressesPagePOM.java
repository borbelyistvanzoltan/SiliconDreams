package com.prozenda.pages;

import com.prozenda.selectors.CompanyDetailsAddressesPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompanyDetailsAddressesPagePOM extends AbstractPage {

    public void createNewAddress(String postalCode, String city, String street, CompanyDetailsAddressesPage.StreetType type) {
        WebElement newButton = getDriver().findElement(CompanyDetailsAddressesPage.newButton);
        JavascriptExecutor exec = (JavascriptExecutor) getDriver();
        exec.executeScript("arguments[0].click();", newButton);
        getDriver().findElement(CompanyDetailsAddressesPage.postalCode).sendKeys(postalCode);
        getDriver().findElement(CompanyDetailsAddressesPage.city).sendKeys(city);
        getDriver().findElement(CompanyDetailsAddressesPage.streetName).sendKeys(street);
        getDriver().findElement(type.getLocator()).click();
    }

    public void clickSaveButton() {
        getDriver().findElement(CompanyDetailsAddressesPage.saveButton).click();
        waitUntil(ExpectedConditions.elementToBeClickable(CompanyDetailsAddressesPage.confirmButton));
        getDriver().findElement(CompanyDetailsAddressesPage.confirmButton).click();
    }

    public void checkNewAddress(String postalCode, String city, String street) {
        String postalCodeValue = getDriver().findElement(CompanyDetailsAddressesPage.newPostalCodeInput).getAttribute("value");
        String cityValue = getDriver().findElement(CompanyDetailsAddressesPage.newCityInput).getAttribute("value");
        String streetValue = getDriver().findElement(CompanyDetailsAddressesPage.newStreetInput).getAttribute("value");
        Assert.assertEquals(postalCode, postalCodeValue);
        Assert.assertEquals(city, cityValue);
        Assert.assertEquals(street, streetValue);
    }

    public void deleteLastAddress() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", getDriver().findElement(CompanyDetailsAddressesPage.newAddressDeleteButton));
        waitUntil(ExpectedConditions.elementToBeClickable(CompanyDetailsAddressesPage.deleteConfirmationButton));
        getDriver().findElement(CompanyDetailsAddressesPage.deleteConfirmationButton).click();
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(CompanyDetailsAddressesPage.newAddressDeleteButton));
        clickSaveButton();
    }
}
