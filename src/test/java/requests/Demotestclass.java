package requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Demotestclass {
	
	
	@Test
	public void getemployess() {
		
		given()
		
		.when()
		.get("https://dummy.restapiexample.com/api/v1/employees")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//@Test
	 void createemployee() {
		 
		 
	//Using HashMap
	
	HashMap hm = new HashMap();
	hm.put("employee_name", "himkum");
	hm.put("employee_salary", 34567);
	hm.put("employee_age", 30);

	
	given()
			.contentType("application/json")
			.body(hm)
	
	.when()
	 .post("https://dummy.restapiexample.com/api/v1/create")
	 
	
	 
	 .then()
	  .statusCode(200)
	   .log().all();
	  
	  
	
	
	
	 

	}
}
