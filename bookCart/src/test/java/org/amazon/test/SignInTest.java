package org.amazon.test;

import java.util.Iterator;
import java.util.Set;
import org.amazon.pages.AddBookToCart;
import org.amazon.pages.ErrorMessage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SignInTest {

	@Test
	public void AddBookToCartTest() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Lakshmi\\workspace\\bookCart\\src\\test\\resources\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			String url = "https://www.amazon.in";
			driver.get(url);
			WebDriverWait wd = new WebDriverWait(driver, 5);

			ErrorMessage err = new ErrorMessage(driver);
			wd.until(ExpectedConditions.visibilityOf(err.TextBox()));

			Reporter.log("Page Loaded successfully");

			Reporter.log(driver.getTitle());
			String HomePage = driver.getWindowHandle();
			Reporter.log("Home Window: " + HomePage);

			err.MouseHover();

			err.phone().sendKeys("86799673");
			err.continuebtn().click();

			Reporter.log("Error Message for Invalid Phone Number: " + err.errormsg().getText());

			driver.navigate().to(url);
			Reporter.log("Successfully Navigated to Home Page ");

			AddBookToCart addBook = new AddBookToCart(driver);
			err.TextBox().sendKeys("the monk who sold his ferrari");
			err.TextBox().sendKeys(Keys.ENTER);

			String ActualBookName = addBook.bookName().getText();
			Reporter.log("Book Name: " + ActualBookName);
			Assert.assertEquals(ActualBookName, "The Monk Who Sold His Ferrari");

			String ActualBookCost = addBook.bookCost().getText();
			Reporter.log("Book Cost: " + ActualBookCost);
			Assert.assertEquals(ActualBookCost, "151");

			addBook.bookName().click();
			Reporter.log("Clicked the Book");

			Set<String> s = driver.getWindowHandles();
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {
				String book_window = I1.next();

				if (!HomePage.equals(book_window)) {
					driver.switchTo().window(book_window);
					Reporter.log(driver.switchTo().window(book_window).getTitle());
					addBook.addToCart().click();
					Reporter.log("Clicked - Add To Cart");
					driver.close();
				}
			}
			driver.switchTo().window(HomePage);
			addBook.cartBtn().click();

			Assert.assertEquals(ActualBookName.trim(), "The Monk Who Sold His Ferrari");
			String ActualBookCartCost = addBook.bookCartCost().getText();
			Assert.assertEquals(ActualBookCartCost.trim(), "151.00");

			Reporter.log("Name and cost of book are verified");
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
