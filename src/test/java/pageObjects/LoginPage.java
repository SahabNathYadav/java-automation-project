package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;
	// We can use both either the By class or @FindBy
	By txt_userName = By.id("userid");
	
	// or we can use the page Factory and FindBy 
	
	@FindBy(id="userid")
	@CacheLookup
	WebElement txtUserName;
	
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
