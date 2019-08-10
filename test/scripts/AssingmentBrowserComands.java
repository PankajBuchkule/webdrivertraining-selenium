package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AssingmentBrowserComands {
	WebDriver driver;

	@Test

	public void webbrowsercommand() throws InterruptedException {
		
		/*
		 * driver.get("http://www.google.com"); // Where appUrl is the Website address
		 * to load. driver.manage().window().maximize(); driver.navigate().back();
		 * driver.navigate().forward(); driver.navigate().to("http://www.yahoo.com");
		 * driver.navigate().refresh(); // Refresh current page String strPageTitle =
		 * driver.getTitle(); // This method fetches the Title of the current page.
		 * System.out.println("Page title: - "+strPageTitle); // As the return type is a
		 * String value, the output must be stored in String object/variable. String
		 * current = driver.getCurrentUrl(); // Current URL which is opened in the
		 * browser. System.out.println("Cureent URL is :  " + current); // As the return
		 * type is a String value, the output must be stored in String object/variable.
		 * String pageSource = driver.getPageSource(); // This method returns the Source
		 * Code of the page. System.out.println("I am in page source : \n "+
		 * pageSource); driver.switchTo().window("http://www.excellonsoft.com/");
		 * 
		 */
		
		  driver.get("http://demo.guru99.com/test/guru99home/"); // navigates to the browser 
		  driver.manage().window().maximize(); // navigates to the page consisting an iframe 
		  Thread.sleep(5000);
		  driver.switchTo().frame("a077aa5e"); //switching the frame by ID
		  Thread.sleep(5000);
		  System.out.println("********We are switch to the iframe*******");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("html/body/a/img")).click(); //Clicks the iframe
		  
		  System.out.println("*********We are done***************");
		  
  	
		/*
		 * driver.get("http://www.google.co.uk/");
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 * 
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * driver.switchTo().window(tabs.get(1)); //switches to new tab
		 * driver.get("https://www.facebook.com");
		 * 
		 * driver.switchTo().window(tabs.get(0)); // switch back to main screen
		 * driver.get("https://www.news.google.com");
		 */
		driver.close(); 														// Quit the browser if it’s the last window currently open.
	
	}

	private WebElement WebElement(WebDriver frame) {
		// TODO Auto-generated method stub
		return null;
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
