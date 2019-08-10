package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class AnnaUnivTest {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[5]/div/a"))
				.click();
		openOceanManagement();

	}

	@BeforeMethod
	public void launchBrowser() throws InterruptedException {

		System.out.println("launching Web Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // Open Chrome web Browser

		driver.manage().window().maximize();
		driver.get("http://annauniv.edu/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	public void openOceanManagement() throws InterruptedException {

		Actions builder = new Actions(driver);

		// WebElement target =
		// driver.findElement(By.xpath("//*[contains(text(),\"Faculty of Civil
		// Engineering\")]"));
		WebElement target = driver.findElement(By.linkText("Faculty of Civil Engineering"));
		builder.moveToElement(target).build().perform();
		Thread.sleep(2000);
		// WebElement target2 = driver.findElement(By.linkText("Institute for Ocean
		// Management"));

		WebElement target2 = driver.findElement(By.xpath("//div[@id='menuItem32']"));// CSSslector - #menuItem32
		Thread.sleep(2000);
		builder.moveToElement(target2).click().build().perform();
		Thread.sleep(5000);

		assertEquals(
				"Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts",
				driver.getTitle());
		System.out.println("Page title correct");
		Thread.sleep(2000);

		WebElement reserchThemes = driver.findElement(By.linkText("Research Themes"));
		builder.moveToElement(reserchThemes).build().perform();
		Thread.sleep(2000);
		WebElement coastalEcosystem = driver.findElement(By.xpath("//div[@id='menuItem12']"));
		builder.moveToElement(coastalEcosystem).click().build().perform();

		Thread.sleep(3000);
		assertEquals(":: IOM - Institute For Ocean Management - Anna University ::", driver.getTitle());
		System.out.println("Page title coorect 2");

		driver.close();

	}

	@AfterMethod
	public void exitBrowser() {
		driver.quit();
	}

}
