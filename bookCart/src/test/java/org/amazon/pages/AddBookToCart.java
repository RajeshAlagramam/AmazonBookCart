package org.amazon.pages;

import java.util.Iterator;
import java.util.Set;

import org.amazon.Util.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class AddBookToCart extends DriverObj {

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	WebElement bookName;

	@FindBy(xpath = "//span[@class='a-price']")
	WebElement bookCost;

	@FindBy(xpath = "//span[@id='submit.add-to-cart']")
	WebElement addToCart;

	@FindBy(xpath = "//div[@id='nav-cart-count-container']")
	WebElement cartBtn;

	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	WebElement bookCartName;

	@FindBy(xpath = "//p[@class='a-spacing-mini']//span")
	WebElement bookCartCost;

	public AddBookToCart(WebDriver driver) {
		super(driver);
	}

	public WebElement bookName() {
		return bookName;
	}

	public WebElement bookCost() {
		return bookCost;
	}

	public WebElement addToCart() {
		return addToCart;
	}

	public WebElement cartBtn() {
		return cartBtn;
	}

	public WebElement bookCartCost() {
		return bookCartCost;
	}

	public WebElement bookCartName() {
		return bookCartName;
	}

	public void booking(String text, int cost) {
		driver.navigate().to("https://www.amazon.in/");
		String HomePage = driver.getWindowHandle();
		Reporter.log("Successfully Navigated to Home Page ");
		ErrorMessage err = new ErrorMessage(driver);

		SeleniumUtil.setValueForTextInput(err.TextBox(), text);
		SeleniumUtil.setValueForTextInput(err.TextBox());

		String ActualBookName = bookName().getText();
		Reporter.log("Book Name: " + ActualBookName);

		String ActualBookCost = bookCost().getText();
		Reporter.log("Book Cost: " + ActualBookCost);

		SeleniumUtil.clickWebElement(bookName());
		Reporter.log("Clicked the Book");

		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {
			String book_window = I1.next();

			if (!HomePage.equals(book_window)) {
				driver.switchTo().window(book_window);
				Reporter.log(driver.switchTo().window(book_window).getTitle());
				addToCart().click();
				Reporter.log("Clicked - Add To Cart");
				driver.close();
			}
		}
		driver.switchTo().window(HomePage);
		cartBtn().click();

		String CartBookName = bookCartCost().getText();
		Assert.assertEquals(CartBookName.trim(), ActualBookName);
		String CartBookCost = bookCartCost().getText();
		Assert.assertEquals(CartBookCost.trim(), ActualBookCost);

		Reporter.log("Name and cost of book are verified");
	}

}
