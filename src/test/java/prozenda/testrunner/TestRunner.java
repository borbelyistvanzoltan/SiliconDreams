package prozenda.testrunner;

import com.prozenda.Bench;
import com.prozenda.pages.HelpPagePOM;
import com.prozenda.pages.LoginPagePOM;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import prozenda.versioncheck.VersionCheck;

/**
 * @author Rebeka Alajtner
 * @created 20/04/2023 - 12:13
 * @project SiliconDreams
 */
public class TestRunner {
    public static Bench bench;

    @BeforeTest
    public void setUp(){
        if (Bench.bench == null) {
            new Bench();
        }
        bench = Bench.bench;
        bench.openBrowserTest();
    }

    @Test(priority =  1, description = "Version check")
    public void VersionCheck(){
        LoginPagePOM loginPagePOM = new LoginPagePOM();
        HelpPagePOM helpPagePOM = new HelpPagePOM();
        VersionCheck versionCheck = new VersionCheck();
        loginPagePOM.navigate();
        loginPagePOM.login();
        helpPagePOM.navigateToHelp();
        helpPagePOM.navigateToAbout();
        helpPagePOM.getVersionNumber();
        versionCheck.getVersionFromJSON();
        versionCheck.getVersionFromHelp();
    }
}
