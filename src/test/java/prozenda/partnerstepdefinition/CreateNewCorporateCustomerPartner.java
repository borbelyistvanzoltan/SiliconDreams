package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

/**
 * @author Rebeka Alajtner
 * @created 02/05/2023 - 15:08
 * @project SiliconDreams
 */
public class CreateNewCorporateCustomerPartner extends UIActions{
    Pages pages = new Pages();

    @Then("Check the created partner")
    public void checkTheCreatedPartner(){
        pages.getPartnersPagePOM().filterByName(testData.getCreatedPartnerName());
        if (pages.getPartnersPagePOM().checkTheCreatedPartner().equals("TESZT-PARTNER Kft.")){
            System.out.println("New partner has been created!");
            Allure.step("New partner has been created!", Status.PASSED);
        }else {
            System.err.println("New partner hasn't been created!");
            Allure.step("New partner hasn't been created!", Status.FAILED);
            Allure.addAttachment("Create new partner", takeScreenshot());
        }
    }
}
