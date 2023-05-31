package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import static com.prozenda.selectors.PartnersPage.*;

/**
 * @author Rebeka Alajtner
 * @created 30/05/2023 - 7:03
 * @project SiliconDreams
 */
public class SupplierTypeActiveSwitchCommentFieldCheck extends UIActions {

    Pages pages = new Pages();

    @Then("Create supplier")
    public void createNewCustomerWithRelatesPartner(){
        pages.getPartnersPagePOM().createPartnerFromNewButton(false, false, true);
        pages.getPartnersPagePOM().fillData(createdSupplierPartner, testData.getSupplier());
        pages.getPartnersPagePOM().activeSwitch();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
    }

    @Then("Second type: check active switch on-off status in Receipt module")
    public void checkActivePartnerInReceipt(){
        pages.getPartnersPagePOM().checkActiveSwitchInSupply(testData.getPartnerID(),testData.getPartner(),true);
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName(testPartnerName);
        pages.getPartnersPagePOM().activeSwitch();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
        pages.getPartnersPagePOM().checkActiveSwitchInSupply(testData.getPartnerID(),testData.getPartner(), false);
    }

    @Then ("Second type: back to edit partner")
    public void backToEditPartner(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName(), true);
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName(testPartnerName);
    }
}
