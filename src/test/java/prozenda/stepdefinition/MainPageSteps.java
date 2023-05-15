package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPageSteps {

    Pages pages = new Pages();

    @Then("navigate to Logs page")
    public void navigateToLogsPage() {
        pages.getMainPagePOM().navigateToLogsPage();
    }

    @Then("navigate to Notification settings page")
    public void navigateToNotificationsSettingsPage() {
        pages.getMainPagePOM().navigateToNotificationsSettingsPage();
    }

    @Then("navigate to Settings-General page")
    public void navigateToSettingsGeneralPage() {
        pages.getMainPagePOM().navigateToSettingsGeneralPage();
    }

    @Then("Click on Sale on the left menu")
    public void ClickOnSaleOnTheLeftMenu() {
        pages.getMainPagePOM().clickOnSaleOnTheLeftMenu();
        pages.getMainPagePOM().waitForLoadingReceipts();
    }

    @Then("Click on New customer receipt")
    public void ClickOnNewCustomerReceipt() {
        pages.getMainPagePOM().clickOnNewCustomerReceipt();
    }

    @When("Move over New button")
    public void moveOverNewButton() {
        pages.getMainPagePOM().moveOverNewButton();
    }

    @When("Move over Sale in New button sub menu")
    public void moveOverSaleInNewButtonSubMenu() {
        pages.getMainPagePOM().moveOverSaleButton();
    }

    @When("Click on New customer receipt in New button sub menu")
    public void clickOnNewCustomerReceiptInNewButtonSubMenu() {
        pages.getMainPagePOM().clickOnNewCustomerReceiptInNewButtonSubMenu();
    }
}