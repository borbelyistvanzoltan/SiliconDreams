package com.prozenda.pages;

import com.prozenda.selectors.NewProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.prozenda.selectors.NewProductPage.*;
import static com.prozenda.utils.UIActions.elementClick;

public class NewProductPagePOM extends AbstractPage {

    public enum ProductType {
        NORMAL(NewProductPage.normalTypeRadioButton),
        SERVICE(NewProductPage.serviceTypeRadioButton);

        private final By typeElement;

        ProductType(By typeElement) {
            this.typeElement = typeElement;
        }

        public By getTypeElement() {

            return this.typeElement;
        }
    }

    public enum AmountUnit {
        HOUR(NewProductPage.hourAmountUnit);

        private final By amountUnitElement;

        AmountUnit(By amountUnitElement) {
            this.amountUnitElement = amountUnitElement;
        }

        public By getAmountUnitElement() {

            return this.amountUnitElement;
        }
    }

    public void fillProductTitle(String productTitle) {
        getDriver().findElement(productTitleInput).sendKeys(productTitle);
    }

    public void clickType(By typeElement) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", getDriver().findElement(typeElement));
    }

    public void selectAmountUnit(By amountUnitElement) {
        getDriver().findElement(amountUnitElement).click();
    }

    public void saveProduct() throws InterruptedException {
        wait(3000);
        getDriver().findElement(saveButton).click();
    }

    public String getErrorList(){
        String list = getDriver().findElement(errorAlert).getAttribute("textContent");
        return list;
    }

    public void confirmDataSheetSelection() {
        elementClick(confirmDataSheetSelectorButton);
    }

    public void createNewProduct(String title, By typeElement, By amountUnitElement) {
        fillProductTitle(title);
        clickType(typeElement);
        selectAmountUnit(amountUnitElement);
    }
}
