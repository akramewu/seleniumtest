package com.sap.mdmorchestration.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.testBase.TestBase;

public class VerficationHelper {
	
	private WebDriver driver; 
	private Logger log = LoggerHelper.getLogger(VerficationHelper.class);
	
	public VerficationHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * 
	 * @param element is displayed
	 * @return
	 */
	public boolean isDisplayed(WebElement element)
	{
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element.getText());
			TestBase.logExtentReport("element is displayed.."+element.getText());
			return true;
		}
		catch (Exception e) {
			log.error("element is not displayed..",e.getCause());
			TestBase.logExtentReport("element is not displayed.."+e.getMessage());
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param element is not displayed
	 * @return
	 */
	public boolean isNotDisplayed(WebElement element)
	{
		try {
			element.isDisplayed();
			log.info("element is present.."+element.getText());
			TestBase.logExtentReport("element is present.."+element.getText());
			return false;
		}
		catch (Exception e) {
			log.error("element is not present..",e.getCause());
			TestBase.logExtentReport("element is not present.."+e.getMessage());
		}
		return true;
		
	}
	
	public String readValueFromElement(WebElement element)
	{
		if(null == element)
		{
			log.info("WebElement is null..");
			return null;
		}
		
		boolean status = isDisplayed(element);
		if (status) {
			log.info("element text is .."+element.getText());
			return element.getText();
		}
		else {
			return null;
		}
	}
	
	public String getText(WebElement element)
	{
		if(null == element)
		{
			log.info("WebElement is null..");
			return null;
		}
		
		boolean status = isDisplayed(element);
		if (status) {
			log.info("element text is .."+element.getText());
			return element.getText();
		}
		else {
			return null;
		}
	}
	
}
