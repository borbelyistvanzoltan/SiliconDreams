package com.prozenda.pages;

import com.prozenda.utils.UIActions;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.junit.Assert;
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
                System.out.println("The user has got every permission!");
                Allure.step("The user has got every permission!", Status.PASSED);
            } else{
                System.err.println("The user hasn't got every permission!");
                Allure.step("The user hasn't got every permission!", Status.FAILED);
            }
        } else if (notificationCheck.equals("true")) {
            System.out.println("The user has got every permission!");
            Allure.step("The user has got every permission!", Status.PASSED);
        }else {
            System.err.println("The check box has unnamed value!");
            Allure.step("The check box has unnamed value!", Status.FAILED);
        }
        return notificationCheck;
    }

    public void navigateToPartnersModule(){
        elementClick(partnersModule);
        sleep(2000);
        elementClick(allPartners);
        sleep(6000);
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
            System.out.println("The user can view the partners!");
            Allure.step("The user can view the partners!", Status.PASSED);
        }else {
            System.err.println("The user can't view the partners!");
            Allure.step("The user can't view the partners!", Status.FAILED);
            Allure.addAttachment("View partners list", takeScreenshot());
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
        elementClick(savePartner);
    }

    public String getSuccessfulSaveMessage(By button){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(successfulSaveMessage));
        getDriver().findElement(successfulSaveMessage);
        String message = getDriver().findElement(successfulSaveMessage).getAttribute("textContent");
        if(message.equals("Sikeres mentés!")){
            System.out.println("Successful edit the partner!");
            Allure.step("Successful edit the partner!", Status.PASSED);
        } else {
            System.err.println("Unsuccessful edit the partner!");
            Allure.step("Unsuccessful edit the partner!", Status.FAILED);
            Allure.addAttachment("Edit the partner", takeScreenshot());
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
            System.out.println("Successful delete the partner!");
            Allure.step("Successful delete the partner!", Status.PASSED);
        } else {
            System.err.println("Unsuccessful delete the partner!");
            Allure.step("Unsuccessful delete the partner!", Status.FAILED);
            Allure.addAttachment("Delete the partner", takeScreenshot());
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
        String createdPartnerName = getDriver().findElement(createdPartner).getAttribute("textContent");
        if (createdPartnerName.equals("TESZT-PARTNER Kft.")){
            System.out.println("New partner has been created!");
            Allure.step("New partner has been created!", Status.PASSED);
        }else {
            System.err.println("New partner hasn't been created!");
            Allure.step("New partner hasn't been created!", Status.FAILED);
            Allure.addAttachment("Create new partner", takeScreenshot());
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
            System.out.println(passLog);
            Allure.step(passLog, Status.PASSED);
        }else if (list.equals("")) {
            System.err.println(failLogContain);
            Allure.step(failLogContain, Status.FAILED);
            Allure.addAttachment("Error alert" + list, takeScreenshot());
        } else{
            System.err.println(failLogMatch);
            Allure.step(failLogMatch, Status.FAILED);
            Allure.addAttachment("Error alert" + list, takeScreenshot());
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
            System.out.println("Successful created the private partner!");
            Allure.step("Successful created the private partner!", Status.PASSED);
        } else {
            Assert.fail("Unsuccessful created the private partner!");
            Allure.step("Unsuccessful created the private partner!", Status.FAILED);
            Allure.addAttachment("Create new private partner", takeScreenshot());
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

    public void clickOnTheCreatedPartnerName(){
        elementClick(createdPartner);
        sleep(6000);
    }

    public String getEditHeaderTitle(){
        String editTitle = getDriver().findElement(editHeaderTitle).getAttribute("textContent");
        if (editTitle.contains("Szerkesztés: ")){
            System.out.println("The partner is editable!");
            Allure.step("The partner is editable!", Status.PASSED);
        } else {
            System.err.println("The partner is not editable!");
            Allure.step("The partner is not editable!", Status.PASSED);
            Allure.addAttachment("Edit partner" + editTitle, takeScreenshot());
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
            System.out.println("Successful edit!");
            Allure.step("Successful edit!", Status.PASSED);
        } else if(!editedCompanyId.equals(testData.getEditedCompanyId())) {
            System.err.println("Unsuccessful edit!");
            Allure.step("Unsuccessful edit!", Status.PASSED);
            Allure.addAttachment("Edit partner" + editedCompanyId, takeScreenshot());
        } else {
            System.err.println("Unsuccessful edit!");
            Allure.step("Unsuccessful edit!", Status.PASSED);
            Allure.addAttachment("Edit partner" + editedCompanyId, takeScreenshot());
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
            System.out.println("The partner has been created by cloning from list view!");
            Allure.step("The partner has been created by cloning from list view!", Status.PASSED);
        } else if (whichCloned.equals(partnerName)){
            System.err.println("The cloning is unsuccessful! - the partner name is same!");
            Allure.step("The cloning is unsuccessful! - the partner name is same!", Status.FAILED);
            Allure.addAttachment("The cloning is unsuccessful!", takeScreenshot());
        } else {
            System.err.println("The cloning is unsuccessful!");
            Allure.step("The cloning is unsuccessful!", Status.FAILED);
            Allure.addAttachment("The cloning is unsuccessful!", takeScreenshot());
        }
    }

    public void fillData(String partner){
        setText(partnerName, partner, true);
        elementClick(createdPartner);
        waitForInput(companyNumber, "defaultValue",5000);
    }

    public void activeSwitch(){
        elementClick(active);
    }

    public void checkActiveSwitchInReceipt(boolean negativeTest){
        elementClick(saleModule);
        elementClick(newCustomerReceipt);
        elementClick(formOk);
        setText(customerName, testData.getPartnerID(), true);
        try{
            String getFoundPartner = getDriver().findElement(foundCustomer).getAttribute("textContent");
            if (getFoundPartner.equals(testData.getActivePartnerName())){
                System.out.println("The active switch on - the partner is active on invoices!");
                Allure.step("The active switch on - the partner is active on invoices", Status.PASSED);
            } else{
                System.err.println("The active switch on - the partner is not found!");
                Allure.step("The active switch on - the partner is not found!", Status.FAILED);
                Allure.addAttachment("Active switch", takeScreenshot());
            }
        }catch (NoSuchElementException e){
                if (negativeTest){
                    System.out.println("The active switch off - the partner is not active on invoices!");
                    Allure.step("The active switch off - the partner is not active on invoices!", Status.PASSED);
                }else {
                    System.err.println("The active switch off - the partner is not active on invoices!");
                    Allure.step("The active switch off - the partner is not active on invoices!", Status.FAILED);
                    Allure.addAttachment("Active switch", takeScreenshot());
                }
        } catch (Exception e){
            System.err.println("The partner not found!");
            Allure.step("The partner not found!", Status.FAILED);
            Allure.addAttachment("Active switch", takeScreenshot());
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
