package com.qa.api;

import java.util.HashMap;

//import static io.restassured.RestAssured.get;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.api.pojo.Data;
import com.qa.api.pojo.UserPages;
import com.qa.base.BaseApiTest;
import io.restassured.response.Response;

public class ApiTest extends BaseApiTest {
private final static String URL = "https://reqres.in/api/users?page=2";


	@Test(enabled = true)
	public void scenarios1() {
		UserPages userPages = get(URL).as(UserPages.class);
		List<Data> list = userPages.getData();
		for (Data items : list) {
			if (items.getId() == 10) {
				Assert.assertEquals(items.getFirst_name(), "Byron");
			}
		}
	}

	@Test(enabled = true)
	public void testCase2() {
		HashMap<String, String> body = new HashMap<>();
		body.put("name", "Bryant");
		body.put("job", "BA");
		Response reponse = postRequest("https://reqres.in/api/users", body);
		String id = reponse.then().assertThat().statusCode(201).and().extract().jsonPath().get("id");
		Assert.assertTrue(id!=null);
	}
}
