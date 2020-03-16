package APITest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test1_GET_request {

	@Test
	public void getWeatherInfo() {

		String URL = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";

		given()

		.when()
				
			.get(URL)

		.then()
				
			.statusCode(200)
			.assertThat().body("City", equalTo("Hyderabad"))
			.header("Content-Type", "application/json").log().all();

	}

}
