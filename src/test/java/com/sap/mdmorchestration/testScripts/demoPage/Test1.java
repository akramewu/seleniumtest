package com.sap.mdmorchestration.testScripts.demoPage;

import org.testng.annotations.Test;

import com.sap.mdmorchestration.helper.assertion.AssertionHelper;
import com.sap.mdmorchestration.testBase.TestBase;

public class Test1 extends TestBase{

	@Test
	public void testLogin()
	{
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void testLogin1()
	{
		AssertionHelper.makeFalse();
	}
}
