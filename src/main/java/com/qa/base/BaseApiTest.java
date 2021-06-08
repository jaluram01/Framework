package com.qa.base;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApiTest {
	
	public Response get(String url) {
		return RestAssured.get(url);
	}
	
	public Response postRequest(String url, HashMap<String, String> body) {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();	
		request.body(body);
		return request.post();
	}
}
