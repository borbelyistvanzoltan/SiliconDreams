package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static com.prozenda.selectors.PartnersPage.*;


/**
 * @author Rebeka Alajtner
 * @created 15/05/2023 - 6:51
 * @project SiliconDreams
 */
public class CreateNewCustomerFromLeftMenu extends UIActions {

    Pages pages = new Pages();

    @Given("Navigate to new customer from left menu")
    public void navigateNewCustomer(){
        pages.getPartnersPagePOM().navigateNewCustomer();
    }

    @Then("Check error message")
    public void errorMessageCheck(){
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().waitToAlert();
        pages.getPartnersPagePOM().getErrorList("A(z) név megadása kötelező!\nA(z) partnerkód megadása kötelező!\nEgy elsődleges székhely típusú cím megadása kötelező!\nAz adószám megadása kötelező, ha a partner tagsága belföld!", "The error alert is visible - contains the required fields! - the tax number is required field too","The error alert isn't matches the required fields!","The error alert isn't contains the required fields! - the tax number not required field");
    }

    @Then ("Check required fields - partner name")
    public void checkPartnerName(){
        pages.getPartnersPagePOM().requiredFieldsCheck(true, false);
        pages.getPartnersPagePOM().getErrorList("A(z) nev megadása kötelező!","The partner name is required field!","The partner name is optional!","The partner name is optional!");
    }

    @Then("Check required fields - partner id")
    public void checkPartnerId(){
        pages.getPartnersPagePOM().requiredFieldsCheck(false, true);
        pages.getPartnersPagePOM().getErrorList("A(z) partnerkod megadása kötelező!", "The partner id is required field!","The partner id is optional!","The partner id is optional!");
    }

    @Then ("Check required fields - membership, domestic")
    public void checkDomestic(){
        pages.getPartnersPagePOM().fillPartnerId();
        pages.getPartnersPagePOM().checkMembership(true, false, false);
        pages.getPartnersPagePOM().alertCheckValidation("Az adószám megadása kötelező, ha a partner tagsága belföld!","The error alert is contains the tax number alert!","The error alert doesn't contains the tax number alert!", backToEdit);

    }

    @Then ("Check required fields - membership, EU")
    public void checkEu(){
        pages.getPartnersPagePOM().checkMembership(false, true, false);
        pages.getPartnersPagePOM().alertCheckValidation("A partner EU Adószám megadása kötelező, ha a partner tagsága EU!","The error alert is contains the tax number alert!","The error alert doesn't contains the tax number alert!", continueEdit);
    }

    @Then ("Check required fields - membership, non EU")
    public void checkNonEu(){
        pages.getPartnersPagePOM().checkMembership(false, false, true);
        pages.getPartnersPagePOM().alertCheckValidation("adószám megadása kötelező","The error alert is contains the tax number alert!","The error alert doesn't contains the tax number alert!",continueEdit);
    }

    @Then ("Check required fields - type")
    public void checkType(){
        pages.getPartnersPagePOM().saveWithoutType();
        pages.getPartnersPagePOM().getErrorList("A(z) tipus megadása kötelező!", "The error alert is contains the required fields! - type","The partner type is optional!","The partner type is optional!");
        pages.getPartnersPagePOM().clickAllPartner();
    }

    @Then("Check created new customer")
    public void checkCreatedNewCustomer(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().checkTheCreatedPartner();
    }
}
