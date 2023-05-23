package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 08/05/2023 - 7:32
 * @project SiliconDreams
 */
public class NewPrivatePartnerFromListView {
    Pages pages = new Pages();

    @Then("Navigate to the new private partner from list view")
    public void navigateToNewPrivatePartnerFromListView(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().createPartnerFromListView(false, false, true);
    }
}
