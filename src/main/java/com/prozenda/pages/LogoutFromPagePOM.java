package com.prozenda.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.prozenda.selectors.LogoutFromPage.*;
import static com.prozenda.selectors.LoginPage.*;
/**
 * @author Rebeka Alajtner
 * @created 24/04/2023 - 9:02
 * @project SiliconDreams
 */
public class LogoutFromPagePOM extends AbstractPage{
    public void navigateToLogout(){
        waitUntil(ExpectedConditions.elementToBeClickable(profile));
        getDriver().findElement(profile).click();
        getDriver().findElement(logout).click();
        waitUntil(ExpectedConditions.elementToBeClickable(email));
    }
}
