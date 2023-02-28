package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;

public class LoginPageSteps {

    Pages pages = new Pages();

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        pages.getLoginPagePOM().navigate();
    }
}
