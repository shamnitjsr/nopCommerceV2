package com.nopcommerce.testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	
	
	
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("URL is opened.................");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided............");
		lp.setPassword(password);
		logger.info("Password provided............");
		lp.clickLogin();
		logger.info("Login is clicked............");
		Thread.sleep(5000);
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login Passed............");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login Failed ............");
		}
	}
	

}
