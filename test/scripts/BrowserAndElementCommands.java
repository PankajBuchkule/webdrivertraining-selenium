package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BrowserAndElementCommands {
	WebDriver driver;

	@Test
	public void testCommands() throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.id("loginname")).sendKeys("stc123");
		driver.get("http://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("http://www.yahoo.com");
		driver.navigate().refresh();
		String current = driver.getCurrentUrl();
		System.out.println("I am in " + current);
		String pageSource = driver.getPageSource();
		System.out.println("I am in " + pageSource);
	}

	@Test
	public void testCheckBox() throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.linkText("Customized tours")).click();
		WebElement checkboxEngland = driver.findElement(By.xpath("//label[text()='England']/input"));
		if (!checkboxEngland.isSelected())
			driver.findElement(By.xpath("//label[text()='England']/input")).click();
		Thread.sleep(3000);

		if (checkboxEngland.isSelected())
			driver.findElement(By.xpath("//label[text()='England']/input")).click();
		Thread.sleep(3000);

	}

	@Test
	public void testRadio() throws InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		// driver.findElement(By.xpath("//input[@value='Petrol']"));
		driver.findElement(By.cssSelector("input[value='Petrol']")).click();

	}

	@Test
	public void testCombo() throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.linkText("Customized tours")).click();
		Select stay = new Select(driver.findElement(By.id("days")));
		assertFalse(stay.isMultiple());
		// Please verify that there are 3 options and they are in the order
		// 5-star Hotel
		// 3-star Hotel
		// Home Stay
		assertEquals(3, stay.getOptions().size(), "No. Of Options are not as per Requirements Document");
		List<String> expectedOptions = new ArrayList();
		List<String> actualOptions = new ArrayList();
		expectedOptions.add("5-star Hotel");
		expectedOptions.add("3-star Hotel");
		expectedOptions.add("Home Stay");

		for (WebElement oneOption : stay.getOptions()) {
			actualOptions.add(oneOption.getText());
		}

		assertEquals(actualOptions, expectedOptions);

		stay.selectByVisibleText(expectedOptions.get(2));
		Thread.sleep(4000);
		stay.selectByIndex(0);
		Thread.sleep(4000);
		String selectedOption = stay.getFirstSelectedOption().getText();
		assertEquals(selectedOption, "5-star Hotel");
		Thread.sleep(4000);
	}

	@Test
	public void testMultiSelect() throws InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		Select colors = new Select(driver.findElement(By.name("color")));
		assertTrue(colors.isMultiple());
		colors.selectByVisibleText("Black");
		colors.selectByIndex(2);
		colors.selectByValue("sl");
		Thread.sleep(4000);
		List<String> expectedSelectedOptions = new ArrayList();
		List<String> actualSelectedOptions = new ArrayList();
		expectedSelectedOptions.add("Black");
		expectedSelectedOptions.add("Red");
		expectedSelectedOptions.add("Silver");

		for (WebElement oneSelectedOption : colors.getAllSelectedOptions()) {
			actualSelectedOptions.add(oneSelectedOption.getText());
		}

		assertEquals(actualSelectedOptions, expectedSelectedOptions,
				"Selected Options does not match with expected Selected Options");

		colors.deselectByVisibleText("Black");
		Thread.sleep(2000);

		colors.deselectByIndex(2);
		Thread.sleep(2000);

		colors.deselectByValue("sl");
		Thread.sleep(2000);

		// colors.deselectAll();
		// Thread.sleep(2000);

	}

	@BeforeMethod
	public void beforeMethod() {
		//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
		driver = new ChromeDriver();
		//driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
