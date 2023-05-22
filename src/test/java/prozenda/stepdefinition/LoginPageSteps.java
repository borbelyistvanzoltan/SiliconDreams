package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.prozenda.selectors.ControlPanelPage.allProductsButton;

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
        pages.getNewProductPagePOM().confirmDataSheetSelection();
    }

    @Then("navigate to New Product page from New button")
    public void navigateToNewProductPageFromNewButton() {
        pages.getMainPagePOM().navigateToNewProductPageFromNewButton();
        pages.getNewProductPagePOM().confirmDataSheetSelection();
    }

    @Then("navigate to New Product page from list view")
    public void navigateToNewProductPageFromListView() {
        pages.getProductsPagePOM().navigateToNewProductPageFromListView();
        pages.getNewProductPagePOM().confirmDataSheetSelection();
    }

    @Then("navigate to All Products page")
    public void navigateToAllProductsPage() {
        if(!pages.getControlPanelPagePOM().isOpenProductsToggle()) {
            pages.getControlPanelPagePOM().clickProductsToggle();
        }
        pages.getControlPanelPagePOM().clickAllProductsButton();
    }

    @Then("navigate back to All Products page")
    public void navigateBackToAllProductsPage() {
        pages.getControlPanelPagePOM().clickBackToAllProductsListButton();
    }
}
