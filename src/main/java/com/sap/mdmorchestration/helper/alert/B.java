package com.sap.mdmorchestration.helper.alert;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sap.mdmorchestration.testBase.TestBase;

public class B extends TestBase{

	int i = 1;
	
	@Test
	public void testLoginB()
	{
		if(i == 3) 
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println(i);
			i++;
			Assert.assertTrue(false);
		}
		
	}
}
