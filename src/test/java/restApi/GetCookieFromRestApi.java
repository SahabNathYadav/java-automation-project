package restApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Map;
import io.restassured.response.Response;

public class GetCookieFromRestApi {
	
	@Test
	public void getCookie() {
		
		Response response =	given()
		
							.when()
								.get("https://www.google.com/");
		String cookie = response.getCookie("AEC");
		
		System.out.println("Cookie value is:"+cookie);
		
		Map<String,String> cookies = response.getCookies();
		
		//Using Java 8 stream 
		cookies.forEach((key,value)->System.out.println("Using Java 8 Stream Key: "+key+", Value: "+value));
		
		//Using Advanced for each loop
		for(Map.Entry<String, String> entry :  cookies.entrySet()) {
			System.out.println("Using for each loop key:"+entry.getKey()+", Value is:"+entry.getValue());
		}
	}

}
