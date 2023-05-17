package prozenda.receiptstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;

public class DeleteReceipt extends UIActions {
    Pages pages = new Pages();

    @Then("Click on three dots and delete newly created receipt")
    public void clickOnThreeDotsAndDeleteNewlyCreatedReceipt() {
        pages.getCustomerReceiptListViewPagePOM().clickOnThreeDotsAndDeleteNewlyCreatedReceipt();
    }

    @Then("Click on check box and delete newly created receipt")
    public void clickOnCheckBoxAndDeleteNewlyCreatedReceipt() {
        pages.getCustomerReceiptListViewPagePOM().clickOnCheckBoxAndDeleteNewlyCreatedReceipt();
    }

    @Then("Assert receipt deleted successfully")
    public void assertReceiptDeletedSuccessfully() {
        pages.getCustomerReceiptListViewPagePOM().assertReceiptDeletedSuccessfully();
    }
}
