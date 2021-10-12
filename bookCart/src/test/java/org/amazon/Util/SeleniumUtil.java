package org.amazon.Util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SeleniumUtil {

	public static void setValueForTextInput(WebElement element, String text) {

		element.sendKeys(text);
	}

	public static void setValueForTextInput(WebElement element) {

		element.sendKeys(Keys.ENTER);
	}

	public static void clickWebElement(WebElement element) {

		element.click();
	}

	public static void setValueForTextInput1(WebElement element, String phone) {
		element.sendKeys(phone);
		
	}

}
