package com.prozenda.pages;

import com.prozenda.selectors.PartnersPage;
import com.prozenda.utils.UIActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.prozenda.selectors.MainPage.newButton;
import static com.prozenda.selectors.PartnersPage.*;
import static com.prozenda.selectors.PartnersPage.partnerName;
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

    public String getSuccessfulSaveMessage(By button){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(successfulSaveMessage));
        getDriver().findElement(successfulSaveMessage);
        String message = getDriver().findElement(successfulSaveMessage).getAttribute("textContent");
        elementClick(button);
        return message;
    }
    public String getSuccessfulSaveMessage(){
        return getSuccessfulSaveMessage(backToList);
    }

    public void filterByName(String filteredName){
        waitToElement(ExpectedConditions.elementToBeClickable(nameFilter));
        setText(nameFilter, filteredName, true);
    }

    public void editPartner(){
        elementClick(foundNameActions);
        elementClick(editPartner);
        setText(companyNumber, testData.getCompanyNumber(), true);
        elementClick(savePartner);
    }
    public void editPartnerFromActions(){
        elementClick(foundNameActions);
        elementClick(editPartner);
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
        waitUntil(ExpectedConditions.visibilityOfElementLocated(filterResults));
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
        waitToElement(ExpectedConditions.attributeContains(errorAlert, "outerHTML", "form-error alert alert-danger"));
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

    public void clickOnTheCreatedPartnerName(){
        elementClick(createdPartner);
    }

    public String getEditHeaderTitle(){
        String editTitle = getDriver().findElement(editHeaderTitle).getAttribute("textContent");
        return editTitle;
    }

    public void editCompanyId(){
        setText(companyId, testData.getEditedCompanyId(), true);
        elementClick(savePartner);
        backToListView();
    }

    public void backToListView(){
        elementClick(backToList);
    }
    public void backToEdit (){
        elementClick(backToEdit);
    }
    public String getCompanyId(){
        String editedCompanyId = getDriver().findElement(companyId).getAttribute("value");
        return editedCompanyId;
    }

    public void clickOnCloning(){
        elementClick(foundNameActions);
        elementClick(clonePartner);
    }

    public String getPartnerName(){
        String partner = getDriver().findElement(partnerName).getAttribute("value");
        return partner;
    }

    public void createNewPartnerByClone(){
        clear(partnerName);
        setText(partnerName, testData.getClonePartnerName(), false);
        setText(partnerId, testData.getClonePartnerId(), true);
        setText(companyNumber, testData.getCompanyNumber(), true);
        elementClick(savePartner);
        backToListView();
    }

    public void navigateNewCustomer(){
        elementClick(partnersModule);
        elementClick(newCustomer);
        elementClick(partnerFormListOk);
    }

    public void requiredFieldsCheck(boolean partnerid, boolean name) {
        setText(partnerName, testData.getPartnerID(), true);
        elementClick(createdPartner);
        waitForInput(companyNumber, "defaultValue", 5000);
        if (name == false) {
            clear(partnerName);
            elementClick(savePartner);
        } else if (partnerid == false) {
            clear(partnerId);
            elementClick(savePartner);
        }
    }

    public void fillPartnerId(){
        setText(partnerId, testData.getPartnerID(), true);
    }

    public void checkMembership(boolean domestic, boolean eu, boolean nonEu){
        clear(taxNumber);
        scrollByPixel(1000);
        if(domestic){
            elementClick(membership_domestic);
        } else if(eu){
            elementClick(membership_eu);
        } else if (nonEu){
            elementClick(membership_nonEu);
        }
        elementClick(savePartner);
    }

    public boolean checkErrorAlertVisible(){
        if (waitToElement(ExpectedConditions.attributeContains(errorAlert, "outerHTML", "form-error alert alert-danger")) == TIMEOUT){
            return false;
        } else {
            return true;
        }
    }

    public void saveWithoutType( ){
        scrollByPixel(1000);
        elementClick(typeCustomer);
        elementClick(savePartner);
    }
}
