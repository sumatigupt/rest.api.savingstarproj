package com.api.rest.api.savingstarproj;

//import org.testng.annotations.Test;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import com.api.rest.api.model.RestResponse;

public class TestGetMethod {
	
	/**
	 * @author Sumati Gupta
	 * 
	 */
	
	// Test Case with the correct user id (assuming this is correct id).
	@Test
	public void testGetAccountDetails() {
		// Passing URL
		String url = "https://api.savingstar.com/users/account.json?user_id=12345";
		String jsonBody = "{\"account\": {\"available_savings\": 5.00, \"lifetime_savings\": 23.50}}";

		// creating object of RestApiHelper class

		RestApiHelper r = new RestApiHelper();
		ArrayList<RestResponse> rest2 = r.performGetRequest(url);
		RestResponse been = rest2.get(0);

		System.out.println("status" + been.getStatusCode());
		System.out.println("respnse" + been.getResponseBody());

		// Putting Assertion
		Assert.assertEquals(HttpStatus.SC_OK, been.getStatusCode());
		Assert.assertEquals(jsonBody, been.getResponseBody());

	}

}
