package com.API.testcase;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.API.ResponseValidator.ResponseClass;
import com.API.payload.PayloadClass;
import com.API.teststep.HttpRequests;
import com.API.utils.PropertiesClass;

import io.restassured.response.Response;

public class VerifyJSONSchema {
	
	/*
	 * Verify the Response body against JSON Schema
	 */
	
	@Test
	public void loginPostReq() throws IOException {

		String projectPath = System.getProperty("user.dir");

		Properties Pr = PropertiesClass.fileConfig(projectPath + "/src/main/resources/Config/env.properties");

		HttpRequests http = new HttpRequests(Pr);

		JSONObject data = PayloadClass.loginPayload();

		Response res = http.loginPostReq("Meydan_login_api", data);

		ResponseClass r = new ResponseClass();
		r.loginSchemaResponse(res);

	}

}
