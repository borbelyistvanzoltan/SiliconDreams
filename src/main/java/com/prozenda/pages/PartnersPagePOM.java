package com.prozenda.pages;

import com.prozenda.utils.UIActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.prozenda.selectors.MainPage.newButton;
import static com.prozenda.selectors.PartnersPage.*;
import static com.prozenda.selectors.UsersPermission.*;
import static com.prozenda.utils.WaitEnum.*;

/**
 * @author Rebeka Alajtner
 * @created 21/04/2023 - 13:25
 * @project SiliconDreams
 */
public class PartnersPagePOM extends UIActions {

    public void navigateToUsersPermission(){
        elementClick(settings);
        elementClick(users);
        elementClick(usersPermission);
    }
    public void searchUser(){
        readTheTestData();
        setText(userSearch, testData.getUser(), false);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(foundUser));
    }

    public String checkUserPermission(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(allPermission));
        String notificationCheck = String.valueOf(getDriver().findElement(allPermissionCheckBox).isSelected());
        return notificationCheck;
    }

    public void navigateToPartnersModule(){
        elementClick(partnersModule);
        elementClick(allPartners);
    }

    public void navigateToNewPrivatePartner(){
        elementClick(newPrivatePerson);
        elementClick(partnerFormListOk);
    }

    public String viewPartnersList(){
        waitUntil(ExpectedConditions.elementToBeClickable(partnersGridCell));
        String getParner = getDriver().findElement(partnersGridCell).getAttribute("textContent");
        return getParner;
    }

    public void createNewPartner(){
        elementClick(newPartner);
        elementClick(newCustomer);
        elementClick(partnerFormListOk);
        setText(partnerName,testData.getPartnerID(), false);
        elementClick(createdPartner);
        waitForInput(companyNumber, "defaultValue",5000);
        elementClick(savePartner);
    }

    public String getSuccessfulSaveMessage(){
        getDriver().findElement(successfulSaveMessage);
        String message = getDriver().findElement(successfulSaveMessage).getAttribute("textContent");
        elementClick(backToPartnerList);
        return message;
    }

    public void filterByName(String filteredName){
        readTheTestData();
        setText(nameFilter, filteredName, true);
    }

    public void editPartner(){
        elementClick(foundNameActions);
        elementClick(editPartner);
        setText(companyNumber, testData.getCompanyNumber(), true);
        elementClick(savePartner);
    }

    public void deletePartner(){
        elementClick(foundNameActions);
        elementClick(deletePartner);
        elementClick(confirmDelete);
    }

    public String getDeleteMessage(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(deleteMessageBox));
        String deleteMessage = getDriver().findElement(deleteMessageBox).getAttribute("textContent");
        return deleteMessage;
    }

    public String partnerDeleteCheck(){
        String results = getDriver().findElement(filterResults).getAttribute("textContent");
        return results;
    }

    public String checkTheCreatedPartner(){
        String createdPartnerName = getDriver().findElement(createdPartner).getAttribute("textContent");
        return createdPartnerName;
    }

    public void saveTheNewPartner(){
        elementClick(savePartner);
    }

    public void waitToAlert() {
        if (waitToElement(ExpectedConditions.alertIsPresent()) == ELEMENTLOCATED){
            Alert alert;
            alert = getDriver().switchTo().alert();
            alert.accept();
        }
    }
    public String getErrorList(){
        String list = getDriver().findElement(errorAlert).getAttribute("textContent");
        return list;
    }

    public void enterTheNewPrivatePersonData(){
        setText(partnerName, testData.getPrivatePartnerName(),false);
        elementClick(partnerId);
    }

    public String getFoundPrivatePartnerName(){
        String foundName = getDriver().findElement(foundPrivatePartnerName).getAttribute("textContent");
        return foundName;
    }

    public void createPrivatePartnerFromNewButton(){
        elementClick(newButton);
        elementClick(newListPartnerElement);
        elementClick(privatePartner);
        elementClick(partnerFormListOk);
    }

    public void createPrivatePartnerFromListView(){
        elementClick(plusButton);
        elementClick(plusButtonNewPrivatePartner);
        elementClick(partnerFormListOk);
    }
}
