package prozenda.stepdefinition;

import com.prozenda.pages.NewProductPagePOM;
import com.prozenda.pages.Pages;
import io.cucumber.java.en.Then;

public class NewProductPageSteps {

    Pages pages = new Pages();

    @Then("fill required fields with Title: {string}, Type: {string}, Amount units: {string}")
    public void fillRequiredFields(String title, String type, String amountUnits) {
        pages.getNewProductPagePOM().fillProductTitle(title);
        pages.getNewProductPagePOM().clickType(NewProductPagePOM.ProductType.valueOf(type).getTypeElement());
        pages.getNewProductPagePOM().selectAmountUnit(NewProductPagePOM.AmountUnit.valueOf(amountUnits).getAmountUnitElement());
    }

    @Then("save new product")
    public void saveProduct() throws InterruptedException {
        pages.getNewProductPagePOM().saveProduct();
    }
}
