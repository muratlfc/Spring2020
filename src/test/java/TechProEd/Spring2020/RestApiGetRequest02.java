package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import org.junit.Test;
import io.restassured.response.Response;

public class RestApiGetRequest02 {
	
	/*
	 When I send a GET request to REST API URL http://dummy.restapiexample.com/api/v1/employees/33   
     And Accept type is “application/JSON”
     Then HTTP Status Code should be 404
     And response body contains "Not Found"
     And response body does not contain "TechProEd"
	*/

	@Test
	public void getTest01() { 
		
	Response response = given().
					       accept("application/JSON").
				        when().
					       get("http://dummy.restapiexample.com/api/v1/employees/33");
	
	response.prettyPrint();
	
	assertEquals(response.statusCode(), 404);
	assertTrue(response.asString().contains("Not Found"));
	assertFalse(response.asString().contains("TechProEd"));
	
	}

}
