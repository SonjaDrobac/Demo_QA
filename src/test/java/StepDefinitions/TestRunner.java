package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/TestCases" , glue={"StepDefinitions"},
        plugin = {"pretty","junit:target/JunitReport/report.xml"},
        tags = "@Test04"


)
public class TestRunner {
}
