package chainingAPIs;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	public void updateuser(ITestContext context) {
		
Faker faker = new Faker();
		
		JSONObject jo = new JSONObject();
		
		jo.put("name", faker.name().fullName());
		jo.put("email", faker.internet().emailAddress());
		jo.put("gender", faker.dog().gender());
		jo.put("status", "Inactive");
	
		//Object id = context.getAttribute("user_id"); //this id should come from create user
				//Object btoken = context.getAttribute("bearer_token")
		
	   Object id = context.getSuite().getAttribute("user_id");
	   Object btoken = context.getSuite().getAttribute("bearer_token");
			   given()
			   .headers("Authorization","Bearer "+btoken)
	           .contentType("application/json")
	            .body(jo.toString())
	            .pathParam("id", id)
	    
	   
	   .when()
	    .put("https://gorest.co.in/public/v2/users/{id}")
	   
	    .then()
	    .statusCode(200)
	    .log().all();
			   System.out.println(btoken);
	   
	   
		
	}

}
