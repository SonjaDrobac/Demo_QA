package StepDefinitions;

import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;
import java.time.Duration;

public class Hooks {

    TestContext testContext;
    public Hooks(TestContext testContext){
        this.testContext =testContext;
    }

    @Before
    public void setUp() {
        testContext.baseTest.getDriver().manage().window().maximize();
        testContext.baseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) testContext.baseTest.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
            // Allure.addAttachment("failed screen shot",new ByteArrayInputStream(screenshot));
        }
    }

    @After
    public void tearDown() {
        testContext.baseTest.closeDriver();
    }
}
