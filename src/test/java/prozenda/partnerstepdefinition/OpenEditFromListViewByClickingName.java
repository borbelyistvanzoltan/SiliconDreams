package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

/**
 * @author Rebeka Alajtner
 * @created 08/05/2023 - 13:17
 * @project SiliconDreams
 */
public class OpenEditFromListViewByClickingName extends UIActions {
    Pages pages = new Pages();

    @Then("Click on created partner name")
    public void openEditByClickingName(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName();
    }

    @Then("Editing check")
    public void validationForEditablePartner(){
        pages.getPartnersPagePOM().getEditHeaderTitle();
    }

    @Then ("Edit the company id")
    public void editCompanyId(){
        pages.getPartnersPagePOM().editCompanyId();
        openEditByClickingName();
    }

    @Then ("Check the edited partner company id")
    public  void checkTheEditedCompanyId(){
        pages.getPartnersPagePOM().getCompanyId();
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
    }
}
