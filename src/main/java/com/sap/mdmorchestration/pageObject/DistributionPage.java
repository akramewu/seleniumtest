package com.sap.mdmorchestration.pageObject;

import java.util.List;

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

public class DistributionPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(DistributionPage.class);
	WaitHelper waitHelper;
	
	
	@FindBy(css = "[data-sap-ui='__tile2']")
	public WebElement DISTRIBUTION_MODEL;
	@FindBy(css = "[data-sap-ui='com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ListReport.view.ListReport::SubscriptionDistributions--addEntry']")
	public WebElement ADD_ENTRY;
	@FindBy(css = "input.island-button")
	public WebElement LOGON_BTN;
	@FindBy(id = "com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ObjectPage.view.Details::SubscriptionDistributions--headerEditable::com.sap.vocabularies.UI.v1.HeaderInfo::Title::Field-input-inner")
	public WebElement MODEL;
	@FindBy(id = "com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ObjectPage.view.Details::SubscriptionDistributions--headerEditable::com.sap.vocabularies.UI.v1.FieldGroup::generalInformation::BusinessObject::Field-input-inner")
	public WebElement BUSINESS_OBJECT;
	@FindBy(id = "com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ObjectPage.view.Details::SubscriptionDistributions--headerEditable::com.sap.vocabularies.UI.v1.FieldGroup::generalInformation::BusinessObjectType::Field-input-inner")
	public WebElement BUSINESS_OBJECT_TYPE;
	@FindBy(css = "[data-sap-ui='__select2']")
	public WebElement FREQUENCY_DROPDOWN;
	@FindBy(css = ".sapMSelectListItem")
	List<WebElement> DROPDOWN_LIST;
	@FindBy(css = "div#__select3")
	public WebElement MODE;
	@FindBy(id = "__item59")
	public WebElement MODE_PULL;
	@FindBy(css = "[data-sap-ui='com.sap.mdm.orchestration.distribution::sap.suite.ui.generic.template.ObjectPage.view.Details::SubscriptionDistributions--save']")
	public WebElement SAVE_BTN;
	
	
	public DistributionPage(final WebDriver driver) {
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(LOGON_BTN,ObjectReader.reader.getExpliciteWait());
		TestBase.logExtentReport("Distribution Page Object Created ");
	}
	
	public HomePage clickonDistrubutionModel() throws Exception
	{
		log.info("click on distrubutuion model...");
		waitHelper.waitForElement(DISTRIBUTION_MODEL,ObjectReader.reader.getExpliciteWait());
		logExtentReport("clicked on distrubutuion model link...");
		DISTRIBUTION_MODEL.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
	    return new HomePage(driver);
	    
	}
	
	public HomePage clickOnAddEntry() throws Exception
	{
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		log.info("clicking on (+) button...");
		logExtentReport("clicking on (+) button...");
		ADD_ENTRY.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		return new HomePage(driver);
	}
	
	public HomePage enterValueOnTextBox() throws Exception
	{
		log.info("entering text on model...");
		logExtentReport("entering text on model...");
		MODEL.sendKeys("TestAddEntry");
		log.info("entering text on business object...");
		logExtentReport("entering text on business object...");
		BUSINESS_OBJECT.sendKeys("Test");
		log.info("entering text on object type...");
		logExtentReport("entering text on object type...");
		BUSINESS_OBJECT_TYPE.sendKeys("Test");
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		return new HomePage(driver);
	}
	
	public HomePage selectDropDownList() throws Exception
	{
		log.info("selecting dropdown frequency list...");
		logExtentReport("selecting dropdown frequency list...");
		FREQUENCY_DROPDOWN.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		List<WebElement> list = DROPDOWN_LIST;
		for (WebElement ele : list) {
			if (ele.getText().trim().equalsIgnoreCase("Immediately")) {
				log.info("selecting Immediately from dropdown...");
				logExtentReport("selecting Immediately from dropdown...");
				ele.click();
				break;
			}
		}
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		return new HomePage(driver);
	}
	
	public HomePage saveButton() throws Exception
	{
		log.info("click save button...");
		logExtentReport("click save button...");
		SAVE_BTN.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		return new HomePage(driver);
	}
	
	public void logExtentReport(String s1)
	{
	  TestBase.test.log(Status.INFO, s1);	
	}
}
