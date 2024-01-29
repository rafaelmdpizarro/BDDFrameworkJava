package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features = {"src/test/resources/Features"},
glue = {"StepDefinitions"},
plugin = {"pretty", "html:target/HtmlReport.html"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {


}