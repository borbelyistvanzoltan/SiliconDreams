package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 23/05/2023 - 13:17
 * @project SiliconDreams
 */
public class CreateNewCustomerFromListView {

    Pages pages = new Pages();

    @Then("Create new customer from list view")
    public void createNewCustomerFromListView(){
        pages.getPartnersPagePOM().createPartnerFromListView(true, false, false);
    }

}
