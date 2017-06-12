package com.api.rest.api.savingstarproj;

import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import com.api.rest.api.model.RestResponse;

public class TestGetMethodNegativeTest {
	
	/**
	 * @author Sumati Gupta
	 * 
	 */
	
	// Test Case with the wrong user id (assuming this is wrong id).
	@Test
	public void testGetAccountDetailsNe() {
		String url = "https://api.savingstar.com/users/account.json?user_id=12345889";
		String jsonBody = "{\"error\": {\"parameter\": \"user_id\", \"code\": 12, \"message\": \"Unknown user_id\"}}";

		RestApiHelper r = new RestApiHelper();
		ArrayList<RestResponse> rest2 = r.performGetRequest(url);
		RestResponse been = rest2.get(0);

		System.out.println("statusnegativ" + been.getStatusCode());
		System.out.println("respnsenegativ" + been.getResponseBody());
		// Putting Assertion
		Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, rest2);
		Assert.assertEquals(jsonBody, been.getResponseBody());
	}
}