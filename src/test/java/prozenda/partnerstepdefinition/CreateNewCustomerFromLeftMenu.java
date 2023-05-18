package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import static com.prozenda.selectors.PartnersPage.*;

/**
 * @author Rebeka Alajtner
 * @created 15/05/2023 - 6:51
 * @project SiliconDreams
 */
public class CreateNewCustomerFromLeftMenu extends UIActions {

    Pages pages = new Pages();

    @Given("Navigate to new customer from left menu")
    public void navigateNewCustomer(){
        pages.getPartnersPagePOM().navigateNewCustomer();
    }

    @Then("Check error message")
    public void errorMessageCheck(){
        pages.getPartnersPagePOM().saveTheNewPartner();
        pages.getPartnersPagePOM().waitToAlert();
        if (pages.getPartnersPagePOM().getErrorList().equals("A(z) név megadása kötelező!\nA(z) partnerkód megadása kötelező!\nEgy elsődleges székhely típusú cím megadása kötelező!\nAz adószám megadása kötelező, ha a partner tagsága belföld!")){
            System.out.println("The error alert is contains the required fields! - the tax number is required fields too");
            Allure.step("The error alert is visible - contains the required fields! - the tax number is required field too", Status.PASSED);
        }else if (pages.getPartnersPagePOM().getErrorList().equals("") && !pages.getPartnersPagePOM().getErrorList().contains("Az adószám megadása kötelező, ha a partner tagsága belföld!")) {
            Allure.step("The error alert isn't contains the required fields! - the tax number not required field", Status.FAILED);
            System.err.println("The error alert isn't contains the required fields! - the tax number not required field");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        } else{
            Allure.step("The error alert isn't matches the required fields!", Status.FAILED);
            System.err.println("The error alert isn't matches the required fields!");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
    }

    @Then ("Check required fields - partner name")
    public void checkPartnerName(){
        pages.getPartnersPagePOM().requiredFieldsCheck(true, false);
        if (pages.getPartnersPagePOM().getErrorList().equals("A(z) nev megadása kötelező!")){
            System.out.println("The partner name is required field!");
            Allure.step("The partner name is required field!", Status.PASSED);
        } else if(pages.getPartnersPagePOM().getErrorList().equals("")) {
            Allure.step("The partner name is optional!", Status.FAILED);
            System.err.println("The partner name is optional!");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        } else{
            Allure.step("The partner name is optional!", Status.FAILED);
            System.err.println("The partner name is optional!");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
    }

    @Then("Check required fields - partner id")
    public void checkPartnerId(){
        pages.getPartnersPagePOM().requiredFieldsCheck(false, true);
        if (pages.getPartnersPagePOM().getErrorList().equals("A(z) partnerkod megadása kötelező!")){
            System.out.println("The partner id is required field!");
            Allure.step("The partner id is required field!", Status.PASSED);
        } else if (pages.getPartnersPagePOM().getErrorList().equals("")){
            Allure.step("The partner id is optional!", Status.FAILED);
            System.err.println("The partner id is optional!");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        } else{
            Allure.step("The partner id is optional!", Status.FAILED);
            System.err.println("The partner id is optional!");
            Allure.addAttachment("The partner id is optional!" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
    }

    @Then ("Check required fields - membership, domestic")
    public void checkDomestic(){
        pages.getPartnersPagePOM().fillPartnerId();
        pages.getPartnersPagePOM().checkMembership(true, false, false);

        if(pages.getPartnersPagePOM().checkErrorAlertVisible() == true){
                if (pages.getPartnersPagePOM().getErrorList().contains("Az adószám megadása kötelező, ha a partner tagsága belföld!")){
                System.out.println("The error alert is contains the tax number alert!");
                Allure.step("The error alert is contains the tax number alert!", Status.PASSED);
            } else{
                Allure.step("The error alert doesn't contains the tax number alert!", Status.FAILED);
                System.err.println("The error alert doesn't contains the tax number alert!");
                Allure.addAttachment("The error alert doesn't contains the tax number alert!" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
            }
        } else if(pages.getPartnersPagePOM().checkErrorAlertVisible() == false){
            if (pages.getPartnersPagePOM().getSuccessfulSaveMessage(backToEdit).equals("Sikeres mentés!")){
                Allure.step("The partner is saved!", Status.FAILED);
                System.err.println("The partner is saved!");
                Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
            }
        }
    }

    @Then ("Check required fields - membership, EU")
    public void checkEu(){
        pages.getPartnersPagePOM().checkMembership(false, true, false);
        if(pages.getPartnersPagePOM().checkErrorAlertVisible() == true){
            if (pages.getPartnersPagePOM().getErrorList().contains("A partner EU Adószám megadása kötelező, ha a partner tagsága EU!")){
                System.out.println("The error alert is contains the tax number alert!");
                Allure.step("The error alert is contains the tax number alert!", Status.PASSED);
            } else{
                Allure.step("The error alert doesn't contains the tax number alert!", Status.FAILED);
                System.err.println("The error alert doesn't contains the tax number alert!");
                Allure.addAttachment("The error alert doesn't contains the tax number alert!" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
            }
        } else if(pages.getPartnersPagePOM().checkErrorAlertVisible() == false){
            if (pages.getPartnersPagePOM().getSuccessfulSaveMessage(continueEdit).equals("Sikeres mentés!")){
                Allure.step("The partner is saved!", Status.FAILED);
                System.err.println("The partner is saved!");
                Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
            }
        }
    }

    @Then ("Check required fields - membership, non EU")
    public void checkNonEu(){
        pages.getPartnersPagePOM().checkMembership(false, false, true);
        if(pages.getPartnersPagePOM().checkErrorAlertVisible() == true){
            if (pages.getPartnersPagePOM().getErrorList().contains("Az adószám megadása kötelező")){
                System.out.println("The error alert is contains the tax number alert!");
                Allure.step("The error alert is contains the tax number alert!", Status.PASSED);
            } else{
                Allure.step("The error alert doesn't contains the tax number alert!", Status.FAILED);
                System.err.println("The error alert doesn't contains the tax number alert!");
                Allure.addAttachment("The error alert doesn't contains the tax number alert!" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
            }
        } else if(pages.getPartnersPagePOM().checkErrorAlertVisible() == false){
            if (pages.getPartnersPagePOM().getSuccessfulSaveMessage(continueEdit).equals("Sikeres mentés!")){
                Allure.step("The partner is saved!", Status.FAILED);
                System.err.println("The partner is saved!");
                Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
            }
        }
    }

    @Then ("Check required fields - type")
    public void checkType(){
        pages.getPartnersPagePOM().saveWithoutType();
        if(pages.getPartnersPagePOM().getErrorList().contains("Az adószám megadása kötelező, ha a partner tagsága belföld!")){
            System.out.println("The error alert is contains the required fields!");
            Allure.step("The error alert is visible - contains the required fields!", Status.PASSED);
        }else if (pages.getPartnersPagePOM().getErrorList().equals("")) {
            Allure.step("The error alert isn't contains the required fields!", Status.FAILED);
            System.err.println("The error alert isn't contains the required fields!");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        } else{
            Allure.step("The error alert isn't matches the required fields!", Status.FAILED);
            System.err.println("The error alert isn't matches the required fields!");
            Allure.addAttachment("Error alert" + pages.getPartnersPagePOM().getErrorList(), takeScreenshot());
        }
        pages.getPartnersPagePOM().navigateToPartnersModule();
    }
}
