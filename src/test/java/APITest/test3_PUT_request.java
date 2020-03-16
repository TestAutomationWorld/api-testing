package APITest;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class test3_PUT_request {
	
	@Test
	public void putTest() {
				
		HashMap map = new HashMap();
		
		map.put("name","morpheus");
		map.put("job","zion resident");
		
		String URL = "https://reqres.in/api/users/2";
		
		given()
		
			.contentType("application/json")
			.body(map)
		
		.when()
		.put(URL)
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
}
