package chainingAPIs;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	public void getuser(ITestContext context) {
		
		//Object id = context.getAttribute("user_id"); //this id should come from create user
		//Object btoken = context.getAttribute("bearer_token")
		
		Object id = context.getSuite().getAttribute("user_id"); //this id should come from create user
		
		Object btoken = context.getSuite().getAttribute("bearer_token");
		
	
		given()
		.headers("Authorization","Bearer "+btoken)
        .pathParam("id", id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}") //id is path parameter 
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
