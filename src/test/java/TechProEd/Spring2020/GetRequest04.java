package TechProEd.Spring2020;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest04 {

   /*
     Positive Scenario:
	 When I send a GET request to REST API URL 
	 https://restful-booker.herokuapp.com/booking/1   
     And Accept type is “application/JSON”
     Then 
     HTTP Status Code should be 200
     And Response format should be "application/JSON"
     And first name should be "Susan"
     And lastname should be "Brown"
     And checkin date should be "2015-02-16"
     And checkout date should be "2017-06-20"
   */
	@Test
	public void getMethod01() {
		Response response = given().
		                        //accept(ContentType.JSON).//"application/JSON" is also possible
		                    when().
		                        get("https://restful-booker.herokuapp.com/booking/3");
		
		response.prettyPrint();
		//You can use body() for every assertion
		response.
		     then().
             assertThat().
             statusCode(200).
             body("firstname", Matchers.equalTo("Jim")).
             body("lastname",Matchers.equalTo("Jones")).
             body("bookingdates.checkin",Matchers.equalTo("2016-03-21")).
             body("bookingdates.checkout",Matchers.equalTo("2017-11-07"));
           
		//You can use body() just once and insert assertions into it
		response.
		    then().
	        assertThat().
	        statusCode(200).
	        body("firstname", Matchers.equalTo("Jim"),
	        	 "lastname",Matchers.equalTo("Jones"),
	        	 "bookingdates.checkin",Matchers.equalTo("2016-03-21"),
	        	 "bookingdates.checkout",Matchers.equalTo("2017-11-07"));
	}
}
