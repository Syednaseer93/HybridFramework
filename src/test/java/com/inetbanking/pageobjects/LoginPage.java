package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(name = "uid")	WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(name = "btnReset") WebElement resetBtn;
	@FindBy(name = "btnLogin") WebElement loginBtn;
	@FindBy(linkText = "Log out") WebElement logoutBtn;
	
	public void setUsername(String uname) {
		username.clear();
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
		
	public void clickLogin() {
		loginBtn.click();
	}
	public void clickLogout() {
		logoutBtn.click();
	}

}