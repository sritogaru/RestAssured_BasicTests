package chainingAPIs;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class CreateUser {
	
	@Test
	public void createuser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject jo = new JSONObject();
		
		jo.put("name", faker.name().fullName());
		jo.put("email", faker.internet().emailAddress());
		jo.put("gender", faker.dog().gender());
		jo.put("status", "active");
	
		String bearerToken = "248c66b553c6e75a581837d874e301d429151e2469a167979f99523e81b8192a";
	   int id = given()
			   .headers("Authorization","Bearer "+bearerToken)
	           .contentType("application/json")
	            .body(jo.toString())
	    
	   
	   .when()
	    .post("https://gorest.co.in/public/v2/users")
	    .jsonPath().getInt("id");
	   
	   System.out.println("Generated id is:"+id);
	   
	   //context.setAttribute("user_id", id);
	   //context.setAttribute("bearer_token", bearerToken);
	   context.getSuite().setAttribute("user_id",id);
	   context.getSuite().setAttribute("bearer_token",bearerToken);
		
	}

}
