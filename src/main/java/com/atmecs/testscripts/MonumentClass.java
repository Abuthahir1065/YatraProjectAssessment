package com.atmecs.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.browser.SetUpClass;
import com.atmecs.filePathConstants.FilePathClass;
import com.atmecs.helpers.HelperClass;
import com.atmecs.utilities.PropertyReader;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MonumentClass extends SetUpClass {
	PropertyReader locators;

	@Test
	public void displayMonuments() throws InterruptedException {

		locators = new PropertyReader(FilePathClass.LOCATORS_HOME);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HelperClass.PerformClick(driver, locators.get("moreLinkXpath"));

		HelperClass.PerformClick(driver, locators.get("monumentLinkPath"));
		
		
		if(HelperClass.checkIfDisplayed(driver, locators.get("iFrameXpath")))
		{
			HelperClass.closeAd(driver, locators.get("iFrameXpath"), locators.get("iFrameCloseXpath"));


		}
		

		
		boolean topMonuments = HelperClass.checkIfDisplayed(driver, locators.get("topMonumentsXpath"));

		Assert.assertEquals(true, topMonuments);
		if (topMonuments == true) {
			Reporter.log("Top Monuments Section  has been Displayed");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean qutubMinarstatus = HelperClass.checkIfDisplayed(driver, locators.get("qutubMinarXpath"));
		Assert.assertEquals(true, qutubMinarstatus);
		if (qutubMinarstatus == true) {
			Reporter.log("Qutub Minar has been Displayed");
		}
		boolean tombStatus = HelperClass.checkIfDisplayed(driver, locators.get("humayunsTombXpath"));
		Assert.assertEquals(true, tombStatus);
		if (tombStatus == true) {
			Reporter.log("Humayuns Tomb has been Displayed");
		}
	}
}
