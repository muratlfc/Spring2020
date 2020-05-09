package TechProEd.Spring2020;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest01 {

	protected RequestSpecification spec01;
	
	@Before
	public void setUp01() {
		spec01 = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
	}
}
