package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ControlPanelPageSteps {

    Pages pages = new Pages();

    @Given("Wait for loading main page")
    public void waitForMainPage() {
        pages.getControlPanelPagePOM().waitForLoadingMainPage();
    }

    @Then("Navigate to Settings-Company details")
    public void navigateToCompanyDetails() {
        pages.getControlPanelPagePOM().navigateToCompanyDetails();
    }

    @Then("Click on Addresses")
    public void clickOnAddresses() {
        pages.getControlPanelPagePOM().clickOnAddresses();
    }


}
