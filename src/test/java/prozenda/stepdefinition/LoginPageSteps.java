package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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
}
