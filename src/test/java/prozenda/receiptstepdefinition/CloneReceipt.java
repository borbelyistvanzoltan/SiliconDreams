package prozenda.receiptstepdefinition;

import com.prozenda.pages.Pages;
import com.prozenda.utils.UIActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CloneReceipt extends UIActions {
    Pages pages = new Pages();

    @When("Click on three dots and clone on first receipt")
    public void clickOnThreeDotsAndCloneOnFirstReceipt() {
        pages.getCustomerReceiptListViewPagePOM().clickOnThreeDotsAndCloneOnFirstReceipt();
    }
}
