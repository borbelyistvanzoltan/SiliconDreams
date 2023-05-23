package prozenda.partnerstepdefinition;

import com.prozenda.Bench;
import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

/**
 * @author Rebeka Alajtner
 * @created 03/05/2023 - 13:41
 * @project SiliconDreams
 */
public class GeneralSteps extends UIActions {
    public static Pages pages = new Pages();
    public static Bench bench;
    @Before
    public static void setUp(){
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
    public static void logoutAndCloseDriver(){
        bench.closeTest();
        bench = null;
    }

    @AfterAll
    public static void checkDeletedPartners(){
        setUp();
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().partnerDeleteCheck();
        pages.getPartnersPagePOM().filterByName(testData.getClonePartnerName());
        pages.getPartnersPagePOM().partnerDeleteCheck();
        pages.getPartnersPagePOM().filterByName(testData.getPrivatePartnerName());
        pages.getPartnersPagePOM().partnerDeleteCheck();
    }

}
