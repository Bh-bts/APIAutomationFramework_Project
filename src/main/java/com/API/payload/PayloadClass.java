package com.API.payload;

import org.json.JSONObject;

public class PayloadClass {
	
	public static JSONObject loginPayload() {
		
		JSONObject Data = new JSONObject();
		Data.put("email", "admin@gmail.com");
		Data.put("password", "Admin@123");
		Data.put("project_type", "Admin");
		
		return Data;
		
	}

}
