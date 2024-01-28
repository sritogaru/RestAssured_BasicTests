package studentsAPIchaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdatePost {
	
	@Test
	public void updatepost(ITestContext context) {
		
Faker fake = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("title", fake.name().title());
		data.put("author", fake.artist().name());
		
		Object id = context.getAttribute("post_id");
				
				given()
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		
		
		.when()
		.put("http://localhost:3000/posts/{id}")
		.jsonPath().getInt("id");
		 
		 System.out.println("Generated id:"+id);
		 
		 
	}
	

}
