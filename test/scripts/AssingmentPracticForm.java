package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class AssingmentPracticForm {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, AWTException {
		
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-form/");
	
		driver.findElement(By.name("firstname")).sendKeys("Pankaj");
		driver.findElement(By.name("lastname")).sendKeys("Buchkule");

		driver.findElement(By.xpath("//*[@id=\"sex-0\"]")).click(); 			//Select Radio button
		driver.findElement(By.id("exp-2")).click(); 							//Select Radio button
		driver.findElement(By.id("datepicker")).sendKeys("17-July-2019");  		//Date set
		driver.findElement(By.id("profession-1")).click();						//Select check box
		//driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click(); // Select Link		
		
		WebElement upload = driver.findElement(By.id("photo"));
		upload.sendKeys("C:\\Users\\pankajb\\Desktop\\temp cmd.png");			//Choose-Select File from system 
		
		driver.findElement(By.id("tool-1")).click();	
		driver.findElement(By.id("tool-2")).click();	
		
		Select country = new Select(driver.findElement(By.id("continents")));  	//drop down
		country.selectByVisibleText("North America");
		
		Select SelCommand = new Select(driver.findElement(By.name("selenium_commands")));
		assertTrue(SelCommand.isMultiple());
		SelCommand.selectByVisibleText("Browser Commands");
		SelCommand.selectByVisibleText("Navigation Commands");
		//SelCommand.selectByIndex(2);
		//SelCommand.selectByValue("wait");

		//driver.findElement(By.id("submit")).click();		
		
		Thread.sleep(9000);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("launching chrome browser with automation-practice-form");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}