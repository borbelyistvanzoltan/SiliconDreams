package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 23/05/2023 - 9:20
 * @project SiliconDreams
 */
public class CreateNewCustomerFromNewButton {
    Pages pages = new Pages();

    @Then("Create new customer from New button")
    public void createNewCustomerFromNewButton(){
        pages.getPartnersPagePOM().createPartnerFromNewButton(false, true, false);
    }
}
