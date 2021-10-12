package org.amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void Initialize(){
		String currentDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				currentDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void TearDown(){
		driver.quit();
	}
	

}
