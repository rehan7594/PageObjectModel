package com.facebook.pageobjectmodel.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.facebook.pageobjectmodel.util.FacebookTestUtil;

public class FacebookBase {
	public static WebDriver driver;
	public static Properties prop;
		
	public FacebookBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\SeleniumPageObjectModel\\src\\main\\java\\com\\facebook\\pageobjectmodel\\config\\facebook.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
	if(browserName.equals("Edge")){
		System.setProperty("webdriver.edge.driver","C:\\Users\\PC\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();	
	}
	else if(browserName.equals("firefox")){
		System.setProperty("webdriver.gecko.driver","Downloads\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(FacebookTestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(FacebookTestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}
}
