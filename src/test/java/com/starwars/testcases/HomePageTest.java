package com.starwars.testcases;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.starwars.pages.FilmsPage;
import com.starwars.pages.HomePage;
import com.starwars.pages.VideoPage;
import com.starwars.utils.CommonMethods;
import com.starwars.utils.Constant;
import com.starwars.utils.ExcellUtils;

public class HomePageTest extends CommonMethods {

	public HomePage h;
	public FilmsPage f;
	public ExcellUtils ex;
	
	@Test(groups="smoke")
	public void homePage() {
				
		Assert.assertEquals(Constant.TITLE, driver.getTitle());
		
	}
	

    @Test(groups = "smoke")
	public void videoPage() {

		h = new HomePage();
		VideoPage v = new VideoPage();

		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(h.video));

		jsClick(h.video);

		jsSendKey(v.searchBox, "VADER IMMORTAL-EPISODE 1");

		jsClick(v.searchButn);

		String expectedResult = "10 RESULTS FOR “VADER IMMORTAL-EPISODE 1”";

		Assert.assertEquals(expectedResult, v.result.getText());

	}

	@Test(groups = "smoke")
	public void filmsPage() {

		h = new HomePage();
		f = new FilmsPage();
		ex = new ExcellUtils();

		// getting expected data from database

		ex.openExcel(Constant.EXCELL_PATH, "films");
		int coll = ex.getColNum(1);
		int row = ex.getRowNum();

		List<String> expectedFilms = new LinkedList<String>();
		
		System.out.println("-------------------Expected List-----------------------");

		for (int i = 0; i < row; i++) {
			for (int y = 0; y < coll; y++) {

				expectedFilms.add(ex.getCellData(i, y).toString());
				
				System.out.println(i+1 +" "+ ex.getCellData(i, y).toString());

			}
		}

		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(h.films));

		jsClick(h.films);

		jsClick(f.seeAll);

		List<String> actualFilms = new LinkedList<String>();
		
		//getting actual data from film drop down menu
		
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElements(f.seeAllList));

		List<WebElement> list = f.seeAllList;
				
		
		System.out.println("-------------------Actual List-----------------------");
		
	
		for (int i = 1; i < list.size(); i++) {
						
			String film = list.get(i).getText();
			
			if (!film.isEmpty()) {
				
				actualFilms.add(list.get(i).getText());
				System.out.println(i+" "+ list.get(i).getText()+" ");
			}

		}

		Assert.assertEquals(expectedFilms,actualFilms);

	}

}
