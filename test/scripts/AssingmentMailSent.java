package scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AssingmentMailSent {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, AWTException {
		driver.manage().window().maximize();
		driver.get("https://mail.google.com");

		driver.findElement(By.id("identifierId")).sendKeys("panks145");


		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();

		driver.findElement(By.name("password")).sendKeys("*****");
	
		driver.findElement(By.id("passwordNext")).click();

		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click(); // Click on Compose button
		Thread.sleep(5000);  // ketan@paratussystems.com

		driver.findElement(By.id(":dd")).sendKeys("pankajbuchkule@gmail.com"); // write mail id to whom do you want to (puja.kale0204@gmail.com)
																				// send an email

		driver.findElement(By.id(":cv")).sendKeys("Ketan Sir, I have done my assingment - Puja Kale"); // write subject

		WebElement element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		element.click();
		element.sendKeys(
				"Hello Ketan Sir,\n \"To become an expirenced automation tester one should get training  from you"); // type
																														// in
																														// message
																														// body
		driver.findElement(By.cssSelector("div[class= 'T-I J-J5-Ji aoO v7 T-I-atl L3']")).click(); // click on send
																									// button
		Thread.sleep(9000);
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
		driver.quit();
	}
}
