package com.starwars.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.starwars.pages.HomePage;

public class BaseClass {
	
	public static WebDriver driver; 
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		
		String url=ConfigsReader.getProperty("url");
		String browser=ConfigsReader.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_PATH);
			driver=new ChromeDriver();
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(url);	
			
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", Constant.FIREFOX_PATH);
			driver=new FirefoxDriver();
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(url);
		}
		
	
		
		
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
		
	}
	

}
