package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import static com.prozenda.selectors.PartnersPage.*;

/**
 * @author Rebeka Alajtner
 * @created 01/06/2023 - 9:45
 * @project SiliconDreams
 */
public class AddTwiceSameRelatedPartnerSameType extends UIActions {

    Pages pages = new Pages();

    @Then("Create new private partner and related partner")
    public void createPartners(){
        pages.getPartnersPagePOM().createPartnerFromNewButton(true, false, false);
        pages.getPartnersPagePOM().enterTheNewPrivatePersonData();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
        pages.getPartnersPagePOM().createPrivateRelatedPartner();
    }

    @Then("Add created related partner to created private partner")
    public void addCreatedRelatedPartner(){
        pages.getPartnersPagePOM().filterByName(testData.getPrivatePartnerName());
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName(createdPrivatePartner);
        pages.getPartnersPagePOM().navigateToRelatedPartner();
        pages.getPartnersPagePOM().addNewRelatedPartner(true, testData.getRelatedPartnerName());
        pages.getPartnersPagePOM().addComment(testData.getComment());
    }

    @Then ("Add second related partner - same related partner")
    public void addSameRelatedPartner(){
        pages.getPartnersPagePOM().addNewRelatedPartner(true, testData.getRelatedPartnerName());
    }

    @Then("The same related partner save - warning message validation")
    public void checkAlert(){
        pages.getPartnersPagePOM().relatedPartnerWarningMessage("már benne van a kapcsolatokban","The warning alert is visible! - cannot add the same partner more than once as a related partner","The warning alert is not visible!", "Same related partners", true);
    }

    @Then ("Delete created partner and related partner")
    public void deletePartners(){
        pages.getPartnersPagePOM().filterByName(testData.getRelatedPartnerName());
        pages.getPartnersPagePOM().deletePartner();
        pages.getPartnersPagePOM().refreshPage();
        pages.getPartnersPagePOM().filterByName(testData.getPrivatePartnerName());
        pages.getPartnersPagePOM().deletePartner();
    }
}
