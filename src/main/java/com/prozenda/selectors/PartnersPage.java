package com.prozenda.selectors;

import org.openqa.selenium.By;

/**
 * @author Rebeka Alajtner
 * @created 21/04/2023 - 13:25
 * @project SiliconDreams
 */
public class PartnersPage {

    public static final By partnersModule = By.xpath("//*[ contains (text(), 'Partnerek' ) ]");
    public static final By newPrivatePerson = By.xpath("//*[ contains (text(), 'Új magánszemély' ) ]");
    public static final By newListPartnerElement = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/ul[1]/li[1]/a[1]/span[2]");
    public static final By privatePartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/ul[1]/li[1]/div[1]/ul[1]/li[3]/a[1]/span[1]");
    public static final By settings = By.xpath("//*[ text() = 'Beállítások']");
    public static final By users = By.xpath("//*[ text() = 'Felhasználók']");
    public static final By usersPermission = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
    public static final By allPartners = By.xpath("//*[ text() = 'Összes']");

    // All partners page
    public static final By nameFilter = By.xpath("//th[contains(text(),'Név')]/input");
    public static final By partnersGridCell = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]");
    public static final By newPartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
    public static final By newCustomer = By.xpath("//*[ text() = 'Új vevő']");
    public static final By newSupplier = By.xpath("//*[ text() = 'Új szállító']");
    public static final By formOk = By.xpath("//*[ text() = 'OK']");
    public static final By plusButton = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
    public static final By plusButtonNewPrivatePartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]");
    public static final By plusButtonNewCustomerPartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]");
    public static final By plusButtonNewSupplierPartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]");

    public static final By filterResults = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]");

    // New partner basic data
    public static final By basicData = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    public static final By partnerName = By.id("partner_name");
    public static final By foundPrivatePartnerName = By.xpath("//*[ text() = 'Teszt Ember']");
    public static final By savePartner = By.id("save_btn");
    public static final By partnerId = By.name("partnerkod");
    public static final By companyNumber = By.name("cegjegyzekszam");
    public static final By companyId = By.name("partnerkod");
    public static final By successfulSaveMessage = By.id("swal2-title");
    public static final By backToPartnerList = By.xpath("//span[contains(text(),'Vissza a listanézethez')]");
    public static final By errorAlert =  By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]");
    public static final By taxNumber= By.name("adoszam");
    public static final By typeCustomer = By.xpath("//label[contains(text(),'Vevő')]/span");
    public static final By membership_domestic = By.xpath("//label[contains(text(),'Belföld')]/span");
    public static final By membership_eu = By.xpath("//label[contains(text(),'EU')]/span");
    public static final By membership_nonEu = By.xpath("//label[contains(text(),'EU-n kivüli')]/span");
    public static final By active = By.xpath("//label[contains(text(),'Aktív')]/following-sibling::span");

    // Edit partner
    public static final By editHeaderTitle = By.xpath("//h3[contains(text(),'Szerkesztés:')]");
    public static final By foundNameActions = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/a[1]");
    public static final By editPartner = By.xpath("/html[1]/body[1]/div[12]/a[1]");
    public static final By clonePartner = By.xpath("/html[1]/body[1]/div[12]/a[2]");
    public static final By deletePartner = By.xpath("/html[1]/body[1]/div[12]/a[3]");
    public static final By confirmDelete = By.xpath("//*[ text() = 'Törlés']");
    public static final By deleteMessageBox = By.xpath("/html/body/div[12]/span[3]");
    public static final By testPartnerName = By.xpath("//*[ text() = 'TESZT-PARTNER']");
    public static final By createdPartner = By.xpath("//div[contains(text(),'TESZT-PARTNER')]");
    public static final By createdPrivatePartner = By.xpath("//*[ text() = 'Teszt Ember']");
    public static final By createdSupplierPartner = By.xpath("//strong[contains(text(),'TESZT KFT')]");
    public static final By foundSupplier = By.xpath("//*[ contains (text(), 'TESZT KFT' ) ]");
    public static final By backToList = By.xpath("//*[ text() = 'Vissza a listanézethez']");
    public static final By backToEdit = By.xpath("//*[ text() = 'Tovább a szerkesztéshez']");
    public static final By continueEdit = By.xpath("//*[ text() = 'Szerkesztés folytatása']");
    public static final By relatedPartner = By.xpath("//*[ contains (text(), 'Kapcsolódó partnerek' ) ]");

    // Related partners tab
    public static final By newRelatedPartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/table[1]/tbody[1]/tfoot[1]/tr[1]/td[1]/div[1]/div[1]/a[1]");
    public static final By foundRelatedPartner = By.xpath("//tbody/tr[1]/td[1]/label[1]/span[1]");
    public static final By filterByName = By.name("search");
    public static final By addPartner = By.xpath("/html[1]/body[1]/div[5]/div[9]/div[1]/div[1]/div[3]/div[1]/button[1]");
    public static final By commentInput = By.xpath("//tbody/tr[1]/td[3]/div[1]/div[2]/input[1]");
    public static final By warningMessage = By.xpath("/html[1]/body[1]/div[14]/div[1]");
    public static final By closeWarningMessage = By.xpath("//button[contains(text(),'Bezárás')]");

    // Receipt module selectors for check the active partners
    public static final By saleModule = By.xpath("//*[ contains (text(), 'Értékesítés' ) ]");
    public static final By newCustomerReceipt = By.xpath("//*[ contains (text(), 'Új vevőszámla' ) ]");
    public static final By customerName = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");
    public static final By foundCustomer = By.xpath("/html[1]/body[1]/div[16]/a[1]/div[2]/div[1]/div[1]/span[1]");

    // Supply module selectors for check the active partners
    public static final By supplyModule = By.xpath("//*[ contains (text(), 'Beszerzés' ) ]");
    public static final By newSuppliersReceipt = By.xpath("//*[ contains (text(), 'Új szállítói számla' ) ]");
    public static final By supplierName = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");
}

