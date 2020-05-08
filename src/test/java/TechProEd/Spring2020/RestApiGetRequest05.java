package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApiGetRequest05 extends BaseTest {

/*
	When I send a GET request to REST API URL https://restful-booker.herokuapp.com/5   
    Then HTTP Status Code should be 200
    And response content type is “application/JSON”
    And response body should be like; 
    {
	    "firstname": "Sally",
	    "lastname": "Ericsson",
	    "totalprice": 111,
	    "depositpaid": false,
	    "bookingdates": {
	        "checkin": "2017-05-23",
	        "checkout": "2019-07-02"
	     }
    }
*/
	
	@Test
	public void getTest01(){ 
		
	spec01.pathParam("bookingid", 5);	
		
	Response response = given().
					       spec(spec01).
				        when().
					       get("/booking/{bookingid}");
	
	response.prettyPrint();
	
	//We can put multiple key+values inside the body parenthesis like;
	//body("firstname",Matchers.equalTo("Sally"),
	//     "lastname",Matchers.equalTo("Ericsson"));

	response.
	    then().
	    assertThat().
	    statusCode(200).
	    contentType(ContentType.JSON).
	    body("firstname",Matchers.equalTo("Sally")).
	    body("lastname",Matchers.equalTo("Ericsson")).
	    body("totalprice",Matchers.equalTo(111)).
	    body("depositpaid",Matchers.equalTo(false)).
	    body("bookingdates.checkin",Matchers.equalTo("2017-05-23")).
	    body("bookingdates.checkout",Matchers.equalTo("2019-07-02"));
	}
	
}
