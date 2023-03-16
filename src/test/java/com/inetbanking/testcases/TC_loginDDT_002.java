package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtility;

import junit.framework.Assert;

public class TC_loginDDT_002 extends BaseClass{
	@Test(dataProvider="sendData")
	public void loginDDT(String user, String pwd) {
		LoginPage lp=new LoginPage(driver);
		logger.info("********URL OPENED***********");
		lp.setUsername(user);
		logger.info("********USERNAME ADDED***********");
		lp.setPassword(pwd);
		logger.info("********PASSWORD ENTERED***********");
		lp.clickLogin();
		if(isAlertPresent()==true) {
			logger.info("********ALERT PRESENT WRONT CREDENTIALS***********");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("********Login Failed***********");
		}
		else {
			Assert.assertTrue(true);
			logger.info("********LOGIN SUCCESSFUL***********");
			lp.clickLogout();			
			driver.switchTo().alert().accept();//close 
			driver.switchTo().defaultContent();	
		}
	}
	@DataProvider(name="sendData")
	public String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+"/Datafiles/inetbanking.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int rows=xlutil.getRowCount("Sheet1");
		int cols=xlutil.getCellCount("Sheet1", 2);
		String[][] data=new String[rows][cols];

		for(int r=1;r<=rows;r++) {
			for(int c=0;c<cols;c++) {
				data[r-1][c]=xlutil.getCellData("Sheet1", r, c);
			}
		}
		return data;
	}

	public boolean isAlertPresent() //returns if alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}

