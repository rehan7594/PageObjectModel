package com.facebook.pageobjectmodel.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.pageobjectmodel.base.FacebookBase;
import com.facebook.pageobjectmodel.pages.FacebookHomePage;
import com.facebook.pageobjectmodel.pages.FacebookLoginPage;

public class FacebookHomePageTest extends FacebookBase{
	FacebookLoginPage loginPage;
	FacebookHomePage homePage;
	public FacebookHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new FacebookLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
