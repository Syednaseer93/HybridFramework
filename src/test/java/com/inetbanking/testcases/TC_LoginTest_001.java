package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		LoginPage lp=new LoginPage(driver);
		logger.info("******URL opened*********");
		lp.setUsername(username);
		logger.info("*********Username entered******");
		lp.setPassword(password);
		logger.info("********password entered************");
		lp.clickLogin();
		logger.info("*********login successful********");
		String exp_title="GTPL Bank Manager HomePage";
		if(driver.getTitle().equals(exp_title))
		{
			Assert.assertTrue(true);
			logger.info("************Test passed**************");
		}
		else {
			captureScreen(driver, "loginTest");  
			Assert.assertTrue(false);
			logger.info("***********Test failed***************");
		}
		
	}

}
