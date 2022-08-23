package com.facebook.pageobjectmodel.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.pageobjectmodel.base.FacebookBase;
import com.facebook.pageobjectmodel.pages.FacebookHomePage;
import com.facebook.pageobjectmodel.pages.FacebookLoginPage;
import com.facebook.pageobjectmodel.pages.FacebookSingUpPage;

public class FacebookSingUpPageTest extends FacebookBase {
	FacebookLoginPage loginPage;
	FacebookSingUpPage signUpPage;
	FacebookHomePage homePage;
	public FacebookSingUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new FacebookLoginPage();
		signUpPage = new FacebookSingUpPage();
		homePage = new FacebookHomePage();
		
	}
	
//	@Test(priority=1) 
//	public void LoginPageTitle() {
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title,"Facebook – log in or sign up");
//	}
//	@Test(priority=2) 
//	public void fbLogoImageTest() {
//		boolean flag = loginPage.validateFBImage();
//		Assert.assertTrue(flag);
//	}
//	@Test(priority=3)
//	public void loginTest() {
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//	}
	@Test(priority=1)
	public void createNewAccountTest() {
		signUpPage.createNewAccount().signup(prop.getProperty("firstName"), 
				prop.getProperty("lastName"), prop.getProperty("emailAddress"),
				prop.getProperty("remailAddress"), prop.getProperty("password"), 
				prop.getProperty("day"), prop.getProperty("month"), prop.getProperty("year"),
				prop.getProperty("Gender"));
	}
	
//	@Test(priority=2)
//	public void SignUpTest() {
//		
//	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
