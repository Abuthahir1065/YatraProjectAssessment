package com.atmecs.testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.filePathConstants.FilePathClass;

public class DataProviderClass {
	@DataProvider(name = "cruiseData")
	public static Object[][] getCruiseData() throws IOException {
		XlsReader xls = new XlsReader(FilePathClass.XLSX_DATA_HOME);
		Object[][] data = xls.readExcelData("cruiseSheet");
		System.out.println(data);
		return data;
	
	}

}
