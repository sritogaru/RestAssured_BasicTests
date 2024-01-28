package studentsAPIchaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreatePost {
	
	@Test
	
	public void createpost(ITestContext context) {
		
		Faker fake = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("title", fake.name().title());
		data.put("author", fake.artist().name());
		
		int id =given()
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("http://localhost:3000/posts/")
		.jsonPath().getInt("id");
		 
		 System.out.println("Generated id:"+id);
		 
		 context.setAttribute("post_id", id);
		
		
	}

}
