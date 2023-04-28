package com.prozenda.selectors;

import org.openqa.selenium.By;

/**
 * @author Rebeka Alajtner
 * @created 21/04/2023 - 13:25
 * @project SiliconDreams
 */
public class PartnersPage {

    public static final By partnersModul = By.xpath("//*[ contains (text(), 'Partnerek' ) ]");
    public static final By settings = By.xpath("//*[ text() = 'Beállítások']");
    public static final By users = By.xpath("//*[ text() = 'Felhasználók']");
    public static final By usersPermission = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
    public static final By allPartners = By.xpath("//*[ text() = 'Összes']");

    // All partners page
    public static final By nameFilter = By.xpath("//th[contains(text(),'Név')]/input");
    public static final By partnersGridCell = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]");
    public static final By newPartner = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
    public static final By newCustomer = By.xpath("//*[ text() = 'Új vevő']");
    public static final By partnerFormListOk = By.xpath("/html[1]/body[1]/div[12]/div[1]/div[3]/button[1]");

    public static final By filterResults = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]");

    // New partner basic data
    public static final By partnerName = By.id("partner_name");
    public static final By foundPartnerName = By.xpath("//*[ contains (text(), 'TESZT-PARTNER Kft.' ) ]");
    public static final By savePartner = By.id("save_btn");
    public static final By companyNumber = By.name("cegjegyzekszam");
    public static final By successfulSaveMessage = By.id("swal2-title");
    public static final By backToPartnerList = By.xpath("//span[contains(text(),'Vissza a listanézethez')]");

    // Edit partner
    public static final By foundNameActions = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/a[1]");
    public static final By editPartner = By.xpath("/html[1]/body[1]/div[12]/a[1]");
    public static final By deletePartner = By.xpath("/html[1]/body[1]/div[12]/a[3]");
    public static final By confirmDelete = By.xpath("/html[1]/body[1]/div[12]/div[1]/div[3]/button[1]");
    public static final By deleteMessageBox = By.xpath("/html/body/div[12]/span[3]");
    public static final By createdPartner = By.xpath("//*[ text() = 'TESZT-PARTNER Kft.']");

}

