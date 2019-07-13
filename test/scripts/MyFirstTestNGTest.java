package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MyFirstTestNGTest {                           //Run Program Using TestNG framwork - edit
	WebDriver driver;
	@Test
  public void loginTest() {
	  driver.findElement(By.id("loginname")).sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		String expectedTitle = "My account";
		String actualTitle = driver.getTitle();
//		if (expectedTitle.equals(actualTitle))
//			System.out.println("Test case Passed");
//		else
//			System.out.println("Test cases Failed");
//	
		
		assertEquals(expectedTitle,actualTitle, "Test case Failed");
	
	  
  }
  @BeforeMethod
  public void loginpage() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver(); // Open chrome web browser
		driver.get("http://selenium-examples.nichethyself.com");
	  
  }

  @AfterMethod
  public void posttestcleanup() {
		driver.quit();
  }

}
