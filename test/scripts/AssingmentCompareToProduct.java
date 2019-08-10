package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class AssingmentCompareToProduct {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException, AWTException {
		
		driver.manage().window().maximize();
		driver.get("https://www.gsmarena.com/");
		driver.findElement(By.className("pad")).click();
		//driver.findElement(By.) 
		
		
		
	}
	
  public void f() {
  }
  @BeforeMethod
	public void beforeMethod() {
		System.out.println("launching browser ");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
