package com.inetbanking.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addCustomerPage {

	WebDriver ldriver;
	public addCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		}
	@FindBy(linkText = "New Customer") WebElement addCustomerLink;
	
	@FindBy(name = "name") WebElement username;
	
	@FindBy(xpath = "(//input[@name='rad1'])[1]") WebElement maleRadiobtn;
	
	@FindBy(xpath = "(//input[@name='rad1'])[2]") WebElement femaleRadiobtn;
	
	@FindBy(id = "dob") WebElement dob;
	
	@FindBy(name = "addr") WebElement address;
	
	@FindBy(name = "city") WebElement city;
	
	@FindBy(name = "state") WebElement state;
	
	@FindBy(name = "pinno") WebElement pin;
	
	@FindBy(name = "telephoneno") WebElement phone;
	
	@FindBy(name = "emailid") WebElement email;
	
	@FindBy(name = "sub") WebElement submit;
	
	public void clickToAddNewCustomer()
	{
		addCustomerLink.click();
	}
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}
	public void setGenderMale() {
		maleRadiobtn.click();
	}
	public void setGenderFemale() {
		femaleRadiobtn.click();
	}
	public void setDOB(String month,String day,String year) {
		dob.sendKeys(month);
		dob.sendKeys(day);
		dob.sendKeys(year);
	}
	public void setAddress(String addr) {
		address.sendKeys(addr);
	}
	public void setCityName(String cityname) {
		city.sendKeys(cityname);
	}
	public void setStateName(String statename) {
		state.sendKeys(statename);
	}
	public void setPin(String pinno) {
		pin.sendKeys(pinno);
	}
	public void setPhoneNo(String phoneno) {
		phone.sendKeys(phoneno);
	}
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void clickSubmit() {
		submit.click();
	}
	
	public String generateRandomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	
	
	
}
