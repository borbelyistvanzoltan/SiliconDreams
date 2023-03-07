package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

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
}