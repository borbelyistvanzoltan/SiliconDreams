package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;

/**
 * @author Rebeka Alajtner
 * @created 05/05/2023 - 7:59
 * @project SiliconDreams
 */
public class NewPrivatePartnerFromNewButton extends UIActions {
    Pages pages = new Pages();
    @Given("Navigate to the new private partner from New button")
    public void navigateToNewPrivatePerson(){
        pages.getPartnersPagePOM().createPrivatePartnerFromNewButton();
    }
}
