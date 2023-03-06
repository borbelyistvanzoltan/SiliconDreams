package prozenda.stepdefinition;

import com.prozenda.Bench;
import com.prozenda.drivermanager.DriverManager;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

public class Steps {
    private static Bench bench;

    @Before
    public static void setup() {
        if (Bench.bench == null) {
            new Bench();
        }
        bench = Bench.bench;
        bench.openBrowserTest();
    }

    @After(order = 1)
    public static void tearDown() {
        bench.closeTest();
        bench = null;
    }

    @After(order = 2)
    public void af(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            Allure.addAttachment("Screen shoot", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    /*
    @BeforeAll
    @AfterAll
    public static void afterClear() throws InterruptedException {
        setup();
        tearDown();
    }
     */
}
