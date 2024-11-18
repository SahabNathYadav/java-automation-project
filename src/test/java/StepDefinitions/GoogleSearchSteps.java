package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import pageObjects.GoogleSearchPage;

import utilities.DriverManager;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class GoogleSearchSteps {
	
	private WebDriver driver;
	private GoogleSearchPage googleSearchPage;

	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {
	    System.out.println("Inside the Browser open step");
	    // Below line of code is commented as we are now using DriverManager class to manage the driver version and instance itself.
	    // No need to download the Chrome Driver manually everu time when Chrome version changes.
	    
	    //System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver"); 
	    //driver = new ChromeDriver();
	    
	    //Use the DriverManager to get the driver instance
	    driver = DriverManager.getDriver();
	    
	    
	    googleSearchPage = new GoogleSearchPage(driver);
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    
	}

	@And("user enters the url {string}")
	public void user_is_on_google_search_page(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(5000);
	}

	@When("^user enters a text (.*) in seach box$")
	public void user_enters_a_text_in_seach_box(String searchText) {
		
		googleSearchPage.enterTextInSearchbox(searchText);
	}

	@And("hits enter")
	public void hits_enter() {
	    
		googleSearchPage.pressEnterInSeachbox();
		
	}

	//@Then("^user can search the text (.*) in searched results page$") 
	//we can use either above or below method of passing string to a method
	@Then("user can search the text {string} in searched results page")
	public void user_is_navigated_to_searched_results_page(String searchText) {
		
		googleSearchPage.verifySearchResults(searchText);
		
		System.out.println("Closing the browser");
		DriverManager.quitDriver();
	    
	}




}
