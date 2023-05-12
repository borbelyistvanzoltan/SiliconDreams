package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 12/05/2023 - 8:52
 * @project SiliconDreams
 */
public class DeleteFromListView extends UIActions {

    Pages pages = new Pages();

    @Then("Filter by name and click delete from actions menu")
    public void selectDeleteFromActions(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().deletePartner();
    }
}
