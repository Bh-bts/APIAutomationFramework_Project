package com.API.ResponseValidator;

import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.util.List;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.lessThan;

public class ResponseClass {

	/*
	 * Verify the status code
	 */

	public static String b;

	public Response loginResponse(Response res) {

		String token = res.getBody().asPrettyString();
		JsonPath jp = new JsonPath(token);
		String a = jp.get("data.token");

		b = a;
		return res;
	}

	public Response dashboardResponse(Response res) {

		assertEquals(res.getStatusCode(), 200);

		return res;
	}

	/*
	 * Verify the single part of the body data
	 */

	public Response loginBodyResponse(Response res) {

		res
			.then()
			.assertThat()
			.body(containsString("first_name"));

		return res;
	}
	
	/*
	 * Verify the Header & Cookies in Response body
	 */

	public Response loginHeaderCookiesResponse(Response res) {

		assertEquals(res.getContentType(), "application/json; charset=utf-8");
		System.out.println(res.getCookies());

		return res;
	}

	/*
	 * Verify the Response body against JSON Schema
	 */
	
	public Response loginSchemaResponse(Response res) {

		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/src/main/resources/JSONSchema/loginJsonSchema.json");
		
		res
			.then()
				.assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(file));

		return res;
	}

	/*
	 * Verify the response Body time
	 */
	
	public Response loginResponseTime (Response res) {

		res
			.then()
			.assertThat()
			.time(lessThan(2000L));
		
		return res;
	}
	
	/*
	 * Extract specific data from API
	 */

	public Response ExtractDataFromAPI(Response res) {

		String token = res.getBody().asPrettyString();
		JsonPath jpath = new JsonPath(token);

		List<String> data = jpath.get("data.frequentuser.first_name");

		StringBuilder sb = new StringBuilder();

		for (String a : data) {

			String b = a.toString();

			for (int i = 0; i < b.length(); i++) {

				sb.append(i).append(": ").append(data.get(i)).append("\n");

			}

			System.out.println(sb.toString());

		}

		return res;
	}

}
