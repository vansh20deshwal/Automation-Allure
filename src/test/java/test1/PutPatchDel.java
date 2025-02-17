//package test1;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.json.simple.JSONObject;
//import org.testng.annotations.Test;
//
//import io.restassured.http.ContentType;
//
//public class PutPatchDel {
//	@Test
//	public void testPost() {
//		
//		JSONObject request = new JSONObject();
//		
//		request.put("name", "vansh");
//		request.put("job", "employee");
//		
//		System.out.print(request.toJSONString());
//		
//		baseURI="https://reqres.in/api";
//		
//		given().
//		header("Content-Type","application/json").
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
//		body(request.toJSONString()).
//		when().
//		put("/user/2").
//		then().
//		statusCode(200)
//		.log().all();
//		
//	}
//	}
package test1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutPatchDel{
	@Test
	public void testput(){
		JSONObject request = new JSONObject();
		
		request.put( "first_name","Vansh");
		request.put("last_name", "Deshwal");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/user/2").
		then().
		statusCode(200)
		.log().all();
	}
}