package com.starwars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.starwars.utils.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(css="p[class='video-content-title']")
	public WebElement video;
	
	
	@FindBy(xpath="//span[text()=\"Films\"]")
	public WebElement films;
	
	@FindBy(xpath="//span[text()=\"Series\"]")
	public WebElement series;
	
}
