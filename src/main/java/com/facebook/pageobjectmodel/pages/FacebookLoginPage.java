package com.facebook.pageobjectmodel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.pageobjectmodel.base.FacebookBase;

public class FacebookLoginPage extends FacebookBase {
	//page factory - or:
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "pass")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Create New Account']")
	WebElement CreateAccountbtn;
	
	@FindBy(xpath = "//img[@alt='Facebook']")
	WebElement fbLogo;
	
	//Initialize page objects
	public FacebookLoginPage() {
		PageFactory.initElements(driver, this);		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateFBImage() {
		return fbLogo.isDisplayed();
	}
	
	public FacebookHomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new FacebookHomePage();
	}
	
	

}
