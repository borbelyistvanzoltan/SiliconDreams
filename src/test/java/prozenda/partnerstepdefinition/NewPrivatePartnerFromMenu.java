package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.junit.Assert;

/**
 * @author Rebeka Alajtner
 * @created 03/05/2023 - 8:56
 * @project SiliconDreams
 */
public class NewPrivatePartnerFromMenu extends UIActions {
    Pages pages = new Pages();

    @Given("Navigate to the new private partner")
    public void navigateToNewPrivatePerson(){
        pages.getPartnersPagePOM().navigateToPartnersModule();
        pages.getPartnersPagePOM().navigateToNewPrivatePartner();
    }

    @Then("Validation the error list")
    public void validationTheErrorList(){
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().waitToAlert();
        if (pages.getPartnersPagePOM().getErrorList().equals("A(z) név megadása kötelező!A(z) partnerkód megadása kötelező!")){
            System.out.println("The error alert is contains the required fields!");
            Allure.step("The error alert is visible - contains the required fields!", Status.PASSED);
        }else if (pages.getPartnersPagePOM().getErrorList().equals("")) {
            Allure.step("The error alert isn't contains the required fields!", Status.FAILED);
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        } else{
            Allure.step("The error alert isn't matches the required fields!", Status.FAILED);
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
    }

    @Then("Entering the personal data")
    public void addNewPrivatePartner(){
        pages.getPartnersPagePOM().enterTheNewPrivatePersonData();
        pages.getPartnersPagePOM().saveTheNewPartner();
    }

    @Then("Created new private partner validation")
    public void createdPartnerValidation(){
        pages.getPartnersPagePOM().filterByName(testData.getPrivatePartnerName());
        if (pages.getPartnersPagePOM().getFoundPrivatePartnerName().equals(testData.getPrivatePartnerName())){
            System.out.println("Successful created the private partner!");
            Allure.step("Successful created the private partner!", Status.PASSED);
        } else {
            Assert.fail("Unsuccessful created the private partner!");
            Allure.step("Unsuccessful created the private partner!", Status.FAILED);
            Allure.addAttachment("Create new private partner", takeScreenshot());
        }
    }
}
