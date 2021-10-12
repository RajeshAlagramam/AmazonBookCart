package org.amazon.test;

import org.amazon.pages.AddBookToCart;
import org.amazon.pages.ErrorMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignInTest extends DriverTest {
 
	public static WebDriver driver;


	@Test 
	@Parameters({"text","cost"})
	public void AddBookToCartTest(String text,int cost,String phone) {
		try {
			
			driver.get("https://www.amazon.in/");
			WebDriverWait wd = new WebDriverWait(driver, 5);

			ErrorMessage err = new ErrorMessage(driver);
			wd.until(ExpectedConditions.visibilityOf(err.TextBox()));
			err.invalidPhone(phone);

			AddBookToCart adb = new AddBookToCart(driver);
			adb.booking(text, cost);
			Reporter.log("Page Loaded successfully");


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
