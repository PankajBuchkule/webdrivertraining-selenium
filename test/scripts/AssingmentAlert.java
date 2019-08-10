package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.http.HttpGenerator.Result;
import org.testng.annotations.AfterMethod;

public class AssingmentAlert {
	WebDriver driver;
  @Test
  public void alertTests() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click(); //same line 
	 // driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();  // same line
	  Thread.sleep(3000);
	  try {
		  Alert alert = driver.switchTo().alert();
		  assertEquals("I am a JS Alert", alert.getText());
		  alert.accept();
		  Thread.sleep(3000);
		  
		  String color = driver.findElement(By.id("result")).getCssValue("color");
		  String abc = driver.findElement(By.id("result")).getText();
		  System.out.println("Print Result with actual color : " + abc);
		  assertEquals("rgba(0, 128, 0, 1)", color);
		  System.out.println("Actual Text color is : " + color);
	  }catch (NoAlertPresentException e) {
		  fail("Alert was expected but seems not appearing at this point.");
	  }    
  }
  
 //@Test
  public void alertTestsOkCancel() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
	  Thread.sleep(3000);
	  try {
		  Alert alert = driver.switchTo().alert();
		  assertEquals("I am a JS Confirm", alert.getText());
		  alert.dismiss();
		  Thread.sleep(3000);
	  }catch (NoAlertPresentException e) {
		  fail("Alert was expected but seems not appearing at this point.");
	  }  
		
  }
  
 //@Test
 public void alertTestsOkCancelAndSendkeys() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();

	  try {
		  Alert alert = driver.switchTo().alert();
		  assertEquals("I am a JS prompt", alert.getText());
		  alert.sendKeys("London");
		  Thread.sleep(3000);
		  alert.accept();
		  Thread.sleep(3000);
	  }catch (NoAlertPresentException e) {
		  fail("Alert was expected but seems not appearing at this point.");
	  }  
	  driver.close();
		
 }
 
  
  @BeforeMethod
  public void launchBrowser() {
	    System.out.println("launching browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		
  }

  @AfterMethod
  public void CloseWindow() {
	  driver.quit();
  }

}
