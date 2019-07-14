package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BrowserAndElementCommand {
	WebDriver driver;
	
	@Test
    public void testdrivercommands() {
				
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            driver.findElement(By.id("loginpage")).sendKeys("pankaj");
            driver.get("https://www.gmail.com");
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().to("https://www.google.com");
            driver.navigate().refresh();
            String current =driver.getCurrentUrl();
            System.out.println("I AM IN" + current);
            String pageSource = driver.getPageSource();
            System.out.println("I AM IN" + pageSource);
            
            
            
            String strPageTitle = driver.getTitle();
            
    		System.out.println("Page title: - "+strPageTitle);	

            driver.findElement(By.id("identifierId")).sendKeys("panks145");       

            driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click(); 
            
            driver.findElement(By.name("password")).sendKeys("pankaj");
               
            driver.findElement(By.id("passwordNext")).click();
       }
	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("launching chrome browser with Gmail Page");
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open chrome web browser
  }

  @AfterMethod
  public void afterMethod() {
	  Wait.class.desiredAssertionStatus();
	  driver.quit();
  }

}
