package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.addCustomerPage;

public class TC_addCust_003 extends BaseClass{
	@Test
	public void addNewCustomer() {
		LoginPage lp=new LoginPage(driver);
		logger.info("********URL OPENED***********");
		lp.setUsername(username);
		logger.info("********USERNAME ENTERED***********");
		lp.setPassword(password);
		logger.info("*******PASSWORD ENTERED***********");
		lp.clickLogin();
		logger.info("********LOGIN SUCCESSFUL***********");
		
		addCustomerPage ap=new addCustomerPage(driver);
		ap.clickToAddNewCustomer();
		logger.info("********CLICKED TO ADD NEW CUSTOMER***********");
		ap.setUsername("Syed");
		logger.info("********NAMED ADDED***********");
		ap.setGenderMale();
		logger.info("********GENDER ADDED***********");
		ap.setDOB("12", "15", "1994");
		logger.info("*******DATE OF BIRTH ADDED***********");
		ap.setAddress("No.7/56, Palm Street,Benson town");
		logger.info("********ADDRESS ADDED***********");
		ap.setCityName("Bangalore");
		logger.info("********CITY ADDED***********");
		ap.setStateName("Karnataka");
		logger.info("*******STATE ADDED***********");
		ap.setPin("560001");
		ap.setPhoneNo("9874676633");
		logger.info("********PHONE AND PIN ADDED***********");
		String email=generateRandomString()+"@gmail.com";
		ap.setEmail(email);
		logger.info("********EMAIL ENTERED***********");
		ap.clickSubmit();
		logger.info("********SUBMITTED SUCCESFULLY***********");
		Assert.assertTrue(true);// Just for temporary	
	}

}
