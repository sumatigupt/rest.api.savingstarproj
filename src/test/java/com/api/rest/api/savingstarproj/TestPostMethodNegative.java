package com.api.rest.api.savingstarproj;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import com.api.rest.api.model.RestResponse;

public class TestPostMethodNegative {
	
	/**
	 * @author Sumati
	 * 
	 */
	
	@Test
	public void testPostCraeteUserNegative(){
		
		String url = "https://api.savingstar.com/users.json";
        String  jsonBody = "{\"error\": {\"parameter\": \"email_address\", \"code\": 1, \"message\": \"Invalid email address\"}}";		
				
		RestApiHelper r = new RestApiHelper();
	    ArrayList<RestResponse> rest2=	r.performPostRequest(url);
	    RestResponse  been=rest2.get(0);
	   	    
	   System.out.println("statusPost"+been.getStatusCode());
	   System.out.println("respnsePost"+been.getResponseBody());
	   
	   
	// Putting Assertion	  
		Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, been.getStatusCode());		
	    Assert.assertEquals(jsonBody, been.getResponseBody());
		
		
	}

}
