package TechProEd.Spring2020;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestApiGetRequest08 extends BaseTest {

	@Test
	public void getTest03(){ 
		
	Response response = given().
					       spec(spec02).
				        when().
					       get();
	
	response.prettyPrint();
	
	JsonPath json = response.jsonPath();
	
	//Get all ids into a list
	List<String> ids = json.getList("data.id");
	System.out.println(ids);
	//Assert the number of the ids
	assertEquals(ids.size(),24);
	//Get all ids greater than 10
	List<String> ids02 = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
	//"data.findAll{Integer.valueOf(it.id)>10}.id" that syntax comes from Java Groovy
	System.out.println(ids02);
	
	//Get all employee ages into a list
	List<String> ages01 = json.getList("data.employee_age");
	System.out.println(ages01);
	//Assert the number of the employee ages
	assertEquals(ages01.size(),24);
	//Get all employee ages less than 30
	List<String> ages02 = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
	System.out.println(ages02);
	//Get all employee names whose age is less than 30
	List<String> ages03 = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_name");
	System.out.println(ages03);
	
	//Get all employee names into a list
	List<Integer> names = json.getList("data.employee_name");
	System.out.println(names);
	//Assert the number of the names
	assertEquals(names.size(),24);
	//Assert "Cedric Kelly" is among the names
	assertTrue(names.contains("Cedric Kelly"));
	}
}
