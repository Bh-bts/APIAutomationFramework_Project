package com.API.teststep;

import java.util.Properties;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class HttpRequests {

	static Properties Pr;

	public HttpRequests(Properties Pr) {

		this.Pr = Pr;

	}

	public Response loginPostReq(String URI, JSONObject Data) {

		Response res = 
		
		given()
			.header("Content-Type","application/json")
			.header("Accept","application/json")
			.body(Data.toString())
		.when()
			.post(Pr.getProperty(URI));
		
		return res;

	}
	
	public Response dashboardPostReq(String URI,String token) {
		
		Response res = 
				
			given()
				.header("Content-Type","application/json; charset=utf-8")
				.header("Authorization","Bearer " + token)
			.when()
				.get(Pr.getProperty(URI));
		
		return res;
		
	}

}
