package prozenda.receiptstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditReceipt extends UIActions {
    Pages pages = new Pages();

    @Then("Click on first receipt serial number")
    public void clickOnFirstReceiptName() {
        pages.getCustomerReceiptListViewPagePOM().clickOnFirstReceiptName();
    }

    @Then("Click on three dots and edit on first receipt")
    public void clickOnThreeDotsAndEditOnFirstReceipt() {
        pages.getCustomerReceiptListViewPagePOM().clickOnThreeDotsAndEditOnFirstReceipt();
    }
}
