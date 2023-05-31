package com.prozenda.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

/**
 * @author Rebeka Alajtner
 * @created 30/05/2023 - 13:38
 * @project SiliconDreams
 */
public class Report extends UIActions{

    public static void report(String reportText,String title) {
        if (title == null) {
            System.out.println(reportText);
            Allure.step(reportText, Status.PASSED);
        } else {
            System.err.println(reportText);
            Allure.step(reportText, Status.FAILED);
            Allure.addAttachment(title, takeScreenshot());
        }
    }
    public static void report(String reportText){
        report(reportText,null);
    }
}
