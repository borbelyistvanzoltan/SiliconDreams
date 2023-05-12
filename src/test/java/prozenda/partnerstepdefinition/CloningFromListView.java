package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

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
    public void getPartnerName(){
        partnerName = pages.getPartnersPagePOM().getPartnerName();
        pages.getPartnersPagePOM().createNewPartnerByClone();
        pages.getPartnersPagePOM().filterByName(testData.getClonePartnerName());
        pages.getPartnersPagePOM().editPartnerFromActions();
    }

    @Then("Check the cloned partner")
    public void checkTheClonedPartner(){
        String whichCloned = partnerName;
        partnerName = pages.getPartnersPagePOM().getPartnerName();
        if (!whichCloned.equals(partnerName) && partnerName.equals(testData.getClonePartnerName())){
            System.out.println("The partner has been created by cloning from list view!");
            Allure.step("The partner has been created by cloning from list view!", Status.PASSED);
        } else if (whichCloned.equals(partnerName)){
            System.err.println("The cloning is unsuccessful! - the partner name is same!");
            Allure.step("The cloning is unsuccessful! - the partner name is same!", Status.FAILED);
            Allure.addAttachment("The cloning is unsuccessful!", takeScreenshot());
        } else {
            System.err.println("The cloning is unsuccessful!");
            Allure.step("The cloning is unsuccessful!", Status.FAILED);
            Allure.addAttachment("The cloning is unsuccessful!", takeScreenshot());
        }
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
        if( !pages.getPartnersPagePOM().partnerDeleteCheck().equals("Nincs a keresésnek megfelelő találat")){
            pages.getPartnersPagePOM().deletePartner();
        }
    }
}
