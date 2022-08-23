package com.facebook.pageobjectmodel.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.pageobjectmodel.base.FacebookBase;
import com.facebook.pageobjectmodel.pages.FacebookHomePage;
import com.facebook.pageobjectmodel.pages.FacebookLoginPage;
import com.facebook.pageobjectmodel.pages.FacebookProfilePage;

public class FacebookProfilePageTest extends FacebookBase {
	FacebookLoginPage loginPage;
	FacebookHomePage homePage;
	FacebookProfilePage profilePage;
	public FacebookProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new FacebookLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage = new FacebookProfilePage();
	}
	
	@Test(priority=1)
	public void verifyProfilePageTest() {
		profilePage = homePage.clickOnprofilePage();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
