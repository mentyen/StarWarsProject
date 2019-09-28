package com.starwars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.starwars.utils.BaseClass;

public class SignInPage extends BaseClass{
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="input[name='firstName']")
	public WebElement firstName;
	
	@FindBy(css="input[name='lastName']")
	public WebElement lastName;
	
	@FindBy(css="input[name='displayName']")
	public WebElement displayName;
	
	@FindBy(css="input[name='email']")
	public WebElement email;
	
	@FindBy(css="input[name='newPassword']")
	public WebElement password;
	
	
	//@FindBy(xpath="/html/body/div[6]/iframe")
	//public WebElement mainFrame;
	
	//@FindBy(css="iframe[id=\"disneyid-iframe\"]")
	//public WebElement loginFrame;

}
