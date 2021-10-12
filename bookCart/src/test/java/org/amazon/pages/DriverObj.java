package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverObj {

	WebDriver driver;

	public DriverObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
