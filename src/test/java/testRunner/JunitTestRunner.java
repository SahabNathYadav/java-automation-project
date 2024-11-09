package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
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
public class JunitTestRunner {

}

