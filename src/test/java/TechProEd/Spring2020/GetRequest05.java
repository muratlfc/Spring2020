package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest05 {

	/*
	 Positive Scenario:
	 When I send a GET request to REST API URL 
	 http://dummy.restapiexample.com/api/v1/employees   
     And Accept type is “application/JSON”
     Then 
     HTTP Status Code should be 200
     And Response format should be "application/JSON"
     And there should be 24 employees
     And "Ashton Cox" should be one of the employees
     And 21, 61, and 23 should be among the employee ages
	 */
	@Test
	public void getMethod01() {
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
              body("data.id",hasSize(24)).//hasSize() is like size()
              body("data.employee_name",hasItem("Ashton Cox")).//hasItem() is like contains()
              body("data.employee_age",hasItems("21","61","23"));
		
		response.
		    then().
		    assertThat().
		    statusCode(200).
	        contentType(ContentType.JSON).
	        body("data.id",hasSize(24),//hasSize() is like size()
	             "data.employee_name",hasItem("Ashton Cox"),//hasItem() is like contains()
	             "data.employee_age",hasItems("21","61","23"));
	}
}
