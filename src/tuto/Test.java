package tuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
				
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
//		D:\Selenium\Sel Project\webdrivertraining\test\resources\geckodriver-64bit.exe
	

		WebDriver driver = new ChromeDriver();
			
		driver.get("http://www.excellonsoft.com/");
				
		driver.manage().window().maximize();
		
		System.out.println("Website login successfully in chrome browser");
		
		driver.close();
	}

}
