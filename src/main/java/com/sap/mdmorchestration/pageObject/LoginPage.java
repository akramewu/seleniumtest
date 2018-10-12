package com.sap.mdmorchestration.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.sap.mdmorchestration.helper.assertion.VerficationHelper;
import com.sap.mdmorchestration.helper.browserConfiguration.config.ObjectReader;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.helper.wait.WaitHelper;
import com.sap.mdmorchestration.testBase.TestBase;
public class LoginPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	
	@FindBy(css = "[name='username']")
	public WebElement EMAIL;
	@FindBy(css = "[name='password']")
	public WebElement PASSWORD;
	@FindBy(css = "input.island-button")
	public WebElement LOGON_BTN;
	@FindBy (css = "span#__tile2-title-inner.sapMTextMaxLine")
	public WebElement TEXT;
	
	
	public LoginPage(final WebDriver driver) {
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(LOGON_BTN,ObjectReader.reader.getExpliciteWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Login Page Object Created ");
	}
	
	public void enterEmailAdress(String emailAddress)
	{
		log.info("entering email address..."+emailAddress);
		logExtentReport("entering email address..." + emailAddress);
		waitHelper.waitForElement(EMAIL, ObjectReader.reader.getImpliciteWait());
		EMAIL.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password)
	{
		log.info("entering password ...");
		logExtentReport("entering password ...");
		waitHelper.waitForElement(PASSWORD, ObjectReader.reader.getImpliciteWait());
		PASSWORD.sendKeys(password);
	}
	
	public HomePage clickOnLoginButton() throws Exception
	{
		log.info("clicking on login button...");
		logExtentReport("clicking on login button...");
		LOGON_BTN.click();
		waitHelper.setSleepWait(ObjectReader.reader.getSleepWait());
		return new HomePage(driver);
	}
	
	public boolean verifySuccessLoginMsg()
	{
		return new VerficationHelper(driver).isDisplayed(TEXT);
		
	}
	
	public void logExtentReport(String s1)
	{
	  TestBase.test.log(Status.INFO, s1);	
	}
}
