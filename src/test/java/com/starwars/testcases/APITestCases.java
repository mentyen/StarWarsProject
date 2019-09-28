package com.starwars.testcases;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.starwars.utils.Constant;
import com.starwars.utils.ExcellUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITestCases {
	
	//1. Create and implement(code) functional test cases for the following endpoints:
	//GET all  http://swapi.co/api/planets
	int total;
	ExcellUtils obj;

	
	
	@Test(groups="api")
	public void TC01_1() {
		//assert status code, total count of planets, and response time
		RestAssured.baseURI="http://swapi.co/api/planets";
		Response res=given().when().get();
		JsonPath jp=res.jsonPath();
	    total=jp.get("count");
		
		res.then().
		statusCode(200).
		and().assertThat().body("count",equalTo(total))
		.and().assertThat().time(lessThan(2000L), TimeUnit.MILLISECONDS)	;

			
	}
	
	@Test(groups="api")
	public void TC01_2() {
		//header assert that ContentType is application/json
		
		RestAssured.baseURI="http://swapi.co/api/planets";
		Response res=given().when().get();
		
		res.then().assertThat().header("Content-Type", "application/json");
		
			
	}
	
	@Test(groups="api")
	public void TC01_3() {
		
		//Verify that a first 7 planets are matching expected result 
		
		obj=new ExcellUtils();
		obj.openExcel(Constant.EXCELL_PATH, "dataTable");
		
			
		int row=obj.getRowNum();
		int cell=obj.getColNum(1);
		
		List<Map<String, String>>namesFromData=new ArrayList<Map<String,String>>();
		
		for(int i=0;i<row;i++) {
			for(int y=0;y<cell;y++) {
				Map<String,String>map=new HashMap<String,String>();
				map.put(obj.getCellData(i, y),obj.getCellData(i, y+1));
				namesFromData.add(map);
				break;
			}
		}
		
		
		
		
		RestAssured.baseURI="http://swapi.co/api/planets";
		RestAssured.basePath="/{url}";
		
		List<Map<String, String>>names=new ArrayList<Map<String,String>>();
		
		for(int i=1;i<=7;i++) {
			
		Response res=given().pathParam("url", i).get();
		
		JsonPath jp=res.jsonPath();
		String name=jp.getString("name");
	
		
		Map<String,String>map=new HashMap<String,String>();
		map.put("name",name);
		names.add(map);		
		}
		
		Assert.assertEquals(names, namesFromData);
		
	}
	
	

}
