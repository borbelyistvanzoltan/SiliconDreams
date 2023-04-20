package com.prozenda.selectors;

import org.openqa.selenium.By;

/**
 * @author Rebeka Alajtner
 * @created 20/04/2023 - 8:58
 * @project SiliconDreams
 */
public class HelpPage {
    private HelpPage() {}
    public static final By help = By.xpath("//*[ text() = 'Súgó']");
    public static final By about = By.xpath("//*[ text() = 'Névjegy']");
    public static final By versionNumber = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h5[1]");
}
