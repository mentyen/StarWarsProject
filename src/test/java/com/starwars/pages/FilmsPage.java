package com.starwars.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.starwars.utils.BaseClass;

public class FilmsPage extends BaseClass {

	public FilmsPage() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "*[class=\"category-container\"]")
	public WebElement seeAll;

	@FindBy(xpath = "//*[@class=\"drop-container\"]/li")
	public List<WebElement> seeAllList;
	
	@FindBy(css="input[class=\"large button\"]")
	public WebElement searchButn;
	
	
	@FindBy(css="h2[class=\"in-section\"]")
	public WebElement result;
	
	
	
	
	
	
	
	
	
}
