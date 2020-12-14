package com.atmecs.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.browser.SetUpClass;
import com.atmecs.filePathConstants.FilePathClass;
import com.atmecs.helpers.HelperClass;
import com.atmecs.testdata.DataProviderClass;
import com.atmecs.utilities.PropertyReader;

public class SearchCruiseClass extends SetUpClass {

	PropertyReader locators;

	@Test(dataProvider = "cruiseData", dataProviderClass = DataProviderClass.class)

	public void searchCruise(String destination, String dates, String days, String cruiseLines)
			throws InterruptedException

	{
		Reporter.log("Opening Home Page");
		locators = new PropertyReader(FilePathClass.LOCATORS_HOME);
		HelperClass.PerformClick(driver, locators.get("moreLinkXpath"));
		HelperClass.PerformClick(driver, locators.get("cruiseLinkXpath"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Navigated to Cruise Search Page");
		HelperClass.waitAndEntertext(driver, locators.get("destinationXpath"), destination);
		HelperClass.waitAndEntertext(driver, locators.get("dateXpath"), dates);
		HelperClass.waitAndEntertext(driver, locators.get("daysXpath"), days);
		HelperClass.waitAndEntertext(driver, locators.get("cruiselineXpath"), cruiseLines);
		Reporter.log("Entered all Cruise Details");
		HelperClass.PerformClick(driver, locators.get("searchButtonXpath"));
		Reporter.log("Navigated to Cruise list Page");
		HelperClass.PerformClick(driver, locators.get("buttonXpath"));

	}
}
