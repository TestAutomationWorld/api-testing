package APITest;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test2_POST_request {
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void postData() {
			
		String name = "Mos"+RandomStringUtils.randomAlphabetic(3);
		map.put("FirstName", RandomStringUtils.randomAlphabetic(8));
		map.put("LastName", RandomStringUtils.randomAlphabetic(8));
		map.put("UserName", RandomStringUtils.randomAlphabetic(4));
		map.put("Password", "1234");
		map.put("Email", RandomStringUtils.randomAlphabetic(8) + "@" + RandomStringUtils.randomAlphabetic(4) + ".com" );			
		

	}
	
	@Test
	public void postTest() {
		
		String URL = "http://restapi.demoqa.com/customer/register";
		
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.post(URL)
		
		.then()
			.statusCode(201)
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"))
			.log().all();
		
	}

}
