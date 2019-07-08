package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstWeDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // Open chrome web browser
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.id("loginname")).sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		String expectedTitle = "My account";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle))
			System.out.println("Test case Passed");
		else
			System.out.println("Test cases Failed");
		driver.quit();
	}


}
