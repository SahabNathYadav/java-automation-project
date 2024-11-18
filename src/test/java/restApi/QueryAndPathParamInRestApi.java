package restApi;

import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

//import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class QueryAndPathParamInRestApi {
	
	@Test(priority=1)
	public void testQueryAndPathParam() {
		
		//https://reqres.in/api/users?page=2&id=5
		
		given()
			.pathParam("myPath1", "api")
			.pathParam("myPath2", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		
		.when()
			.get("https://reqres.in/{myPath1}/{myPath2}")  
			// we dont need to mentione the query params here as it will go with request. 
			//Just Path Param should be mentioned
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}

}
