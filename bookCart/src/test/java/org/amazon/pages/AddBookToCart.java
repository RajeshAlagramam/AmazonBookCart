package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddBookToCart extends DriverObj {

	@FindBy(xpath = "//span[text()='The Monk Who Sold His Ferrari']")
	WebElement bookName;

	@FindBy(xpath = "//span[text()='151']")
	WebElement bookCost;

	@FindBy(xpath = "//span[@id='submit.add-to-cart']")
	WebElement addToCart;

	@FindBy(xpath = "//div[@id='nav-cart-count-container']")
	WebElement cartBtn;

	@FindBy(xpath = "//span[text()='151.00']")
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
}
