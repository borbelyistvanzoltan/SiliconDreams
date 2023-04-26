package prozenda.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Rebeka Alajtner
 * @created 26/04/2023 - 14:32
 * @project SiliconDreams
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"prozenda/partnerstepdefinition"},
        tags = "@TC_01",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true)
public class PartnersModuleRunnerTest {}
