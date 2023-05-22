package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


/**
 * @author Rebeka Alajtner
 * @created 19/04/2023 - 12:02
 * @project SiliconDreams
 */

public class VersionCheck {
    Pages pages = new Pages();

    @Given("Version number from JSON")
    public void getVersionFromJSON(){
       pages.getHelpPagePOM().getValidVersionNumber();
    }

    @Then("Compare the version number from JSON with the version number from the application")
    public void getVersionFromHelp(){
        pages.getHelpPagePOM().navigateToHelp();
        pages.getHelpPagePOM().navigateToAbout();
        pages.getHelpPagePOM().getVersionNumber();
    }

    @Then ("Version number validation")
    public void versionNumberValidation(){
     pages.getHelpPagePOM().compareVersionNumber();
    }
}
