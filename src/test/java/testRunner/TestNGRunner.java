package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features", 
		glue={"StepDefinitions"},
		monochrome = true, 
		dryRun = false, 
		plugin = {"pretty", 
				"html:target/Reports/HtmlReports", 
				"json:target/Reports/JsonlReports",
				"junit:target/Reports/JunitReports"},
		tags = "@tag3"
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
