package com.api.rest.api.savingstarproj;

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


public class GetRequest {
	
	/**
	 * @author Sumati
	 * Step 1:- Create the HTTP Get method 
	 * Step 2:- Create the HTTP Client
	 * Step3 :- Execute the HTTp method using the client
	 * Step 4:- Catch the response of execution
	 * Step 5:- Display the response at the console.
	 */
	
	public static void main(String args[]){
		
		
		
		/*try {
			HttpGet get = new HttpGet("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
			get.addHeader("accept", "application/json");
			CloseableHttpClient client = HttpClientBuilder.create().build();
			CloseableHttpResponse  response = 	client.execute(get);
			StatusLine status = response.getStatusLine();
			System.out.println(status.getStatusCode());
			System.out.println(status.getProtocolVersion());
			ResponseHandler<String> body = new BasicResponseHandler();
		    String getBody = body.handleResponse(response);
		    System.out.println(getBody);
			client.close();
			response.close();
		} catch(Exception e){
		e.printStackTrace();			
		}*/
	//	RestApiHelper re = new RestApiHelper();		
//re.performGetRequest("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");		
	

			
		String postBodyValue = "email_address=foo@bar.com&password=abc123";
			
			
		//Step 1:- Create the HTTP Get method 
			//HttpGet get = new HttpGet("https://api.savingstar.com/coupons.json/users/account.json?user_id=12345");
			HttpPost post = new HttpPost("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
			
			//HttpPost post = new HttpPost(url);
			try {
				
		// Step 2:- Create the HTTP Client
				CloseableHttpClient client = HttpClientBuilder.create().build();

		// Step3 :- Execute the HTTp method using the client		
				//CloseableHttpResponse  response = 	client.execute(get);
				// including Header			
				post.addHeader("Content-Type", "application/x-www-form-urlencoded");
				post.addHeader("accept", "application/json");
				StringEntity data = new StringEntity(postBodyValue, ContentType.APPLICATION_FORM_URLENCODED);
				post.setEntity(data);
				CloseableHttpResponse  response = client.execute(post);
				
		// Step 4:- Catch the response of execution		
				StatusLine status = response.getStatusLine();
			
		//	ResponseHandler<String> body = new BasicResponseHandler();
		//    String getBody = body.handleResponse(response);
		 //   System.out.println(getBody);
		// Step 5:- Display the response at the console.		
				System.out.println(status.getStatusCode());
				System.out.println(status.getProtocolVersion());		    
				System.out.println(response);
				
				
					    
				client.close();
				response.close();
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//return postBody;
	
			
			
			
		
		
	}

}
