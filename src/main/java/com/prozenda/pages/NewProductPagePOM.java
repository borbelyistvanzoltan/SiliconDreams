package com.prozenda.pages;

import com.prozenda.selectors.NewProductPage;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.prozenda.selectors.NewProductPage.*;
import static com.prozenda.utils.UIActions.*;

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
        setText(productTitleInput, productTitle, true);
    }

    public void clickType(By typeElement) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", getDriver().findElement(typeElement));
    }

    public void selectAmountUnit(By amountUnitElement) {
        elementClick(amountUnitElement);
    }

    public void saveProduct() throws InterruptedException {
        wait(3000);
        elementClick(saveButton);
    }

    public String getErrorList(){

        return  getDriver().findElement(errorAlert).getAttribute("textContent");
    }

    public void validateErrorList(String expectedErrors) {
        if (getErrorList().equals(expectedErrors)){
            System.out.println("The error alert is contains the required fields!");
            Allure.step("The error alert is visible - contains the required fields!", Status.PASSED);
        }else if (getErrorList().equals("")) {
            Allure.step("The error alert isn't contains the required fields!", Status.FAILED);
            Allure.addAttachment("Error alert" + getErrorList(), takeScreenshot());
        } else{
            Allure.step("The error alert isn't matches the required fields!", Status.FAILED);
            Allure.addAttachment("Error alert" + getErrorList(), takeScreenshot());
        }
    }

    public void confirmDataSheetSelection() {
        elementClick(confirmDataSheetSelectorButton);
    }

    public void createNewProduct(String title, By typeElement, By amountUnitElement) throws InterruptedException {
        fillProductTitle(title);
        clickType(typeElement);
        selectAmountUnit(amountUnitElement);
        saveProduct();
    }
}
