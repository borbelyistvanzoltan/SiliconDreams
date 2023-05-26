package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 24/05/2023 - 8:41
 * @project SiliconDreams
 */
public class CustomerTypeActiveSwitchCommentFieldCheck extends UIActions {
    Pages pages = new Pages();
    @Then("Create customer")
    public void createNewCustomerWithRelatesPartner(){
        pages.getPartnersPagePOM().createPartnerFromNewButton(false, true, false);
        pages.getPartnersPagePOM().fillData(testData.getPartnerID());
        pages.getPartnersPagePOM().activeSwitch();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
    }
    @Then("Check active switch on-off status in Receipt module")
        public void checkActivePartnerInReceipt(){
        pages.getPartnersPagePOM().checkActiveSwitchInReceipt(true);
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName();
        pages.getPartnersPagePOM().activeSwitch();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
        pages.getPartnersPagePOM().checkActiveSwitchInReceipt(false);
    }
    @Then ("Back to edit partner")
    public void backToEditPartner(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName(), true);
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName();
    }
    @Then("Add new related partner and save without comment")
    public void checkAlert(){
        pages.getPartnersPagePOM().navigateToRelatedPartner();
        pages.getPartnersPagePOM().addNewRelatedPartner();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().getErrorList("A(z) kapcsolódó partner megjegyzés megadása kötelező, ha a(z) kapcsolódó partner megjegyzés kapcsoló értéke 1!","The missing comment alert is visible!","The comment field is optional","The comment field is optional");
    }
    @Then("Fill the comment field")
    public void fillComment(){
        pages.getPartnersPagePOM().addComment(testData.getComment());
        pages.getPartnersPagePOM().saveTheNewPartner();
    }
}
