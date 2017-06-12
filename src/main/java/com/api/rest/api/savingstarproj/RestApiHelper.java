package com.api.rest.api.savingstarproj;

import java.util.ArrayList;

import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.rest.api.model.*;


public class RestApiHelper {

	/**
	 * @author Sumati Gupta
	 *			Step 1:- Created the HTTP Get method 
	 * 			Step 2:- Created the HTTP Client 
	 * 			Step 3:- Executed the HTTp method using the client
	 *          Step 4:- capturing the response of execution 
	 *          Step 5:- Display the response at the console for test.
	 */

	/**
	 * @param url
	 * @return ArrayList<RestResponse> 
	 */
	public ArrayList<RestResponse> performGetRequest(String url) {
		// Step 1:- Created the HTTP Get method
		// HttpGet("https://api.savingstar.com/users/account.json?user_id=12345");

		HttpGet get = new HttpGet(url);

		ArrayList<RestResponse> arGetReq = new ArrayList<RestResponse>();
		try {
			get.addHeader("accept", "application/json");

			// Step 2:- Created the HTTP Client
			CloseableHttpClient client = HttpClientBuilder.create().build();

			// Step3 :- Executed the HTTp method using the client
			CloseableHttpResponse response = client.execute(get);

			// Step 4:- capturing the response of execution
			StatusLine status = response.getStatusLine();

			ResponseHandler<String> body = new BasicResponseHandler();
			String getBody = body.handleResponse(response);
			System.out.println(status.getStatusCode());
			// System.out.println(getBody);

			RestResponse rv = new RestResponse();
			rv.setStatusCode(status.getStatusCode());
			rv.setResponseBody(getBody);

			System.out.println("Response: " + rv.getResponseBody());
			System.out.println("Status: " + rv.getStatusCode());

			// Step 5:- Display the response at the console for test.
			
			  System.out.println(status.getStatusCode());
			  System.out.println(status.getProtocolVersion());
			  System.out.println(getBody);
		 

			arGetReq.add(rv);
			client.close();
			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arGetReq;
	}


	/**
	 * @param url
	 * @return ArrayList<RestResponse>
	 */
	public ArrayList<RestResponse> performPostRequest(String url) {

		String postBody = "email_address=foo@bar.com&password=abc123";
		ArrayList<RestResponse> arPostReq = new ArrayList<RestResponse>();

		// Step 1:- Created the HTTP Get method
		// HttpPost("https://api.savingstar.com/coupons.json/users.json");

		HttpPost post = new HttpPost(url);
		try {

			// Step 2:- Created the HTTP Client
			CloseableHttpClient client = HttpClientBuilder.create().build();

			// Step3 :- Executed the HTTp method using the client
			// including Header
			post.addHeader("Content-Type", "application/x-www-form-urlencoded");
			post.addHeader("accept", "application/json");
			StringEntity data = new StringEntity(postBody,
					ContentType.APPLICATION_FORM_URLENCODED);
			post.setEntity(data);
			CloseableHttpResponse response = client.execute(post);

			// Step 4:- Capturing the response of execution
			StatusLine status = response.getStatusLine();
			ResponseHandler<String> postBodyResponse = new BasicResponseHandler();
			String getBody = postBodyResponse.handleResponse(response);
			RestResponse rv = new RestResponse();
			rv.setStatusCode(status.getStatusCode());
			rv.setResponseBody(getBody);

			System.out.println("Response: " + rv.getResponseBody());
			System.out.println("Status: " + rv.getStatusCode());

			// Step 5:- Display the response at the console.
			
			  System.out.println(status.getStatusCode());
			  System.out.println(status.getProtocolVersion());
			  System.out.println(getBody);
			 

			arPostReq.add(rv);
			client.close();
			response.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arPostReq;

	}

}
