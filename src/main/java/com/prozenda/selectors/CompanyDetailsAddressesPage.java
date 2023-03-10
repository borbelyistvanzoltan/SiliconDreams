package com.prozenda.selectors;

import org.openqa.selenium.By;

public class CompanyDetailsAddressesPage {

    public static final By newButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div[3]/div/a");
    public static final By postalCode = By.name("addresses[new][0][iranyitoszam]");
    public static final By city = By.name("addresses[new][0][telepules]");
    public static final By streetName = By.name("addresses[new][0][kozterulet_neve]");
    public static final By street = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div[2]/table/tbody[2]/tr/td[8]/select/option[148]");
    public static final By saveButton = By.id("save_btn");
    public static final By confirmButton = By.xpath("/html/body/div[13]/div/div[3]/button[1]");
    public static final By newPostalCodeInput = By.name("addresses[new][0][iranyitoszam]");
    public static final By newCityInput = By.name("addresses[new][0][telepules]");
    public static final By newStreetInput = By.name("addresses[new][0][kozterulet_neve]");
    public static final By newAddressDeleteButton = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div/form/div/div[2]/div/div/div/fieldset/div/div[2]/table/tbody[2]/tr/td[1]/span/div[1]/a");
    public static final By deleteConfirmationButton = By.xpath("/html/body/div[13]/div/div[3]/button[1]");

    public enum StreetType {
        STREET(street);

        private final By locator;
        StreetType(By locator) {
            this.locator = locator;
        }

        public By getLocator() {
            return this.locator;
        }
    }
}
