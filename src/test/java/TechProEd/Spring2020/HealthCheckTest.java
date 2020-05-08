package TechProEd.Spring2020;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class HealthCheckTest {
	
	@Test
	public void healthCheckTest() { 
	given().
	when().
		get("https://restful-booker.herokuapp.com/ping").
	then().
		assertThat().
		statusCode(201); //First run the code with 200 then show the error and check the document
	}

}
