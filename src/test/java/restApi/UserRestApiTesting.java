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

public class UserRestApiTesting {
	
	int id;

	@Test(priority=1)
	public void testGetAllUser(){
		
		RestAssured.given()
		.when()
		 .get("Https://reqres.in/api/users?page=2")
		.then()
		 .statusCode(200)
		 //.body("page", Matchers.equalTo(2)) //equalTo comes from hamcrest.Matchers
		 .body("page", equalTo(2))
		 .log().all();
		 
	}
	
	@Test(priority=2)
	public void testCreatUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "SNY");
		data.put("job", "Developer");
		
		id = given()
			.contentType("application/json")
			.body(data)
		
		.when()
		 	.post("Https://reqres.in/api/users")
		 	.jsonPath().getInt("id");
		System.out.println("Data created and Id is : "+id);
		 	
//		.then()
//			.statusCode(201)
//			.log().all();
		
		// if we have to get some data and store it in some variable to use it in next test, 
		   //comment the then section and store the response in the variable as we have done above.
		
		
	}
	
	@Test(priority=3, dependsOnMethods= {"testCreatUser"})
	public void testUpdateUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Sahab");
		data.put("job", "Developer");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("Https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority=4, dependsOnMethods= {"testUpdateUser"})
	public void testDeleteUser() {
		
		given()
		
		.when()
			.delete("Https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
}
