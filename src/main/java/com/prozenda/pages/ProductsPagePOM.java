package com.prozenda.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.prozenda.selectors.ProductsPage.*;

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

    public void filterProduct(String keyword, By column) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(column));
        getDriver().findElement(column).sendKeys(keyword);
    }

    public void checkProductCreated(String title) {
        Assert.assertTrue(getDriver().findElement(productsTable).getText().contains(title));
    }

    public void clickDeleteButton() {
//        waitUntil(ExpectedConditions.elementToBeClickable(allDeleteButton));
        getDriver().findElement(allDeleteButton).click();
    }

    public void clickAcceptDelete() throws InterruptedException {
        wait(4000);
        waitUntil(ExpectedConditions.elementToBeClickable(allDeleteButton));
        getDriver().findElement(acceptDeleteButton).click();
    }
}
