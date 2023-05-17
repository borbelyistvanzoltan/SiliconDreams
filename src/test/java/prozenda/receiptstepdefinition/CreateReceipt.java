package prozenda.receiptstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.selectors.CustomerReceiptListViewPage;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateReceipt extends UIActions {
    Pages pages = new Pages();

    @Then("Select default data sheet")
    public void selectDefaultDataSheet() {
        pages.getReceiptPagePOM().clickOkButtonOnDataSheet();
    }

    @Then("Save form")
    public void saveForm() {
        pages.getReceiptPagePOM().clickSaveButton();
    }

    @Then("Asserting alert form")
    public void assertingAlertForm() throws InterruptedException {
        pages.getReceiptPagePOM().assertingAlertForm();
    }

    @Then("Wait for loading data sheet chooser")
    public void waitForLoadingDataSheetChooser() {
        pages.getReceiptPagePOM().waitForLoadingDataSheetChooser();
    }

    @Then("Select {string} from dropdown list")
    public void selectFromDropdownList(String formName) {
        pages.getReceiptPagePOM().selectFromDropdownList(formName);
    }

    @Then("Click Ok button")
    public void clickOkButton() {
        pages.getReceiptPagePOM().clickOkButtonOnDataSheet();
    }

    @Then("Wait for loading Receipt page")
    public void waitForLoadingReceiptPage() throws InterruptedException {
        pages.getReceiptPagePOM().waitForLoadingReceiptPage();
    }

    @Then("Select {string} bizonylattomb")
    public void selectBizonylattomb(String bizonylattomb) {
        pages.getReceiptPagePOM().selectBizonylattomb(bizonylattomb);
    }

    @Then("Type {string} into customer field")
    public void typeCustomerName(String customerName) {
        pages.getReceiptPagePOM().typeCustomerName(customerName);
    }

    @Then("Type {string} into item field")
    public void typeIntoItemField(String itemName) {
        pages.getReceiptPagePOM().typeIntoItemField(itemName);
    }

    @Then("Select {string}")
    public void selectRaktar(String raktar) {
        pages.getReceiptPagePOM().selectRaktar(raktar);
    }

    @Then("Assert form saved successfully")
    public void assertFormSavedSuccessfully() {
        pages.getReceiptPagePOM().assertFormSavedSuccessfully();
    }

    @When("Click on + button in list view")
    public void clickOnPlusButtonInListView() {
        pages.getCustomerReceiptListViewPagePOM().clickOnPlusButtonInListView();
    }

    @Then("Navigate back to list view")
    public void navigateBackToListView() {
        pages.getReceiptPagePOM().navigateBackToListView();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(CustomerReceiptListViewPage.plusButton));
    }


}
