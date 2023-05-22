package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 11/05/2023 - 8:19
 * @project SiliconDreams
 */
public class CloningFromListView extends UIActions {
    Pages pages = new Pages();
    String partnerName;

    @Then("Click on clone from actions menu")
    public void navigateToCloning(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().clickOnCloning();
    }

    @Then("Create new partner by clone")
    public void getCreatedPartnerName(){
        partnerName = pages.getPartnersPagePOM().getPartnerName();
        pages.getPartnersPagePOM().createNewPartnerByClone();
        pages.getPartnersPagePOM().filterByName(testData.getClonePartnerName());
        pages.getPartnersPagePOM().editPartnerFromActions();
    }

    @Then("Check the cloned partner")
    public void checkTheClonedPartner(){
        String whichCloned = partnerName;
        partnerName = pages.getPartnersPagePOM().getPartnerName();
        pages.getPartnersPagePOM().checkCloning(whichCloned, partnerName);
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
    }

    @Then ("Delete the cloned partner")
    public void deleteTheClonedPartner(){
        pages.getPartnersPagePOM().filterByName(testData.getClonePartnerName());
        pages.getPartnersPagePOM().deletePartner();
        pages.getPartnersPagePOM().getDeleteMessage();
    }

    @Then("Check the cloned partner delete")
    public void deleteCheck(){
        pages.getPartnersPagePOM().filterByName(testData.getClonePartnerName());
        pages.getPartnersPagePOM().partnerDeleteCheck();
    }
}
