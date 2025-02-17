package test1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPost {
//@Test
	public void testget() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("x[4].first_name",equalTo("Faustina")).
		body("data.first_name",hasItems("Faustina","Jamima"));
	}
@Test
public void testPost() {
	Map<String, Object>map = new HashMap<String,Object>();
	
//	map.put("name","vansh");
//	map.put("job","employee");
//	
//	System.out.println(map);
	
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
