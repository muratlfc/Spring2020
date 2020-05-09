package TechProEd.Spring2020;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest02 {

	/*
	 Positive Scenario:
	 When I send a GET request to REST API URL 
	 https://restful-booker.herokuapp.com/booking   
     And Accept type is “application/JSON”
     Then HTTP Status Code should be 200
     And Response format should be "application/JSON"
	*/
	@Test
	public void getTest01() {
		
		given().
		     accept("application/JSON").//ContentType.JSON is also can be used instead of application/JSON
		when().
		     get("https://restful-booker.herokuapp.com/booking").
		then().
		     assertThat().
		     statusCode(200).
		     contentType("application/JSON");//ContentType.JSON is also can be used instead of application/JSON
	}
	
	/*
	 Negative Scenario:
	 When I send a GET request to REST API URL 
	 https://restful-booker.herokuapp.com/booking/33   
     Then HTTP Status Code should be 404
	*/
	@Test
	public void getTest02() {
		
		given().
		when().
		     get("https://restful-booker.herokuapp.com/booking/33").
        then().
             assertThat().
             statusCode(404);
	}
	
	/*
	 How to see response on the console:
	 When I send a GET request to REST API URL 
	 https://restful-booker.herokuapp.com/booking/1   
     And Accept type is “application/JSON”
     Then I want to see the status code, status line, response body, content type
     specific header, all headers on the console
	 */
	
	 @Test
	 public void getTest03() {
		  
		 Response response = given().
                             when().
                                 get("https://restful-booker.herokuapp.com/booking/1");
		 
		 System.out.println(response.getStatusCode());// ==> I should see status code on the console
		 System.out.println(response.getStatusLine());
		 response.prettyPrint();//to see response body on the console use prettyPrint()
		                        // When you use prettyPrint() do not use System.out.println()
		 System.out.println(response.getContentType()); // 1st way to see content type on the console
		 System.out.println(response.getHeader("Content-Type"));//2nd way to see content type on the console
		 System.out.println(response.getHeaders());//It returns all keys and values in response header
		 System.out.println(response.getHeader("Date"));//Returns a specific value in headers  
	 }

}
