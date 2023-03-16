package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		}
	@FindBy(linkText = "Edit Customer") WebElement editLink;
	
	@FindBy(name = "cusid") WebElement customerId;
	
	@FindBy(name = "AccSubmit") WebElement idSubmit;
	
	
	
	
}
