package com.atmecs.helpers;

import java.util.concurrent.TimeUnit;

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
	public static void waitAndSelect(WebDriver driver,String xpath) throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath(xpath)).click();
		
	}

	public static void closeAd(WebDriver driver,String iFrameXpath,String closeXpath)
	{
		driver.switchTo().frame(driver.findElement(By.xpath(iFrameXpath)));
		driver.findElement(By.xpath(closeXpath)).click();
		driver.switchTo().parentFrame();
	}

	public static boolean checkIfDisplayed(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();

	}

}
