package com.sap.mdmorchestration.testScripts.distributionPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.sap.mdmorchestration.helper.browserConfiguration.config.ObjectReader;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.pageObject.DistributionPage;
import com.sap.mdmorchestration.pageObject.FilterListPage;
import com.sap.mdmorchestration.pageObject.LoginPage;
import com.sap.mdmorchestration.testBase.TestBase;

public class SubscriptionDistributionListTest extends TestBase {

	private final Logger log = LoggerHelper.getLogger(SubscriptionDistributionListTest.class);
	
	@Test(description="Subscription Distribution List")
	public void testSubscriptionDistributionList() throws Exception
	{
	  getApplicationUrl(ObjectReader.reader.getUrl());
	  LoginPage loginPage = new LoginPage(driver);
	  DistributionPage distributionPage = new DistributionPage(driver);
	  FilterListPage filterlistPage = new FilterListPage(driver);
	  loginPage.enterEmailAdress(ObjectReader.reader.getUserName());
	  loginPage.enterPassword(ObjectReader.reader.getPassword());
	  loginPage.clickOnLoginButton();
	  distributionPage.clickonDistrubutionModel();
	  filterlistPage.modelSearch();
	  filterlistPage.clickButtonGo();
	  filterlistPage.clickModelList();
	  filterlistPage.deleteEntry();
	}
}
