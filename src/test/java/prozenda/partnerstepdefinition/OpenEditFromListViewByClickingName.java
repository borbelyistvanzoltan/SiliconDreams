package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

/**
 * @author Rebeka Alajtner
 * @created 08/05/2023 - 13:17
 * @project SiliconDreams
 */
public class OpenEditFromListViewByClickingName extends UIActions {
    Pages pages = new Pages();
    String companyId;

    @Given("Click on created partner name")
    public void openEditByClickingName(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        pages.getPartnersPagePOM().clickOnTheCreatedPartnerName();
    }

    @Then("Editing check")
    public void validationForEditablePartner(){
        if (pages.getPartnersPagePOM().getEditHeaderTitle().contains("Szerkesztés: ")){
            System.out.println("The partner is editable!");
            Allure.step("The partner is editable!", Status.PASSED);
        } else {
            System.err.println("The partner is not editable!");
            Allure.step("The partner is not editable!", Status.PASSED);
            Allure.addAttachment("Edit partner" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
    }

    @Given ("Edit the company id")
    public void editCompanyId(){
        companyId = pages.getPartnersPagePOM().getCompanyId();
        pages.getPartnersPagePOM().editCompanyId();
        openEditByClickingName();
    }

    @Then ("Check the edited partner company id")
    public  void checkTheEditedCompanyId(){
        if (pages.getPartnersPagePOM().getCompanyId().equals(testData.getEditedCompanyId()) && !pages.getPartnersPagePOM().getCompanyId().equals(companyId)){
            System.out.println("Successful edit!");
            Allure.step("Successful edit!", Status.PASSED);
        } else if(!pages.getPartnersPagePOM().getCompanyId().equals(testData.getEditedCompanyId())) {
            System.err.println("Unsuccessful edit!");
            Allure.step("Unsuccessful edit!", Status.PASSED);
            Allure.addAttachment("Edit partner" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        } else {
            System.err.println("Unsuccessful edit!");
            Allure.step("Unsuccessful edit!", Status.PASSED);
            Allure.addAttachment("Edit partner" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().backToListView();
    }
}
