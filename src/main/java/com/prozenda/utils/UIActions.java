package com.prozenda.utils;

import com.prozenda.drivermanager.DriverManager;
import com.prozenda.pages.AbstractPage;
import com.prozenda.testdata.TestData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import static com.prozenda.utils.WaitEnum.*;

/**
 * @author Rebeka Alajtner
 * @created 24/04/2023 - 13:19
 * @project SiliconDreams
 */
public class UIActions extends AbstractPage {
    public static TestData testData;
    public static boolean isElementVisible(By element) {
        try {
            waitToElement(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            System.err.println("TimeoutException, the element is not visible!\n" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Another exception type:\n" + e.getMessage());
            return false;
        }
    }

    public static void elementClick(By _element) {
        try {
            if (isElementVisible(_element)) {
                waitToElement(ExpectedConditions.elementToBeClickable(_element));
                DriverManager.getInstance().getDriver().findElement(_element).click();
            }
        } catch (NoSuchElementException e) {
            System.err.println("NoSuchElementException, the element is not visible!\n" + e.getMessage());
        } catch (StaleElementReferenceException e) {
            System.err.println("StaleElementReferenceException, the element is does not exist!\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception type:\n" + e.getMessage());
        }
    }

    public static void setText(By element, String text, boolean clear) {
        try {
            if (isElementVisible(element)) {
                WebElement webElement = DriverManager.getInstance().getDriver().findElement(element);
                if (clear)
                    webElement.clear();
                try{
                    Thread.sleep(4000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                webElement.sendKeys(text);
            }
        } catch (NoSuchElementException e) {
            System.err.println("NoSuchElementException, the element is not visible!\n" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException, the text is null!\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception type!\n" + e.getMessage());
        }
    }
    public static ByteArrayInputStream takeScreenshot(){

        return new ByteArrayInputStream(((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES));
    }

    public static void waitForInput(By element, String attribute, int maxWaitTime){
        int maxWait =0;
        while(maxWait<=maxWaitTime && getDriver().findElement(element).getAttribute(attribute).trim().equals("")){
            try{
                Thread.sleep(500);
                maxWait +=500;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void readTheTestData(){
        try {
            testData = new TestData().init((JSONObject) new JSONParser().parse(new FileReader("TestData.json")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static WaitEnum waitToElement(ExpectedCondition condition) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(condition);
            return ELEMENTLOCATED;
        } catch (NoAlertPresentException e) {
            return NOALERT;
        } catch (TimeoutException e) {
            return TIMEOUT;
        } catch (ElementClickInterceptedException e){
            return CLICKINTERCEPTED;
        }catch (Exception e){
            Assert.fail("The web element could not be located");
            return EXCEPTION;
        }
    }

    public static void clear(By element) {
        try {
            if (isElementVisible(element)) {
                WebElement webElement = DriverManager.getInstance().getDriver().findElement(element);
                sleep(500);
                webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                sleep(1000);
            }
        } catch (NoSuchElementException e) {
            System.err.println("NoSuchElementException, the element is not visible!\n" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException, the text is null!\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception type!\n" + e.getMessage());
        }
    }

    public static void scrollByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public static void scrollByPixel(int y){
        scrollByPixel(0, y);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException, the specified waiting time in the parameter is negative!\n" + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("InterruptedException, the waiting thread was aborted!\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception.\n" + e.getMessage());
        }
    }

}
