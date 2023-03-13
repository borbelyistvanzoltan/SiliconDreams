package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.selectors.CompanyDetailsAddressesPage;
import io.cucumber.java.en.Then;

public class CompanyDetailsAddressesPageSteps {

    Pages pages = new Pages();

    @Then("Create a new address with mandatory fields: {string}, {string}, {string}, {string}")
    public void createNewAddress(String postalCode, String city, String street, String type) {
        CompanyDetailsAddressesPage.StreetType streetType = null;
        if ("utca".equals(type)) {
            streetType = CompanyDetailsAddressesPage.StreetType.STREET;
        }
        assert streetType != null;
        pages.getCompanyDetailsAddressesPagePOM().createNewAddress(postalCode, city, street, streetType);
    }

    @Then("Click save button")
    public void clickSaveButton() {
        pages.getCompanyDetailsAddressesPagePOM().clickSaveButton();
    }

    @Then("Check new address created: {string}, {string}, {string}")
    public void checkNewAddress(String postalCode, String city, String street) {
        pages.getCompanyDetailsAddressesPagePOM().checkNewAddress(postalCode, city, street);
    }

    @Then("Delete newly created address")
    public void deleteLastAddress() {
        pages.getCompanyDetailsAddressesPagePOM().deleteLastAddress();
    }
}