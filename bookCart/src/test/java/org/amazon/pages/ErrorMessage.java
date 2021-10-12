package org.amazon.pages;

import org.amazon.Util.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ErrorMessage extends DriverObj {

	public ErrorMessage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement TextBox;

	@FindBy(xpath = "//span[text()='Hello, Sign in']")
	WebElement Hello;

	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']")
	WebElement clickSignIn;

	@FindBy(xpath = "//input[@type='email']")
	WebElement phone;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement continuebtn;

	@FindBy(xpath = "//h4[text()='Incorrect phone number']")
	WebElement errormsg;

	public WebElement TextBox() {
		return TextBox;
	}

	public WebElement Hello() {
		return Hello;
	}

	public WebElement clickSignIn() {
		return clickSignIn;
	}

	public WebElement phone() {
		return phone;
	}

	public WebElement continuebtn() {
		return continuebtn;
	}

	public WebElement errormsg() {
		return errormsg;
	}

	public void MouseHover() {

		Actions action = new Actions(driver);

		action.moveToElement(Hello()).perform();
		action.moveToElement(clickSignIn()).click().build().perform();
	}

	public void invalidPhone(String phone) {

		Reporter.log(driver.getTitle());
		String HomePage = driver.getWindowHandle();
		Reporter.log("Home Window: " + HomePage);

		MouseHover();
		SeleniumUtil.setValueForTextInput1(phone(), phone);
		continuebtn().click();
		Reporter.log("Error Message for Invalid Phone Number: " + errormsg().getText());
	}

}
