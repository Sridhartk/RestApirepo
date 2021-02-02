package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TC_VideoGameAPI {
	
	@Test
	public void test_getAllVideoGames()
	{
		given()
			.contentType("application/json")
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200).log().body();
	}
	
	
	  @Test public void test_addNewVoideoGame() { HashMap<String, String> data=new
	  HashMap(); data.put("id", "11"); data.put("eamil", "Spider-Man@gmail.com");
	  data.put("firstname", "marvel"); data.put("lastname", "studios");
	  data.put("avatar", "https://reqres.in/img/faces/1-image.jpg");
	  
	  //connection.header("Accept", "application/xml;version=1");
	  
	  Response res = given() .contentType("application/json") .body(data) .when()
	  .post("https://reqres.in/api/users?page=2")
	  .then().statusCode(201).log().body().extract().response();
	  
	  String jsonstring=res.asString();
	 // Assert.assertEquals(jsonstring.contains("Record Added Successfully"), true);
	  }
	  
	  @Test public void test_putNewVoideoGame() { HashMap<String, String> data=new
			  HashMap(); data.put("id", "11"); data.put("eamil", "iron-Man@gmail.com");
			  data.put("firstname", "marvel"); data.put("lastname", "studios");
			  data.put("avatar", "https://reqres.in/img/faces/1-image.jpg");
			  
			  //connection.header("Accept", "application/xml;version=1");
			  
			  Response res = given() .contentType("application/json") .body(data) .when()
			  .put("https://reqres.in/api/users/2")
			  .then().statusCode(200).log().body().extract().response();
			  
			  String jsonstring=res.asString();
			 Assert.assertEquals(jsonstring.contains("iron-Man@gmail.com"), true);
			  }
	  
	  @Test 
	  public void test_patchNewVoideoGame() { HashMap<String, String> data=new   HashMap(); 
			  data.put("avatar", "https://reqres.in/img/faces/2-image.jpg");
			  
			  //connection.header("Accept", "application/xml;version=1");
			  
			  Response res = given() .contentType("application/json") .body(data) .when()
			  .put("https://reqres.in/api/users/2")
			  .then().statusCode(200).log().body().extract().response();
			  
			  String jsonstring=res.asString();
			 Assert.assertEquals(jsonstring.contains("avatar"), true);
			  }
	  //demo
	  @Test 
	  public void test_deleteNewVoideoGame() { HashMap<String, String> data=new
		  	  HashMap(); 
		  	  	  
		  Response res = given() .contentType("application/json") .body(data) .when()
		  .delete("https://reqres.in/api/users/11")
		  .then().statusCode(204).log().body().extract().response();
		 
		  
		  }
  
	  
	 

}
