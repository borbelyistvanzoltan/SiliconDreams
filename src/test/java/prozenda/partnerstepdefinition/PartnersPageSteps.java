package prozenda.partnerstepdefinition;

import com.prozenda.Bench;
import com.prozenda.pages.Pages;
import com.prozenda.testdata.TestData;
import com.prozenda.utils.UIActions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;

/**
 * @author Rebeka Alajtner
 * @created 21/04/2023 - 13:23
 * @project SiliconDreams
 */
public class PartnersPageSteps extends UIActions {
    Pages pages = new Pages();
    public static Bench bench;

    @Before
    public void setUp(){
        readTheTestData();
        if (Bench.bench == null) {
            new Bench();
        }
        bench = Bench.bench;
        bench.openBrowserTest();
        pages.getLoginPagePOM().navigate();
        pages.getLoginPagePOM().login();
    }

    @Then("Navigate the users permission")
    public void navigateToUsersPermission(){
        pages.getPartnersPagePOM().navigateToUsersPermission();
    }

    @Then("Give the user all permission")
    public void checkPermissionOfTheCurrentUser(){
        pages.getPartnersPagePOM().searchUser();
        if (pages.getPartnersPagePOM().checkUserPermission().equals("false")){
            getDriver().findElement(pages.getUsersPermissionPOM().allPermission).click();
            waitUntil(ExpectedConditions.elementToBeClickable(pages.getUsersPermissionPOM().allPermission));
            if (pages.getPartnersPagePOM().checkUserPermission().equals("true")){
                System.out.println("The user has got every permission!");
                Allure.step("The user has got every permission!", Status.PASSED);
            } else{
                System.err.println("The user hasn't got every permission!");
                Allure.step("The user hasn't got every permission!", Status.FAILED);
            }
        } else if (pages.getPartnersPagePOM().checkUserPermission().equals("true")) {
            System.out.println("The user has got every permission!");
            Allure.step("The user has got every permission!", Status.PASSED);
        }else {
            System.err.println("The check box has unnamed value!");
            Allure.step("The check box has unnamed value!", Status.FAILED);
        }
    }

    @Given("Navigate to the partners module and click the all partners")
    public void navigateToAllPartnes(){
        pages.getPartnersPagePOM().navigateToPartnersModul();
    }

    @Then("View the partners list")
    public void viewPartners(){
        if (!pages.getPartnersPagePOM().viewPartnersList().equals("")){
            System.out.println("The user can view the partners!");
            Allure.step("The user can view the partners!", Status.PASSED);
        }else {
            System.err.println("The user can't view the partners!");
            Allure.step("The user can't view the partners!", Status.FAILED);
            Allure.addAttachment("View partners list", takeScreenshot());
        }
    }

    @Given ("Create new partner")
    public void createPartners(){
        pages.getPartnersPagePOM().createNewPartner();
    }

    @Then("Create partner - get the text from message - successful or unsuccessful")
    public void successfulSave(){
        if(pages.getPartnersPagePOM().getSuccessfulSaveMessage().equals("Sikeres mentés!")){
            System.out.println("Successful create a new partner!");
            Allure.step("Successful create a new partner!", Status.PASSED);
        } else {
            System.err.println("Unsuccessful create a new partner!");
            Allure.step("Unsuccessful create a new partner!", Status.FAILED);
            Allure.addAttachment("Create new partner", takeScreenshot());
        }
    }

    @Given("Edit the partner")
    public void editPartner(){
        pages.getPartnersPagePOM().filterByName();
        pages.getPartnersPagePOM().editPartner();
    }

    @Then("Edit partner - get the text from message - successful or unsuccessful")
    public void successfulEditSave(){
        if(pages.getPartnersPagePOM().getSuccessfulSaveMessage().equals("Sikeres mentés!")){
            System.out.println("Successful edit the partner!");
            Allure.step("Successful edit the partner!", Status.PASSED);
        } else {
            System.err.println("Unsuccessful edit the partner!");
            Allure.step("Unsuccessful edit the partner!", Status.FAILED);
            Allure.addAttachment("Edit the partner", takeScreenshot());
        }
    }

    @Given("Delete partner")
    public void deletePartner(){
        pages.getPartnersPagePOM().filterByName();
        pages.getPartnersPagePOM().deletePartner();
        pages.getPartnersPagePOM().getDeleteMessage();
    }

    @Then("Delete partner - get the text from message - successful or unsuccessful")
    public void successfulDeleteMessage(){
        if(pages.getPartnersPagePOM().getDeleteMessage().equals("Az elem sikeresen el lett távolítva.")){
            System.out.println("Successful delete the partner!");
            Allure.step("Successful delete the partner!", Status.PASSED);
        } else {
            System.err.println("Unsuccessful delete the partner!");
            Allure.step("Unsuccessful delete the partner!", Status.FAILED);
            Allure.addAttachment("Delete the partner", takeScreenshot());
        }
    }

    @Then("Check the delete")
    public void deleteCheck(){
        pages.getPartnersPagePOM().filterByName();
        if( !pages.getPartnersPagePOM().partnerDeleteCheck().equals("Nincs a keresésnek megfelelő találat")){
            pages.getPartnersPagePOM().deletePartner();
        }
    }

    @Then ("Check the created partner")
    public void checkTheCreatedPartner(){
        pages.getPartnersPagePOM().filterByName();
        if (pages.getPartnersPagePOM().checkTheCreatedPartner().equals("TESZT-PARTNER Kft.")){
            System.out.println("New partner has been created!");
            Allure.step("New partner has been created!", Status.PASSED);
        }else {
            System.err.println("New partner hasn't been created!");
            Allure.step("New partner hasn't been created!", Status.FAILED);
            Allure.addAttachment("Create new partner", takeScreenshot());
        }
    }

   @After
   public void logoutAndCloseDriver(){
       bench.closeTest();
       bench = null;
    }
}
