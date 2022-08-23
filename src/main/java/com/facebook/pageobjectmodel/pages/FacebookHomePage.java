package com.facebook.pageobjectmodel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.pageobjectmodel.base.FacebookBase;

public class FacebookHomePage extends FacebookBase {
	@FindBy(xpath = "//span[contains(text(),'Rehan Kumar Chandravanshi')]")
	WebElement profilePage;

	// Initializing the Page Objects:
	public FacebookHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public FacebookProfilePage clickOnprofilePage(){
	profilePage.click();
	return new FacebookProfilePage();
	}

}
