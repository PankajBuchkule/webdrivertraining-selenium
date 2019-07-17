package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AssingmentBrowserComands {
	WebDriver driver;

	@Test

	public void webbrowsercommand() throws InterruptedException {
		
		driver.get("http://www.google.com"); 									// Where appUrl is the Website address to load.
		driver.manage().window().maximize();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("http://www.yahoo.com");
		//driver.navigate().refresh();											// Refresh current page
		String strPageTitle = driver.getTitle();								// This method fetches the Title of the current page.
		System.out.println("Page title: - "+strPageTitle);						// As the return type is a String value, the output must be stored in String object/variable.
		String current = driver.getCurrentUrl();								// Current URL which is opened in the browser.
		System.out.println("Cureent URL is :  " + current);						// As the return type is a String value, the output must be stored in String object/variable.
		//String pageSource = driver.getPageSource();							// This method returns the Source Code of the page.
		//System.out.println("I am in page source : \n "+ pageSource);
		driver.close(); 														// Quit the browser if it’s the last window currently open.
	
	}

	@BeforeMethod
	public void lounchbrowser() {
		System.out.println("launching chrome browser with Gmail Page");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open respective Browser
	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();					// Close every associated window.
	}

}
