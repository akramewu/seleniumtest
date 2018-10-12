package com.sap.mdmorchestration.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.sap.mdmorchestration.helper.browserConfiguration.config.ObjectReader;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.helper.wait.WaitHelper;
import com.sap.mdmorchestration.testBase.TestBase;

public class FilterListPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(FilterListPage.class);
	WaitHelper waitHelper;
	
	@FindBy(id = "com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ListReport.view.ListReport::SubscriptionDistributions--listReportFilter-filterItemControl_BASIC-Model-inner")
	public WebElement MODEL_SEARCH;
	
	@FindBy(css = "[data-sap-ui='com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ListReport.view.ListReport::SubscriptionDistributions--listReportFilter-btnGo']")
	public WebElement GO_BTN;
	
	@FindBy(css = "div tbody tr:first-child td div div div div")
	public WebElement MODEL_LIST;
	
	@FindBy(id = "com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ListReport.view.ListReport::SubscriptionDistributions--deleteEntry")
	public WebElement DELETE_ENTRY;
	
	@FindBy(css = "[data-sap-ui='__button5']")
	public WebElement DELETE_BTN;
	
	
	public FilterListPage(final WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(MODEL_SEARCH,ObjectReader.reader.getExpliciteWait());
		TestBase.logExtentReport("Filter List Page Object Created ");
	}
	
	public void modelSearch() throws Exception
	{
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		log.info("search model...");
		logExtentReport("search model...");
		waitHelper.waitForElement(MODEL_SEARCH,ObjectReader.reader.getExpliciteWait());
		MODEL_SEARCH.sendKeys("TestAddEntry");
		
	}
	
	public void clickButtonGo() throws Exception
	{
		log.info("click go button...");
		logExtentReport("click go button...");
		GO_BTN.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
	}
	
	public void clickModelList() throws Exception
	{
		log.info("click model list...");
		logExtentReport("click model list...");
		waitHelper.waitForElement(MODEL_LIST,ObjectReader.reader.getExpliciteWait());
		MODEL_LIST.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
	}
	
	public void deleteEntry() throws Exception
	{
		log.info("delete entry list...");
		logExtentReport("delete entry list...");
		DELETE_ENTRY.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		DELETE_BTN.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
	}
	
	public void logExtentReport(String s1)
	{
	  TestBase.test.log(Status.INFO, s1);	
	}
}
