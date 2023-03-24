package prozenda.stepdefinition;

import com.prozenda.pages.NewProductPagePOM;
import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

    Pages pages = new Pages();

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        pages.getLoginPagePOM().navigate();
    }

    @Then("login with email and password")
    public void login() {
        pages.getLoginPagePOM().login();
    }

    @Then("login with email and password, invalid credentials")
    public void loginNegative() {
        pages.getLoginPagePOM().loginNegative();
    }

    @Then("navigate to New Product page")
    public void navigateToNewProductPage() {
        pages.getControlPanelPagePOM().clickProductsToggle();
        pages.getControlPanelPagePOM().clickNewProductButton();
    }

    @Then("navigate to All Products page")
    public void navigateToAllProductsPage() {
        pages.getControlPanelPagePOM().clickProductsToggle();
        pages.getControlPanelPagePOM().clickAllProductsButton();
        System.out.println("w");
    }

    @Then("navigate back to All Products page")
    public void navigateBackToAllProductsPage() {
        pages.getControlPanelPagePOM().clickBackToAllProductsListButton();
    }
}
