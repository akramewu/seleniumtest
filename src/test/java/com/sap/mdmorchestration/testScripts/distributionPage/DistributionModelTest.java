package com.sap.mdmorchestration.testScripts.distributionPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.sap.mdmorchestration.helper.browserConfiguration.config.ObjectReader;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.pageObject.DistributionPage;
import com.sap.mdmorchestration.pageObject.LoginPage;
import com.sap.mdmorchestration.testBase.TestBase;
import com.sap.mdmorchestration.testScripts.loginPage.LoginTest;

public class DistributionModelTest extends TestBase {

private final Logger log = LoggerHelper.getLogger(DistributionModelTest.class);


	@Test(description="Login to mdmorchestration")
	public void testLoginToApplication() throws Exception
	{
	  	getApplicationUrl(ObjectReader.reader.getUrl());
	  	LoginPage loginPage = new LoginPage(driver);
	  	DistributionPage distributionPage = new DistributionPage(driver);
	  	loginPage.enterEmailAdress(ObjectReader.reader.getUserName());
	  	loginPage.enterPassword(ObjectReader.reader.getPassword());
	  	loginPage.clickOnLoginButton();
	  	loginPage.verifySuccessLoginMsg();
		distributionPage.clickonDistrubutionModel();
	  	distributionPage.clickOnAddEntry();
	  	distributionPage.enterValueOnTextBox();
	  	distributionPage.selectDropDownList();
	  	distributionPage.saveButton();
	}
		
}
