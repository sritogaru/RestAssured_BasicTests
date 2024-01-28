package requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import pojo.POJO_request;

public class PostRequestsusingHashMap {

	   /*@Test(priority=1,enabled=false)
		void createcomment() {
			HashMap hm = new HashMap();
			hm.put("title", "netflix");
			hm.put("author", "sada");
			
			given()
			.contentType("application/json")
			.body(hm)
			
			.when()
			 .post("http://localhost:3000/comments")
			
			.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.body("title",equalTo("netflix"))
			.body("author", equalTo("sada"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	}*/
		
		/*@Test(priority=1)
				void createcomment() {
					
			JSONObject obj = new JSONObject();
					obj.put("title", "kushi");
					obj.put("author", "simha");
					
					given()
					.contentType("application/json")
					.body(obj.toString())
					
					.when()
					 .post("http://localhost:3000/comments")
					
					.then()
					.statusCode(201)
					.statusLine("HTTP/1.1 201 Created")
					.body("title",equalTo("mrunal"))
					.body("author", equalTo("simbu"))
					.header("Content-Type","application/json; charset=utf-8")
					.log().all();
		}
		@Test(priority=1,enabled=false)
		void createcomment() {
			
			POJO_request obj = new POJO_request();
			obj.setAuthor("kam");
			obj.setTitle("sam");
			
			given()
			.contentType("application/json")
			.body(obj)
			
			.when()
			 .post("http://localhost:3000/comments")
			
			.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.body("title",equalTo("sam"))
			.body("author", equalTo("kam"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
}*/
	@Test(priority=1)
	void createcomment() throws FileNotFoundException {
		
		File f = new File(".\\body.json"); //read the file 
		
		FileReader fr = new FileReader(f); //open the file using filereader
		
		JSONTokener jt = new JSONTokener(fr); //split jsondata into tokens
		
		JSONObject obj = new JSONObject(jt);// create object for jsondata
		
		
		given()
		.contentType("application/json")
		.body(obj.toString()) //converting jsonobject data into string format
		
		.when()
		 .post("http://localhost:3000/comments")
		
		.then()
		.statusCode(201)
		.statusLine("HTTP/1.1 201 Created")
		.body("title",equalTo("ml"))
		.body("author",equalTo("smoothy"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	@Test(priority=2,enabled=false)
	void deletecomment() {
		
		given()
		
		.when()
		    .delete("http://localhost:3000/comments/7")
		 
		.then()
		   .statusCode(200)
		   .log().all();
		
	}

}
