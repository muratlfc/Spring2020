package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import io.restassured.response.Response;

public class RestApiGetRequest01 {
	
	/*
	 Positive Scenario:
	 When I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking   
     And Accept type is “application/JSON”
     Then HTTP Status Code should be 200
     And Response format should be "application/JSON"
	*/
	
	@Test
	public void getTest01() { 
	given().
		accept("application/JSON").//ContentType.JSON also works
	when().
		get("https://restful-booker.herokuapp.com/booking").
	then().
		assertThat().
		statusCode(200).
		contentType("application/JSON");//ContentType.JSON also works
	}
	
	/*
	 Negative Scenario:
	 When I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/33   
     And Accept type is “application/JSON”
     Then HTTP Status Code should be 404
	*/
	
	@Test
	public void getTest02() { 
	given().
		accept("application/JSON").
	when().
		get("https://restful-booker.herokuapp.com/booking/33").
	then().
		assertThat().
		statusCode(404);
	}
	
	/*
	 How to see response on the console:
	 When I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1   
     And Accept type is “application/JSON”
     Then I want to see the status code, status line, response body, content type
     specific header, all headers on the console
	*/
	
	@Test
	public void getTest03() { 
	Response response = given().
		                    accept("application/JSON").
	                    when().
		                    get("https://restful-booker.herokuapp.com/booking");
	
	System.out.println("Status Code: " + response.getStatusCode());
	System.out.println("Status Line: " + response.getStatusLine());
	System.out.println("Respone Body: " + response.prettyPrint());
	System.out.println("Content Type: " + response.getContentType());
	System.out.println("Content Type: " + response.getHeader("Date"));
	System.out.println("Content Type: " + response.getHeaders());
	}
}
