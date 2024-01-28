package requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestJsonresponseBodyData {
	
	//@Test
	public void jsonresponsebodyTest() {
		
		Response res=
				given()
				.body("ContentType.JSON")
				
				
				.when()
				.get("http://localhost:3000/store");
				
			JSONObject jo = new JSONObject(res.asString());
			
			//print all title of books
			
			for(int i=0; i<jo.getJSONArray("book").length();i++)
			{
				String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				System.out.println(bookTitle);

			}
			
			boolean status = false;
			for (int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				if(bookTitle.equalsIgnoreCase("Moby Dick")) {
					status = true;
					break;
				}
			}
            Assert.assertEquals(status, true);
            
	}
	
	@Test
	public void jsonresponsetest2() {
		
		Response res=
				given()
				.body("ContentType.JSON")
				
				
				.when()
				.get("http://localhost:3000/store");
				
			JSONObject jo = new JSONObject(res.asString());
			
			//getting total price of books
			
			double totalprice = 0;
			for(int i=0;i<jo.getJSONArray("book").length();i++) {
				
				String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				
				totalprice=totalprice+Double.parseDouble(price);
			}
				System.out.println("Total price of books:"+ totalprice);
			
			
			Assert.assertEquals(totalprice, 53.92);
		
	}

}
