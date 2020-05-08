package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApiGetRequest04 {

	/*
	 Positive Scenario:
	 When I send a GET request to REST API URL http://dummy.restapiexample.com/api/v1/employees   
     And Accept type is “application/JSON”
     Then HTTP Status Code should be 200
     And Response format should be "application/JSON"
     And there should be 24 employees
     And "Ashton Cox" should be one of the employees
     ANd 21, 61, and 23 should be among the employee ages
	*/
	
	@Test
	public void getTest01() { 
	Response response = given().
			               accept(ContentType.JSON). 
	                    when().
		                   get("http://dummy.restapiexample.com/api/v1/employees");
	
	response.prettyPrint();
	
	response.
	    then().
		     assertThat().
		     statusCode(200).
		     contentType(ContentType.JSON).
		     body("data.id",Matchers.hasSize(24)).//"data" is a list and its size is 24
		     body("data.employee_name",Matchers.hasItem("Ashton Cox")). //"Ashton Cox"
	         // is one of the employee name in the list
		     body("data.employee_age",Matchers.hasItems("21","61","23"));//"21","61","23"
             // are the employee ages in the list
	
	}
}
