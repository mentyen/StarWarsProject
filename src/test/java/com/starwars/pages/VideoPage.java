package com.starwars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.starwars.utils.BaseClass;

public class VideoPage extends BaseClass {

	public VideoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder=\"Search Videos\"]")
	public WebElement searchBox;

	@FindBy(xpath = "//*[text()=\"THE STAR WARS SHOW //\"]")
	public WebElement theStarWarTitle;
	
	@FindBy(css="input[class=\"large button\"]")
	public WebElement searchButn;
	
	
	@FindBy(css="h2[class=\"in-section\"]")
	public WebElement result;
	
	
}



