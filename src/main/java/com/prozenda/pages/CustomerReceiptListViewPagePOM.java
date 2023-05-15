package com.prozenda.pages;

import com.prozenda.selectors.CustomerReceiptListViewPage;
import com.prozenda.selectors.ReceiptPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.prozenda.utils.UIActions.elementClick;

public class CustomerReceiptListViewPagePOM extends AbstractPage {

    public void clickOnPlusButtonInListView() {
        elementClick(CustomerReceiptListViewPage.plusButton);
    }
}
