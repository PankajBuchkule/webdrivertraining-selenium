package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.commandhandler.ExceptionHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TripHoboAssingments {
	WebDriver driver;

	@Test
	public void LoginPage() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("https://www.triphobo.com");

		driver.findElement(By.id("plan-my-trip")).click();// Search any - Johannesburg, South Africa
		driver.findElement(
				By.xpath("//*[@id=\"screen-wrapper\"]/div[3]/div/section/div[1]/div/div[1]/div[1]/div/div/div/input"))
				.sendKeys("Johannesburg");

		driver.findElement(By.cssSelector(
				"#js-suggestions > div.city-parent-box.city-box.dangling-el > div > ul > li:nth-child(1) > span"))
				.click();

		driver.findElement(By.xpath("//*[@id=\"screen-wrapper\"]/div[3]/div/section/div[2]/div[1]/div/span[1]"))
				.click();

		driver.findElement(By.xpath("//input[@placeholder='Start Date']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[4]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='End Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[6]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"screen-wrapper\"]/div[3]/div/section/div[3]/div/span")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Preferences')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Transportation')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Accommodation')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Bindle')]")).click();
		Thread.sleep(2000);

		hoveraction();
		driver.findElement(
				By.xpath("//*[@id=\"screen-wrapper\"]/div[3]/div/section/div[2]/ul/li[3]/div/div[2]/div[3]/span"))
				.click();
		Thread.sleep(3000);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("launching Web Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	private void hoveraction() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//*[contains (text(),'Museum africa')]"));
		actions.moveToElement(target).perform();
		Thread.sleep(3000);

	}
}
