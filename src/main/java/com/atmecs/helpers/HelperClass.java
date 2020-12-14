package com.atmecs.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.browser.SetUpClass;

public class HelperClass extends SetUpClass {

	public HelperClass(WebDriver driver) {
		this.driver = driver;
	}

	public static void PerformClick(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void waitAndEntertext(WebDriver driver, String xpath, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement waitElement = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
		waitElement.click();
		waitElement.sendKeys(text);
		waitElement.sendKeys(Keys.ENTER);
	}

	public static boolean checkIfDisplayed(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();

	}

}
