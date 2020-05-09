package TechProEd.Spring2020;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest01 {

	@Test
	public void getMethod01() {
		given().
		when().
		   get("https://restful-booker.herokuapp.com").
		then().
		   assertThat().
		   statusCode(200);
	}
}
