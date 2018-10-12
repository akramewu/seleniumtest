package com.sap.mdmorchestration.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.helper.wait.WaitHelper;
import com.sap.mdmorchestration.testBase.TestBase;

public class HomePage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	public HomePage(final WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	public void logExtentReport(String s1)
	{
	  TestBase.test.log(Status.INFO, s1);	
	}
}
