
package studentsAPIchaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetPost {
	
	@Test
	public void getpost(ITestContext context) {
		
		Object id= context.getAttribute("post_id");
			given()
		.contentType("application/json")
		.pathParam("id", id)
		
		.when()
		.get("http://localhost:3000/posts/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
