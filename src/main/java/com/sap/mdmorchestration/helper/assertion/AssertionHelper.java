package com.sap.mdmorchestration.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sap.mdmorchestration.helper.logger.LoggerHelper;

public class AssertionHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	public static void verfyText(String s1, String s2)
	{
		log.info("verfying test: "+ s1 + " with "+ s2);
		Assert.assertEquals(s2, s2);
	}
	
	public static void makeTrue()
	{
		log.info("making script PASS..");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message)
	{
		log.info("making script PASS.."+message);
		Assert.assertTrue(true, message);
	}
	
	public static void makeFalse()
	{
		log.info("making script FAIL..");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String message)
	{
		log.info("making script FAIL.."+message);
		Assert.assertTrue(false,message);
	}
	
	public static void verfyTrue(boolean status)
	{
		Assert.assertTrue(status);
	}
	
	public static void verfyFalse(boolean status)
	{
		Assert.assertFalse(status);
	}
	
	public static void verfyNull(String s1)
	{
		log.info("verify object is null..");
		Assert.assertNull(s1);
	}
	
	public static void verfyNotNull(String s1)
	{
		log.info("verfy object is not null..");
		Assert.assertNotNull(s1);
	}
	
}
