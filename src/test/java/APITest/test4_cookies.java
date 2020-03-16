package APITest;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class test4_cookies {
	
	
	@Test
	public void testCookies() {
		
		String URL = "https://jsonplaceholder.typicode.com/photos";
		
		Response resp = 
		
		given()		
		.when()
		.get(URL);
		
		// Get value of single cookie 
		String cookie_value = resp.getCookie("__cfduid"); 
		System.out.println("Cookie value: " + cookie_value);
		
		
		// Get values of all cookies
		Map<String, String> cookie_values = resp.getCookies();
		
		// Get detailed info of cookie		
		Cookie cookie_info = resp.getDetailedCookie("__cfduid");
		System.out.println("Cookie expires: " + cookie_info.hasExpiryDate());
		System.out.println("Cookie expiry: " + cookie_info.getExpiryDate());		
					
	}

}
