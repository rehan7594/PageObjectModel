package com.facebook.pageobjectmodel.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.pageobjectmodel.base.FacebookBase;
import com.facebook.pageobjectmodel.pages.FacebookHomePage;
import com.facebook.pageobjectmodel.pages.FacebookLoginPage;
import com.facebook.pageobjectmodel.util.FacebookTestUtil;

public class FacebookLoginPageTest extends FacebookBase {
	FacebookLoginPage loginPage;
	FacebookHomePage homePage;
	FacebookTestUtil testUtil;
	
	String sheetName = "Sheet1";
	Logger log = Logger.getLogger(FacebookLoginPageTest.class);
	
	public FacebookLoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("Starting test case exeuction");
		initialization();
		homePage = new FacebookHomePage();
		testUtil = new FacebookTestUtil();
		loginPage = new FacebookLoginPage();		
	}
	
	@Test(priority=1) 
	public void LoginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Facebook – log in or sign up");
	}
	@Test(priority=2) 
	public void fbLogoImageTest() {
		boolean flag = loginPage.validateFBImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = FacebookTestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void loginTest(String userName, String passWord) throws InterruptedException {
	homePage = loginPage.login(userName, passWord);
		Thread.sleep(2000);
	log.info("Login successful with username: " +userName);
	}
	
//	@AfterMethod
//	public void tearDown() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.quit();
//		log.info("Browser is closed");
//	}

}
