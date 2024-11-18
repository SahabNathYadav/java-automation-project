package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.DriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeClass;

import io.cucumber.java.en.And;

public class LoginSteps {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void browser_is_open() {
	    System.out.println("Inside the Browser open step");
	    
	    //Use the DriverManager to get the driver instance
	    driver = DriverManager.getDriver();

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_userid_and_password(String user, String pass) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User entered login id and password: "+user+","+pass);
	}

	@And("^cliks on login button (.*)$")
	public void cliks_on_login_button(String button) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User clicked login button:"+button);
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on home page");

		System.out.println("Closing the browser");
		DriverManager.quitDriver();
	}

}
