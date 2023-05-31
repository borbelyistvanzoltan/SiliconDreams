package com.prozenda.pages;

import com.prozenda.utils.UIActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.prozenda.selectors.MainPage.newButton;
import static com.prozenda.selectors.PartnersPage.*;
import static com.prozenda.selectors.PartnersPage.partnerName;
import static com.prozenda.selectors.UsersPermission.*;
import static com.prozenda.utils.WaitEnum.*;
import static com.prozenda.utils.Report.*;
/**
 * @author Rebeka Alajtner
 * @created 21/04/2023 - 13:25
 * @project SiliconDreams
 */
public class PartnersPagePOM extends UIActions {

    Pages pages = new Pages();

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
        if (notificationCheck.equals("false")){
            getDriver().findElement(pages.getUsersPermissionPOM().allPermission).click();
            waitUntil(ExpectedConditions.elementToBeClickable(pages.getUsersPermissionPOM().allPermission));
            if (notificationCheck.equals("true")){
                report("The user has got every permission!");
            } else{
                report("The user hasn't got every permission!","User permission");
            }
        } else if (notificationCheck.equals("true")) {
            report("The user has got every permission!");
        }else {
            report("The check box has unnamed value!","User permission");
        }
        return notificationCheck;
    }

    public void navigateToPartnersModule(){
        elementClick(partnersModule);
        elementClick(allPartners);
        waitToElement(ExpectedConditions.visibilityOfElementLocated(nameFilter));
    }

    public void clickAllPartner(){
        elementClick(allPartners);
    }

    public void navigateToNewPrivatePartner(){
        elementClick(newPrivatePerson);
        elementClick(formOk);
    }

    public String viewPartnersList(){
        waitUntil(ExpectedConditions.elementToBeClickable(partnersGridCell));
        String getPartner = getDriver().findElement(partnersGridCell).getAttribute("textContent");
        if (!getPartner.equals("")){
            report("The user can view the partners!");
        }else {
            report ("The user can't view the partners!","View partners list");
        }
        return getPartner;
    }

    public void createNewPartner(){
        elementClick(newPartner);
        elementClick(newCustomer);
        elementClick(formOk);
        setText(partnerName,testData.getPartnerID(), false);
        elementClick(createdPartner);
        waitForInput(companyNumber, "defaultValue",5000);
        clear(partnerName);
        setText(partnerName, testData.getPartner(), true);
        setText(companyNumber, testData.getNewCompanyNumber(), true);
        elementClick(savePartner);
    }

    public String getSuccessfulSaveMessage(By button){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(successfulSaveMessage));
        getDriver().findElement(successfulSaveMessage);
        String message = getDriver().findElement(successfulSaveMessage).getAttribute("textContent");
        if(message.equals("Sikeres mentés!")){
            report("Successful edit the partner!");
        } else {
            report ("Unsuccessful edit the partner!", "Edit the partner");
        }
        elementClick(button);
        return message;
    }
    public String getSuccessfulSaveMessage(){
        return getSuccessfulSaveMessage(backToList);
    }

    public void filterByName(String filteredName, boolean refresh){
        if (refresh){
            getDriver().navigate().refresh();
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        waitToElement(ExpectedConditions.elementToBeClickable(nameFilter));
        setText(nameFilter, filteredName, true);
    }

    public void filterByName(String filteredName){
        filterByName(filteredName, false);
    }

    public void editPartner(){
        elementClick(foundNameActions);
        elementClick(editPartner);
        setText(companyNumber, testData.getCompanyNumber(), true);
        elementClick(savePartner);
    }
    public void editPartnerFromActions(){;
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
        if(deleteMessage.equals("Az elem sikeresen el lett távolítva.")){
            report("Successful delete the partner!");
        } else {
            report("Unsuccessful delete the partner!","Delete the partner");
        }
        return deleteMessage;
    }

    public String partnerDeleteCheck(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(filterResults));
        String results = getDriver().findElement(filterResults).getAttribute("textContent");
        if( !results.equals("Nincs a keresésnek megfelelő találat")){
            deletePartner();
        }
        return results;
    }

    public String checkTheCreatedPartner(){
        String createdPartnerName = getDriver().findElement(testPartnerName).getAttribute("textContent");
        if (createdPartnerName.equals("TESZT-PARTNER")){
            report("New partner has been created!");
        }else {
            report("New partner hasn't been created!","Create new partner");
        }
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
  
    public String getErrorList(String validAlert, String passLog, String failLogMatch, String failLogContain){
        waitToElement(ExpectedConditions.attributeContains(errorAlert, "outerHTML", "form-error alert alert-danger"));
        String list = getDriver().findElement(errorAlert).getAttribute("textContent");
        if (list.contains(validAlert)){
            report(passLog);
        }else if (list.equals("")) {
            report(failLogContain, "Error alert" + list);
        } else{
            report(failLogMatch, "Error alert" + list);
        }
        return list;
    }

    public void enterTheNewPrivatePersonData(){
        setText(partnerName, testData.getPrivatePartnerName(),false);
        elementClick(partnerId);
    }

    public String getFoundPrivatePartnerName(){
        String foundName = getDriver().findElement(foundPrivatePartnerName).getAttribute("textContent");
        if (foundName.equals(testData.getPrivatePartnerName())){
            report("Successful created the private partner!");
        } else {
            report("Unsuccessful created the private partner!","Create new private partner");
        }
        return foundName;
    }

    public void createPartnerFromNewButton(boolean privatePerson, boolean customer, boolean supplier){
        waitToElement(ExpectedConditions.elementToBeClickable(nameFilter));
        elementClick(newButton);
        elementClick(newListPartnerElement);
        if (privatePerson){
            elementClick(privatePartner);
        } else if (customer){
            elementClick(newCustomer);
        } else if (supplier){
            elementClick(newSupplier);
        }
        elementClick(formOk);
    }

    public void createPartnerFromListView(boolean customer, boolean supplier, boolean privatePerson){
        elementClick(plusButton);
        if(customer){
            elementClick(plusButtonNewCustomerPartner);
        } else if(supplier){
            elementClick(plusButtonNewSupplierPartner);
        } else if(privatePerson){
            elementClick(plusButtonNewPrivatePartner);
        }
        elementClick(formOk);
    }

    public void clickOnTheCreatedPartnerName(By button){
        elementClick(button);
    }

    public String getEditHeaderTitle(){
        String editTitle = getDriver().findElement(editHeaderTitle).getAttribute("textContent");
        if (editTitle.contains("Szerkesztés: ")){
            report("The partner is editable!");
        } else {
            report("The partner is not editable!","Edit partner");
        }
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
        if (editedCompanyId.equals(testData.getEditedCompanyId())){
            report("Successful edit!");
        } else if(!editedCompanyId.equals(testData.getEditedCompanyId())) {
            report("Unsuccessful edit!","Editing");
        } else {
            report("Unsuccessful edit!", "Editing");
        }
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
        elementClick(formOk);
    }

    public void requiredFieldsCheck(boolean partnerid, boolean name) {
        setText(partnerName,testData.getPartnerID(), false);
        elementClick(createdPartner);
        waitForInput(companyNumber, "defaultValue",5000);
        clear(partnerName);
        setText(partnerName, testData.getPartner(), true);
        setText(companyNumber, testData.getNewCompanyNumber(), true);
        if (name == false) {
            clear(partnerName);
            elementClick(savePartner);
        } else if (partnerid == false) {
            clear(partnerId);
            elementClick(savePartner);
        }
    }

    public void fillPartnerId(){
        setText(partnerId, testData.getId(), true);
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

    public void alertCheckValidation(String validAlert,String passLog, String failLog,By button){
        if(checkErrorAlertVisible() == true){
            getErrorList(validAlert,passLog,failLog,failLog);
        } else if(checkErrorAlertVisible() == false){
            getSuccessfulSaveMessage(button).equals("Sikeres mentés!");
        }
    }

    public void saveWithoutType( ){
        scrollByPixel(1000);
        elementClick(typeCustomer);
        elementClick(savePartner);
    }

    public void checkCloning(String whichCloned, String partnerName){
        if (!whichCloned.equals(partnerName) && partnerName.equals(testData.getClonePartnerName())){
            report("The partner has been created by cloning from list view!");
        } else if (whichCloned.equals(partnerName)){
            report("The cloning is unsuccessful! - the partner name is same!","Cloning");
        } else {
            report("The cloning is unsuccessful!", "Cloning");
        }
    }

    public void fillData(By button,String partner){
        setText(partnerName,partner, true);
        elementClick(button);
        waitForInput(companyNumber, "defaultValue",5000);
        clear(partnerName);
        setText(partnerName, testData.getPartner(), true);
        setText(companyNumber, testData.getNewCompanyNumber(), true);
    }

    public void activeSwitch(){
        elementClick(active);
    }

    public void checkActiveSwitchInReceipt(String partner, String activePartner, boolean negativeTest){
        elementClick(saleModule);
        elementClick(newCustomerReceipt);
        elementClick(formOk);
        setText(customerName, partner, true);
        try{
            String getFoundPartner = getDriver().findElement(foundCustomer).getAttribute("textContent");
            if (getFoundPartner.equals(activePartner)){
                report("The active switch on - the partner is active on invoices!");
            } else{
                report("The active switch on - the partner is not found!","Active switch");
            }
        }catch (NoSuchElementException e){
                if (negativeTest){
                    report("The active switch off - the partner is not active on invoices!");
                }else {
                    report("The active switch off - the partner is not active on invoices!","Active switch");
                }
        } catch (Exception e){
            report("The partner not found!","Active switch");
        }
    }

    public void checkActiveSwitchInSupply(String partner, String activePartner, boolean negativeTest){
        elementClick(supplyModule);
        elementClick(newSuppliersReceipt);
        elementClick(formOk);
        setText(supplierName, partner, true);
        try{
            String getFoundPartner = getDriver().findElement(foundCustomer).getAttribute("textContent");
            if (getFoundPartner.equals(activePartner)){
                report("The active switch on - the partner is active on invoices!");
            } else{
                report("The active switch on - the partner is not found!", "Active switch");
            }
        }catch (NoSuchElementException e){
            if (negativeTest){
                report("The active switch off - the partner is not active on invoices!");
            }else {
                report("The active switch off - the partner is not active on invoices!","Active switch");
            }
        } catch (Exception e){
            report("The partner not found!","Active switch");
        }
    }

    public void navigateToRelatedPartner(){
        elementClick(relatedPartner);
    }

    public void addNewRelatedPartner(){
        elementClick(newRelatedPartner);
        elementClick(foundRelatedPartner);
        elementClick(addPartner);
    }

    public void addComment(String comment){
        setText(commentInput, comment, true);
    }

}
