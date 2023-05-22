package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 03/05/2023 - 8:56
 * @project SiliconDreams
 */
public class NewPrivatePartnerFromMenu extends UIActions {
    Pages pages = new Pages();

    @Given("Navigate to the new private partner")
    public void navigateToNewPrivatePerson(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().navigateToNewPrivatePartner();
    }

    @Then("Validation the error list")
    public void validationTheErrorList(){
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().waitToAlert();
        pages.getPartnersPagePOM().getErrorList("A(z) név megadása kötelező!A(z) partnerkód megadása kötelező!", "The error alert is contains the required fields!", "The error alert isn't matches the required fields!","The error alert isn't contains the required fields!");
    }

    @Then("Entering the personal data")
    public void addNewPrivatePartner(){
        pages.getPartnersPagePOM().enterTheNewPrivatePersonData();
        pages.getPartnersPagePOM().saveTheNewPartner();
    }

    @Then("Created new private partner validation")
    public void createdPartnerValidation(){
        pages.getPartnersPagePOM().filterByName(testData.getPrivatePartnerName());
        pages.getPartnersPagePOM().getFoundPrivatePartnerName();
    }
}
