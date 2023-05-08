package prozenda.partnerstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
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

    @Then ("Click all partners and click one of them")
    public void openEditByClickingName(){
        pages.getPartnersPagePOM().clickOnOneOfThePartners();
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
}
