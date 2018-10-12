package com.sap.mdmorchestration.helper.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.helper.window.WindowHelper;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private int maxRetryCount = 3;
	private Logger log = LoggerHelper.getLogger(Retry.class);
	
	
	public boolean retry(ITestResult arg0) 
	{
		if (retryCount < maxRetryCount ) 
		{
			log.info("Retrying test "+ arg0.getName()+"with status "+"PASS"+" for the " +(retryCount+1)+ " times." );
			retryCount++;
			return true;
			
		} 
		return false;
	}
   
	public String getResultStatusName(int status)
	{
		String resultName = null;
		if(status ==1)
		{
			resultName = "SUCESS";
		}
		if(status ==2)
		{
			resultName = "FAILURE";
		}
		if(status ==3)
		{
			resultName = "SKIP";
		}
		
		return null;
		
	}
}
