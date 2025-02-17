package com.sdetadda.allure;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetPostAllure {
  @Test
  public void testcaseget() {
	  baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",equalTo("George")).
			body("data.first_name",hasItems("George","Rachel"));
		
		
  }
  @Test
  public void testcasepost() {
	  Map<String, Object>map = new HashMap<String,Object>();
		
		JSONObject request = new JSONObject(map);
		request.put("name", "vansh");
		request.put("job", "employee");
		
		System.out.print(request.toJSONString());
		baseURI="https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/user").
		then().
		statusCode(201).log().all();
  }
}
