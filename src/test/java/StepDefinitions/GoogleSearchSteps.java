package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GoogleSearchPage;
import io.cucumber.java.en.And;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSteps {
	
	private WebDriver driver = null;
	private GoogleSearchPage googleSearchPage;
	//ChromeOptions options = new ChromeOptions();
	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {
	    System.out.println("Inside the Browser open step");
	    System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver");
	    
	    driver = new ChromeDriver();
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
		driver.close();
		driver.quit();
	    
	}




}
