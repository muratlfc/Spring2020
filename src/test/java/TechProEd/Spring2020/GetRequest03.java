package TechProEd.Spring2020;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest03 {

	/*
	 When I send a GET request to REST API URL 
	 http://dummy.restapiexample.com/api/v1/employees/33   
     Then HTTP Status Code should be 404
     And response body contains "Not Found"
     And response body does not contain "TechProEd" 
	*/
	
	//1st Way
	@Test
	public void getMethod01() {
		
		Response response = given().
		                    when().
		                        get("https://restful-booker.herokuapp.com/booking/5");
		
		response.prettyPrint();
		
		assertEquals(200, response.statusCode());
		assertTrue(response.asString().contains("888"));
		assertFalse(response.asString().contains("Not Found"));	
	}
	
	
	
	
}
