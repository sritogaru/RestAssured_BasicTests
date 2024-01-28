package requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestJsonresponse {
	
	//@Test
	void testjson() {
		
		given()
		.body("ContentType.JSON")
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	@Test
	void testJsonresponse() {
		
		//Approach1
				
		/*given()
		.body("ContentType.JSON")
		
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("book[1].title", equalTo("Sword of Honour"))
		.log().all();*/
		
		//Approach2
		
		Response res=
		given()
		.body("ContentType.JSON")
		
		
		.when()
		.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(),200);
		
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String bookname = res.jsonPath().get("book[0].title").toString();
		
		Assert.assertEquals(bookname, "Sayings of the Century");
		
		System.out.println(bookname);
		
			
	}
	
	

}
