package prozenda.productstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.pages.ProductsPagePOM;
import io.cucumber.java.en.Then;

public class ProductsPageSteps {

    Pages pages = new Pages();

    @Then("filter {string} on {string} column filter")
    public void filterProduct(String keyword, String column) {
        pages.getProductsPagePOM().filterProduct(keyword, ProductsPagePOM.FilterColumn.valueOf(column).getFilterColumnElement());
    }

    @Then("check {string} product is exist: {string}")
    public void checkProductCreated(String title, String shouldCreated) {
        pages.getProductsPagePOM().checkProductCreated(title, Boolean.parseBoolean(shouldCreated));
    }

    @Then("Click on first product name")
    public void openEditByClickingName(){
        pages.getProductsPagePOM().clickFirstProductName();
    }

    @Then("Edit the product from actions menu")
    public void editProductFromActionMenu() {
        pages.getProductsPagePOM().editProductFromActions();
    }

    @Then("edit product name to {string}")
    public void editProductName(String name) throws InterruptedException {
        pages.getNewProductPagePOM().fillProductTitle(name);
        pages.getNewProductPagePOM().saveProduct();
    }

    @Then("delete created products")
    public void deleteCreatedProducts() throws InterruptedException {
        pages.getProductsPagePOM().clickDeleteButton();
        pages.getProductsPagePOM().clickAcceptDelete();
    }

    @Then("import products")
    public void importProducts() {
        pages.getProductsPagePOM().clickImportExportButton();
        pages.getProductsPagePOM().clickImportButton();
        pages.getProductsPagePOM().attachImportFile();
        pages.getProductsPagePOM().doImport();
    }

    @Then("check successfully imported {string} product")
    public void checkSuccessfulImport(String numberOfImportedProducts) {
        pages.getProductsPagePOM().checkSuccessfulImport(Integer.parseInt(numberOfImportedProducts));
    }

    @Then("jump to products list")
    public void jumpToProductsList() {
        pages.getProductsPagePOM().jumpToProductsList();
    }
}