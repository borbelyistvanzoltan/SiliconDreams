package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

import static com.prozenda.selectors.PartnersPage.*;

/**
 * @author Rebeka Alajtner
 * @created 01/06/2023 - 7:07
 * @project SiliconDreams
 */
public class PrivatePartnerActiveSwitchCommentFieldCheck extends UIActions {

    Pages pages = new Pages();

    @Then("Create private partner")
    public void createPrivatePartner(){
        pages.getPartnersPagePOM().createPartnerFromNewButton(true, false, false);
        pages.getPartnersPagePOM().enterTheNewPrivatePersonData();
        pages.getPartnersPagePOM().activeSwitch();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
    }

    @Then("Third type: check active switch on-off status in Receipt module")
    public void checkActivePartnerInReceipt(){
        pages.getPartnersPagePOM().checkActiveSwitchInReceipt(testData.getPrivatePartnerName(),testData.getPrivatePartnerName(),true);
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getPrivatePartnerName());
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName(createdPrivatePartner);
        pages.getPartnersPagePOM().activeSwitch();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
        pages.getPartnersPagePOM().checkActiveSwitchInReceipt(testData.getPrivatePartnerName(),testData.getPrivatePartnerName(),false);
    }
    @Then ("Third type: back to edit partner")
    public void backToEditPartner(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName(), true);
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName(createdPrivatePartner);
    }

}
