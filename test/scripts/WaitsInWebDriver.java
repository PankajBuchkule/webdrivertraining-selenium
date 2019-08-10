package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class WaitsInWebDriver {
	WebDriver driver;
  @Test
  public void waitTest() throws InterruptedException {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.findElement(By.xpath("//div[@id='start']/button[text()='Start']")).click();;
//	  Thread.sleep(6000);
	  WebElement output = driver.findElement(By.xpath("//div[@id='finish1']/h4[text()='Hello World!']"));
	  assertEquals(output.getText(),"Hello World!");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("launching chrome browser with Gmail Page");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
