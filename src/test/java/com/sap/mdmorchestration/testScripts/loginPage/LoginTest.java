package com.sap.mdmorchestration.testScripts.loginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.sap.mdmorchestration.helper.browserConfiguration.config.ObjectReader;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.pageObject.DistributionPage;
import com.sap.mdmorchestration.pageObject.LoginPage;
import com.sap.mdmorchestration.testBase.TestBase;

public class LoginTest extends TestBase {

	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
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
	}
}
