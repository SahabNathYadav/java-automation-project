package seleniumUsingTestNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.text.RandomStringGenerator;

public class SimpleTestUsingTestNG {

	@Test(priority=1,groups= {"sanity","sanityTest"})
	public void firstTest() {
		System.out.println("Sahab first testng test is running ...");
		//System.setProperty("webdriver.chrome.driver","/Users/sahabnathyadav/Desktop/Chrome/chromedriver");
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com");
		String title = driver.getTitle();
		System.out.println("Title is :"+title);
		driver.quit();
		// Assert.assertTrue(false);
	}
	
	@Test(priority = 2, dependsOnMethods = {"firstTest"}, groups = {"sanity"})
	public void testRandomString() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').get();
		String generatedString = generator.generate(5,8);
		System.out.println("Random string:"+generatedString);
		
	}
}
