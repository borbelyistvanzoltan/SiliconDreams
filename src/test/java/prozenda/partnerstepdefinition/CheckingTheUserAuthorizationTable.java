package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 02/05/2023 - 15:07
 * @project SiliconDreams
 */
public class CheckingTheUserAuthorizationTable extends UIActions {
    Pages pages = new Pages();

    @Given("Navigate to the partners module and click the all partners")
    public void navigateToAllPartners(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
    }

    @Then("Navigate the users permission")
    public void navigateToUsersPermission(){
        pages.getPartnersPagePOM().navigateToUsersPermission();
    }

    @Then("Give the user all permission")
    public void checkPermissionOfTheCurrentUser(){
        pages.getPartnersPagePOM().searchUser();
        pages.getPartnersPagePOM().checkUserPermission();
    }

    @Then("View the partners list")
    public void viewPartners(){
        pages.getPartnersPagePOM().viewPartnersList();
    }

    @Then ("Create new partner")
    public void createPartners(){
        pages.getPartnersPagePOM().createNewPartner();
    }

    @Then("Create partner - get the text from message - successful or unsuccessful")
    public void successfulSave(){
        pages.getPartnersPagePOM().getSuccessfulSaveMessage();
    }

    @Then("Edit the partner")
    public void editPartner(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().editPartner();
    }

    @Then("Edit partner - get the text from message - successful or unsuccessful")
    public void successfulEditSave(){
        pages.getPartnersPagePOM().getSuccessfulSaveMessage();
    }

    @Then("Delete partner")
    public void deletePartner(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().deletePartner();
        pages.getPartnersPagePOM().getDeleteMessage();
    }

    @Then("Delete partner - get the text from message - successful or unsuccessful")
    public void successfulDeleteMessage(){
        pages.getPartnersPagePOM().getDeleteMessage();
    }

    @Then("Check the delete")
    public void deleteCheck(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName(), true);
        pages.getPartnersPagePOM().partnerDeleteCheck();
    }
}
