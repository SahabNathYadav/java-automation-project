package pageObjects;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

	WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button/div[contains(text(),'Accept all')]")
	@CacheLookup
	WebElement acceptAllButton;
	
	@FindBy(xpath = "//textarea[@title='Search']")
	@CacheLookup
	WebElement serachArea;
	
	public void enterTextInSearchbox(String searchText) {
		acceptAllButton.click();
		serachArea.sendKeys(searchText);
	}
	
	public void pressEnterInSeachbox() {
		serachArea.sendKeys(Keys.ENTER);
	}
	
	public void verifySearchResults(String searchText) {
		
		driver.getPageSource().contains(searchText);
		
		System.out.println("Closing the browser");
	}
	
	
	
}
