package com.api.rest.api.savingstarproj;

import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import com.api.rest.api.model.RestResponse;

public class TestPostMethod {
	
	/**
	 * @author Sumati Gupta
	 * 
	 */

	@Test
	public void testPostCraeteUser() {

		String url = "https://api.savingstar.com/users.json";
		String jsonBody = "{\"user\": {\"id\": \"4ef9c30b6ff1347d\", \"email_address\": \"foo@bar.com\"}";

		RestApiHelper r = new RestApiHelper();
		ArrayList<RestResponse> rest2 = r.performPostRequest(url);
		RestResponse been = rest2.get(0);

		System.out.println("statusPost" + been.getStatusCode());
		System.out.println("respnsePost" + been.getResponseBody());

		// Putting Assertion
		Assert.assertEquals(HttpStatus.SC_OK, been.getStatusCode());
		Assert.assertEquals(jsonBody, been.getResponseBody());

	}

}
