package prozenda.stepdefinition;

import com.prozenda.pages.NewProductPagePOM;
import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public class NewProductPageSteps extends UIActions {

    Pages pages = new Pages();

    @Then("fill required fields with Title: {string}, Type: {string}, Amount units: {string}")
    public void fillRequiredFields(String title, String type, String amountUnits) {
        pages.getNewProductPagePOM().fillProductTitle(title);
        if(!type.equals("")) {
            pages.getNewProductPagePOM().clickType(NewProductPagePOM.ProductType.valueOf(type).getTypeElement());
        }
        if(!amountUnits.equals("")) {
            pages.getNewProductPagePOM().selectAmountUnit(NewProductPagePOM.AmountUnit.valueOf(amountUnits).getAmountUnitElement());
        }
    }

    @Then("Validation the error list while missing all fields")
    public void validationMissingAllFieldsErrorList(){
        pages.getPartnersPagePOM().waitToAlert();
        if (pages.getNewProductPagePOM().getErrorList().equals("A(z) termekkod megadása kötelező!A(z) tipus megadása kötelező!" +
                "A(z) megnevezes.hu megadása kötelező!A(z) mennyisegi-egyseg megadása kötelező!A(z) url.hu megadása kötelező!")){
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

    @Then("Validation the error list while missing type and amount units fields")
    public void validationTheErrorList(){
        pages.getPartnersPagePOM().waitToAlert();
        if (pages.getNewProductPagePOM().getErrorList().equals("A(z) tipus megadása kötelező!" +
                "A(z) mennyisegi-egyseg megadása kötelező!A(z) url.hu megadása kötelező!")){
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

    @Then("Create new product with Title: {string}, Type: {string}, Amount units: {string}")
    public void createNewProduct(String title, String type, String amountUnits) {
        pages.getNewProductPagePOM().createNewProduct(title, NewProductPagePOM.ProductType.valueOf(type).getTypeElement(),
                NewProductPagePOM.AmountUnit.valueOf(amountUnits).getAmountUnitElement());
    }

    @Then("save new product")
    public void saveProduct() throws InterruptedException {
        pages.getNewProductPagePOM().saveProduct();
    }
}
