package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestApiGetRequest07 extends BaseTest {

	/*
	 * When I send a GET request to REST API URL
	 * https://restful-booker.herokuapp.com/5 Then HTTP Status Code should be 200
	 * And response content type is “application/JSON” And response body should be
	 * like; { "firstname": "Sally", "lastname": "Ericsson", "totalprice": 111,
	 * "depositpaid": false, "bookingdates": { "checkin": "2017-05-23", "checkout":
	 * "2019-07-02" } }
	 */

	@Test
	public void getTest01() {

		Response response = given().spec(spec01).when().get("/booking/1");

		response.then().assertThat().statusCode(200);

		response.prettyPrint();

		JsonPath json = response.jsonPath();// Gets Json format and assigns it to JsonPath

		System.out.println(json.getString("firstname"));
		assertEquals("The firstname did not match", json.getString("firstname"), "Jim");

		System.out.println(json.getString("lastname"));
		assertEquals("The lastname did not match", json.getString("lastname"), "Ericsson");

		System.out.println(json.getInt("totalprice"));
		assertEquals("The total price did not match", json.getInt("totalprice"), 216);

		System.out.println(json.getBoolean("depositpaid"));
		assertEquals("The deposit paid did not match", json.getBoolean("depositpaid"), false);

		System.out.println(json.getString("bookingdates.checkin"));
		assertEquals("The bookingdates checkin did not match", json.getString("bookingdates.checkin"), "2016-09-08");

		System.out.println(json.getString("bookingdates.checkout"));
		assertEquals("The bookingdates checkout did not match", json.getString("bookingdates.checkout"), "2020-04-13");

		System.out.println(json.getString("additionalneeds"));
		assertEquals("The additional needs did not match", json.getString("additionalneeds"), null);

	}

	@Test
	public void getTest02() {

		// if there is array in Json response whose name is link.
		// link.href gives all hrefs inside the link array.
		// If you want to get first href use link[0].href
		// But if the array has no any name href[0] gives the first href
		// look at the following example

		Response response = given().spec(spec02).when().get();

		response.prettyPrint();
		
		SoftAssert softAssert = new SoftAssert();

		JsonPath json = response.jsonPath();
		System.out.println(json.getString("data.employee_name"));
		
		System.out.println(json.getString("data[0].employee_name"));
		softAssert.assertEquals(json.getString("data[0].employee_name"), "Tiger Nixo","Employee name did not match");

		System.out.println(json.getString("data[1].employee_salary"));
		softAssert.assertEquals(json.getString("data[1].employee_salary"), "17075","Salary did not match");

		softAssert.assertAll();
		response.then().assertThat().statusCode(200);
	}
}
