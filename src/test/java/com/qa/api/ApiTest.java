package com.qa.api;

import static io.restassured.RestAssured.get;

import java.util.List;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	
	@Test(enabled = true)
	public void scenarios1() {
		Response response = get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(response.getStatusCode(), 200);
		JsonPath jsonPath = response.jsonPath();
		List<Object> list = jsonPath.getList("data");
		boolean expectedValue = list.get(3).toString().contains("first_name=Byron");
		Assert.assertTrue(expectedValue);
	}
	
	@SuppressWarnings("unchecked")
	@Test(enabled = true)
	public void testCase2()
	{ 
	 RestAssured.baseURI ="https://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 JSONObject requestParams = new JSONObject();
	 
	 requestParams.put("name", "Bryant"); 
	 requestParams.put("job", "BA");
	 
	 request.body(requestParams);
	 RestAssured.given()
             .header("Content-type", "application/json")
             .and()
             .body(requestParams)
             .post()
             .then()
             .log()
             .all()
             .assertThat()
             .statusCode(201);
	}
}
