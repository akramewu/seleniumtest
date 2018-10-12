package com.sap.mdmorchestration.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sap.mdmorchestration.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver; 
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver = driver;
		log.info("JavascriptHelper has been initialised");
	}
	
	public Object executeScript(String script)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public Object executeScript(String script, Object...args)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	public void scrollToElement(WebElement element)
	{
		log.info("scroll to WebElement...");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToElement(element);
		element.click();
		log.info("element is clicked: "+element.toString());
	}
	
	public void scrollIntoView(WebElement element)
	{
		log.info("scroll till web element");
		executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void scrollIntoViewAndClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
        log.info("element is clicked: "+element.toString());
	}
	
	public void scrollDownVertically()
	{
		log.info("scrolling down vertically... ");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollUpVertically()
	{
		log.info("scrolling up vertically... ");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	
		

}
