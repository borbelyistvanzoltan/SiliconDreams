package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 10/05/2023 - 11:33
 * @project SiliconDreams
 */
public class OpenEditFromListViewByClickingOnActions extends UIActions {
    Pages pages = new Pages();

    @Then("Edit the partner from actions menu")
    public void editPartner(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().editPartnerFromActions();
    }
}
