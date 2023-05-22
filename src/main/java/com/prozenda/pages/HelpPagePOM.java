package com.prozenda.pages;

import com.prozenda.testdata.Version;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.FileReader;
import static com.prozenda.selectors.HelpPage.*;

/**
 * @author Rebeka Alajtner
 * @created 20/04/2023 - 8:31
 * @project SiliconDreams
 */

public class HelpPagePOM extends AbstractPage{
    private static String ds4VersionNumber = null;
    public static Version version;
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

    public void getValidVersionNumber(){
        try {
            version = new Version().init((JSONObject) new JSONParser().parse(new FileReader("VersionNumber.json")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void compareVersionNumber(){
        if (version.getVersionNumber().equals(getDs4VersionNumber())){
            System.out.println("The version numbers are matches! - " + getDs4VersionNumber());
            Allure.step("The version numbers are matches! - " + getDs4VersionNumber(), Status.PASSED);
        } else{
            System.err.println("The version numbers do not match!");
            Allure.step("The version numbers do not match!", Status.FAILED);
        }
    }
}
