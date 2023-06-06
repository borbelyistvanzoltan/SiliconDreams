package prozenda.productstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.pages.ProductsPagePOM;
import com.prozenda.utils.GetProperties;
import io.cucumber.java.en.Then;

import static com.prozenda.utils.UIActions.scrollByPixel;

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

    @Then("Clone the product from actions menu with Title: {string}, Product code: {string}")
    public void cloneProductFromActionMenu(String productName, String productCode) throws InterruptedException {
        pages.getProductsPagePOM().cloneProductFromActions(productName, productCode);
        pages.getNewProductPagePOM().saveProduct();
    }

    @Then("Navigate to attach tab")
    public void navigateToAttachTab() {
        pages.getProductsPagePOM().navigateToAttachTab();
    }

    @Then("Check {string} file is attached")
    public void checkAttachedFile(String fileName) {
        pages.getProductsPagePOM().checkFileIsAttached(fileName);
    }

    @Then("Upload a file successfully")
    public void fileUpload() {
        pages.getProductsPagePOM().uploadDocumnetFile(GetProperties.UploadFile.NORMAL);
    }

    @Then("Upload a large file")
    public void largeFileUpload() {
        pages.getProductsPagePOM().uploadDocumnetFile(GetProperties.UploadFile.LARGE);
    }

    @Then("Upload an incorrect format file")
    public void incorrectFormatFileUpload() {
        pages.getProductsPagePOM().uploadImageFile(GetProperties.UploadFile.NORMAL);
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