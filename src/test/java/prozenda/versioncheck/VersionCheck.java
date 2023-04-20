package prozenda.versioncheck;

import com.prozenda.pages.HelpPagePOM;
import com.prozenda.testdata.Version;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

/**
 * @author Rebeka Alajtner
 * @created 19/04/2023 - 12:02
 * @project SiliconDreams
 */

public class VersionCheck {
    public static Version version;

    @Given("Version number from JSON")
    public void getVersionFromJSON(){
        try {
            version = new Version().init((JSONObject) new JSONParser().parse(new FileReader("VersionNumber.json")));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(version.getVersionNumber());
        }
    }

    @Then("Version number validation")
    public void getVersionFromHelp(){
        HelpPagePOM helpPagePOM = new HelpPagePOM();
        helpPagePOM.navigateToHelp();
        helpPagePOM.navigateToAbout();
        helpPagePOM.getVersionNumber();
        if (version.getVersionNumber().equals(helpPagePOM.getDs4VersionNumber())){
            System.out.println("The version numbers are matches! - " + helpPagePOM.getDs4VersionNumber());
        } else{
            System.err.println("The version numbers do not match!");
        }
    }
}
