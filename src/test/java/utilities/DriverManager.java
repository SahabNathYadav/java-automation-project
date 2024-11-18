package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	// ThreadLocal variable to hold ebDriver instances for each thread
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//Private constructor to prevent instantiation from outside the class
	private DriverManager() {
		
	}
	
	public static WebDriver getDriver() {
		
		if (driver.get() == null) {
			
			// Setup SebDriverManager
			WebDriverManager.chromedriver().setup();
			
			// Initialise the ChromeDriver for the current thread
			driver.set(new ChromeDriver());
		}
		
		return driver.get();
	}
	
	public static void quitDriver() {
		
		if (driver.get() != null) {
			driver.get().quit();
			// Remove the driver instance for the current thread
			driver.remove();
		}
	}

}
