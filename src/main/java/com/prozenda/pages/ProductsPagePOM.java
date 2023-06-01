package com.prozenda.pages;

import com.prozenda.utils.GetProperties;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.prozenda.selectors.ProductsPage.*;
import static com.prozenda.selectors.ProductsPage.newProductButton;
import static com.prozenda.utils.GetProperties.getProductFilePath;
import static com.prozenda.utils.UIActions.*;

public class ProductsPagePOM extends AbstractPage {

    public enum FilterColumn {
        TITLE(filterInputForTitle);

        private By filterColumnElement;
        private FilterColumn(By filterColumnElement) {
            this.filterColumnElement = filterColumnElement;
        }

        public By getFilterColumnElement() {

            return this.filterColumnElement;
        }
    }

    public void navigate() {
        getDriver().navigate().to("https://test.d4s.hu/products");
    }

    public void filterProduct(String keyword, By column) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(column));
        getDriver().findElement(column).sendKeys(keyword);
    }

    public void checkProductCreated(String title,boolean shouldCreated) {
        Assert.assertEquals(getDriver().findElement(productsTable).getText().contains(title), shouldCreated);
    }

    public void clickDeleteButton() {
        getDriver().findElement(allDeleteButton).click();
    }

    public void clickAcceptDelete() throws InterruptedException {
        wait(4000);
        waitUntil(ExpectedConditions.elementToBeClickable(allDeleteButton));
        getDriver().findElement(acceptDeleteButton).click();
    }

    public void clickImportExportButton() {
        getDriver().findElement(importExportButton).click();
    }

    public void clickImportButton() {
        getDriver().findElement(importButton).click();
    }

    public void attachImportFile() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(fileInput));
        getDriver().findElement(fileInput).sendKeys(getTransactionFilePath());
    }

    public void doImport() {
        waitUntil(ExpectedConditions.elementToBeClickable(doImportButton));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", getDriver().findElement(doImportButton));
    }

    public void checkSuccessfulImport(int numberOfImportedProducts) {
        waitUntil(ExpectedConditions.presenceOfElementLocated(importSuccessDiv));
        Assert.assertTrue(getDriver().findElement(importSuccessDiv).getText().contains("Sikeres importálás!"));
        Assert.assertTrue(getDriver().findElement(importSuccessDiv).getText().contains(numberOfImportedProducts + " elem került importálásra"));
    }

    public void jumpToProductsList() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", getDriver().findElement(jumpToProductsListButton));
    }

    public String getTransactionFilePath() {
        Path currentRelativePath = Paths.get("");
        String currentAbsolutePath = currentRelativePath.toAbsolutePath().toString();

        return currentAbsolutePath + GetProperties.getProperty("importfile.path");
    }

    public void navigateToNewProductPageFromListView() {
        elementClick(newProductButton);
    }

    public void clickFirstProductName() {
        elementClick(firstProductName);
    }

    public void editProductFromActions(){
        elementClick(foundNameActions);
        elementClick(editProductButton);
    }

    public void navigateToAttachTab() {
        scrollByPixel(-1000);
        elementClick(attachTab);
    }

    public void checkFileIsAttached(String fileName) {
        if(fileName.equals("")) {
            Assert.assertEquals(0, getDriver().findElements(attachedFile).size());
        }
        else {
            waitUntil(ExpectedConditions.visibilityOfElementLocated(attachedFile));
            Assert.assertEquals(fileName, getDriver().findElement(attachedFile).getText());
        }
    }

    public void uploadFile(GetProperties.UploadFile uploadFile) {
        dropFile(new File(getProductFilePath(uploadFile)), getDriver().findElement(documentDropDownDiv), 0, 0 );
    }
}
