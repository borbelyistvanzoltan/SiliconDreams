package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.testdata.Version;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

/**
 * @author Rebeka Alajtner
 * @created 19/04/2023 - 12:02
 * @project SiliconDreams
 */

public class VersionCheck {
    Pages page = new Pages();
    public static Version version;

    @Given("Version number from JSON")
    public void getVersionFromJSON(){
        try {
            version = new Version().init((JSONObject) new JSONParser().parse(new FileReader("VersionNumber.json")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Compare the version number from JSON with the version number from the application")
    public void getVersionFromHelp(){
        page.getHelpPagePOM().navigateToHelp();
        page.getHelpPagePOM().navigateToAbout();
        page.getHelpPagePOM().getVersionNumber();
    }

    @Then ("Version number validation")
    public void versionNumberValidation(){
        if (version.getVersionNumber().equals(page.getHelpPagePOM().getDs4VersionNumber())){
            System.out.println("The version numbers are matches! - " + page.getHelpPagePOM().getDs4VersionNumber());
            Allure.step("The version numbers are matches! - " + page.getHelpPagePOM().getDs4VersionNumber(), Status.PASSED);
        } else{
            System.err.println("The version numbers do not match!");
            Allure.step("The version numbers do not match!", Status.FAILED);
        }
    }
}
