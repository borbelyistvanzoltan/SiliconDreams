package com.prozenda.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.prozenda.selectors.HelpPage.*;

/**
 * @author Rebeka Alajtner
 * @created 20/04/2023 - 8:31
 * @project SiliconDreams
 */

public class HelpPagePOM extends AbstractPage{
    private static String ds4VersionNumber = null;
    public void navigateToHelp(){
        waitUntil(ExpectedConditions.elementToBeClickable(help));
        getDriver().findElement(help).click();
    }

    public void navigateToAbout(){
        getDriver().findElement(about).click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(versionNumber));
    }

    public void getVersionNumber(){
        ds4VersionNumber = getDriver().findElement(versionNumber).getAttribute("textContent");
    }

    public void setDs4VersionNumber(String ds4VersionNumber) {
        HelpPagePOM.ds4VersionNumber = ds4VersionNumber;
    }

    public  String getDs4VersionNumber() {
        return ds4VersionNumber;
    }
}
