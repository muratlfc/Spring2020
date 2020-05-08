package TechProEd.Spring2020;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApiGetRequest03 {

		// When you work on API testing, it takes less time.
		// For example smoke test takes about 1 minute
		// Regression test takes about 20 minutes
		
		/*
		 Positive Scenario:
		 When I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1   
	     And Accept type is “application/JSON”
	     Then HTTP Status Code should be 200
	     And Response format should be "application/JSON"
	     And first name should be "Mary"
	     And lastname should be "Smith"
	     And checkin date should be "2019-08-30"
	     And checkout date should be "2020-04-10"
		*/
		
		@Test
		public void getTest01() { 
		Response response = given(). //do not use accept("application/JSON"). it is giving error because of API 
		                    when().
			                   get("https://restful-booker.herokuapp.com/booking/1");
		
		response.prettyPrint();
		
		response.
		    then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON).// "application/JSON" also works
			body("firstname",Matchers.equalTo("Mary")).//Matchers comes from Hemcrest library
		    body("lastname", Matchers.equalTo("Smith")).
		    body("bookingdates.checkin", Matchers.equalTo("2019-08-30")).
		    body("bookingdates.checkout", Matchers.equalTo("2020-04-10"));
		
		
		}
}
