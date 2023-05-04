package prozenda.partnerstepdefinition;

import com.prozenda.Bench;
import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * @author Rebeka Alajtner
 * @created 03/05/2023 - 13:41
 * @project SiliconDreams
 */
public class GeneralSteps extends UIActions {
    Pages pages = new Pages();
    public static Bench bench;
    @Before
    public void setUp(){
        readTheTestData();
        if (Bench.bench == null) {
            new Bench();
        }
        bench = Bench.bench;
        bench.openBrowserTest();
        pages.getLoginPagePOM().navigate();
        pages.getLoginPagePOM().login();
    }

    @After
    public void logoutAndCloseDriver(){
        bench.closeTest();
        bench = null;
    }
}
