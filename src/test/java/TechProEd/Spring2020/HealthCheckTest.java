package TechProEd.Spring2020;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class HealthCheckTest {
	
	@Test
	public void getMethod01() { 
	given().
	when().
		get("https://restful-booker.herokuapp.com").
	then().
		assertThat().
		statusCode(200); //First run the code with 200 then show the error and check the document
	}

}
