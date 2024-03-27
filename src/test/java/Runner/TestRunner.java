package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions"},
        plugin = {
                "pretty",
                "json:reports/cucumber-json-reports/json-report.json",
                "html:reports/cucumber-html-reports/html-report.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
