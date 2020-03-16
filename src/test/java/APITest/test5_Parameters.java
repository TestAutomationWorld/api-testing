package APITest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class test5_Parameters {

	
	public void testQueryParam() {
		
		// http://jsonplaceholder.typicode.com/comments?postId=1					
		
		given()
			.queryParam("postId", 1)
		
		.when()
			.get("http://jsonplaceholder.typicode.com/comments")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	@Test
	public void testPathParam() {
		
		// http://restapi.demoqa.com/utilities/weather/city/Bucharest
		
		given()
			.pathParam("oras", "Bucharest")
		
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/{oras}")	
		.then()
			.statusCode(200);
		//	.log().ifValidationFails()
		//	.log().body() ;
		//	.log().headers()
			
			
	}

}
