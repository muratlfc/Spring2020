package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApiGetRequest06 extends BaseTest {

	@Test
	public void getTest01(){ 
	/*
	 * Without using the spec.queryParam() we can do like the following but using 
	   spec.queryParam() is better
	  
	 *Response response = given().
				            spec(spec).
			              when().
				            get("/booking?firstname=Sally&lastname=Brown");
	*/
		
    spec01.queryParam("firstname", "Mary");
    spec01.queryParam("lastname", "Smith");
		
	Response response = given().
					       spec(spec01).
				        when().
					       get("/booking");
	
	response.prettyPrint();
	
	response.
	    then().
	    assertThat().
	    statusCode(200);
	}
	
}
