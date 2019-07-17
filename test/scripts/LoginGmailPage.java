package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginGmailPage {
	WebDriver driver;

	@Test
	public void LoginGmailAccount() {

		driver.manage().window().maximize();

		String url = "https://accounts.google.com/signin";

		driver.get(url);

		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - " + strPageTitle);

		driver.findElement(By.id("identifierId")).sendKeys("panks145");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// WebDriverWait wait=new WebDriverWait(driver, 20);

		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();

		driver.findElement(By.name("password")).sendKeys("abn");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("passwordNext")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("launching chrome browser with Gmail Page");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
