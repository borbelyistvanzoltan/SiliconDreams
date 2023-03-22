package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.pages.ProductsPagePOM;
import io.cucumber.java.en.Then;

public class ProductsPageSteps {

    Pages pages = new Pages();

    @Then("filter {string} on {string} column filter")
    public void filterProduct(String keyword, String column) {
        pages.getProductsPagePOM().filterProduct(keyword, ProductsPagePOM.FilterColumn.valueOf(column).getFilterColumnElement());
    }

    @Then("check {string} product created")
    public void checkProductCreated(String title) {
        pages.getProductsPagePOM().checkProductCreated(title);
    }

    @Then("delete created products")
    public void deleteCreatedProducts() throws InterruptedException {
        pages.getProductsPagePOM().clickDeleteButton();
        pages.getProductsPagePOM().clickAcceptDelete();
    }
}
