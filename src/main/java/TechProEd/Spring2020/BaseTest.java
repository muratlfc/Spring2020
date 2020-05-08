package TechProEd.Spring2020;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	protected RequestSpecification spec01;
	protected RequestSpecification spec02;
	
	@Before
	public void setUp01() {
		spec01 = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
	}	
		
	@Before
	public void setUp02() {
		spec02 = new RequestSpecBuilder().
                setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
                build();
	}
}
