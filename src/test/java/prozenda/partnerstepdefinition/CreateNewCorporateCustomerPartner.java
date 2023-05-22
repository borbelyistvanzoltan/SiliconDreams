package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 02/05/2023 - 15:08
 * @project SiliconDreams
 */
public class CreateNewCorporateCustomerPartner extends UIActions{
    Pages pages = new Pages();

    @Then("Check the created partner")
    public void checkTheCreatedPartner(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().checkTheCreatedPartner();
    }
}
