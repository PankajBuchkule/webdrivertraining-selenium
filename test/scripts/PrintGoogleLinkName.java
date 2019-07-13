package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PrintGoogleLinkName {
	WebDriver driver;
  @Test
  public void testgooglelink() {
	  
	  driver.get("http://www.google.com");
	  List<WebElement> allGooglelinks = driver.findElements(By.tagName("a"));
	  
	  int noOfLinks = allGooglelinks.size();
	  
	  System.out.println("Normal For Loop");

	  for(int i = 0; i<noOfLinks; i++ ) {
		  System.out.println(allGooglelinks.get(i).getText() + "-" + allGooglelinks.get(i).getAttribute("href"));
	  }
  
	  System.out.println("Advanced For Loop");
	  for(WebElement oneLinkAtATime:allGooglelinks ) {
		  System.out.println(oneLinkAtATime.getText() + "-" + oneLinkAtATime.getAttribute("href"));
	  }
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver(); // Open chrome web browser
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
