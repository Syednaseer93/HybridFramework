package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public static WebDriver driver;
	public String baseURL= readconfig.getApplicationURL();
	public String username= readconfig.getusername();
	public String password= readconfig.getPassword();
	
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass	
	public void setup(String br){
		logger=Logger.getLogger("inetbanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(baseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		driver.get(baseURL);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String generateRandomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trgt=new File(System.getProperty("user.dir")+"/Scr	eenshots/"+ tname+".png");
		FileUtils.copyFile(src, trgt);
		System.out.println("Screenshot captured");
	}
	
}
