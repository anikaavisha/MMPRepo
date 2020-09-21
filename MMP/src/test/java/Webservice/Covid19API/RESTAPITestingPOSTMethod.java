package Webservice.Covid19API;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RESTAPITestingPOSTMethod {
	@Test(description = "Validated Response code", enabled = false)
	public void validatingPostMethodResponseCode() {
		// Username = "go-corona-admin";
		// Password = "5577YvzU4bK63a1WIQ3Z043H";
		// AUTHORIZATION Basic Auth
		// Uesr credentials for post request
		String userCredentials = ("go-corona-admin" + ":" + "5577YvzU4bK63a1WIQ3Z043H");
		// converting user credentials from string to base64 code
		String token = new String(Base64.encodeBase64(userCredentials.getBytes()));
		System.out.println(token);
		// creating request object
		RequestSpecification requestObject = RestAssured.given();
		// HashMap for request headers
		HashMap<String, Object> requestHeaders = new LinkedHashMap<String, Object>();
		// adding request headers in hashMap
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("AUTHORIZATION", "Basic " + token);
		// passing request headers to request object
		requestObject.headers(requestHeaders);
		String endPointUrl = "https://api.covid19api.com/auth/access_token";
		// getting response code by adding body to request
		int actualResponseCode = requestObject.when().urlEncodingEnabled(true)
				.body("{\"Email\":\"test1@covid19api.com\",\"Subscription\":\"basic\"}").post(endPointUrl)
				.getStatusCode();
		int expectedResponseCode = 200;
		Assert.assertEquals(actualResponseCode, expectedResponseCode);

	}

	@Test(description = "Validate Response Body")
	public void validationResponseBody() {
		// user Credentials for sending Post reaquest. And they have to be
		// converted in Base64 code for sending then in request header they
		// cannot be send as String
		String userCredentials = ("go-corona-admin" + ":" + "5577YvzU4bK63a1WIQ3Z043H");
		// converting into Base64 code
		String token = new String(Base64.encodeBase64(userCredentials.getBytes()));
		// creating Request object
		RequestSpecification request = RestAssured.given();
		// creating hashmap for request headers
		HashMap<String, Object> requestHeaders = new LinkedHashMap<String, Object>();
		requestHeaders.put("AUTHORIZATION", "Basic " + token);
		// adding request headers in request
		request.headers(requestHeaders);
		// end point url
		String endPointUrl = "https://api.covid19api.com/auth/access_token";
		// getting response body
		ResponseBody responseBody = request.when().urlEncodingEnabled(true)
				.body("{\"Email\":\"test1@covid19api.com\", \"Subscription\":\"basic\"}").post(endPointUrl).body();
		// converting it in to reading String format
		System.out.println(responseBody.asString());
		// creating jpath object for verifying content of body
		JsonPath jPath = new JsonPath(responseBody.asString());
		// verifying value of Key
		String actualStatusValue = jPath.get("Key");
		String expectedStatusValue = "a58c8434-3f60-4cce-8998-8c6bc30bd4e8";
		Assert.assertEquals(actualStatusValue, expectedStatusValue);
	}

	
	@Test(description = "verify response body and specfic body content")
	
	public void validateResponseHeaders()
	{

		String userCredentials = "go-corona-admin" + ":" + "5577YvzU4bK63a1WIQ3Z043H";
		String token = new String(Base64.encodeBase64(userCredentials.getBytes()));
		RequestSpecification request = RestAssured.given();
		HashMap<String, Object> requestHeaders = new LinkedHashMap<String, Object>();
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("AUTHORIZATION", "Basic " + token);
		request.headers(requestHeaders);
		String endPointUrl = "https://api.covid19api.com/auth/access_token";
		Headers responseHeader = request.when().urlEncodingEnabled(true)
				.body("{\"Email\":\"test1@covid19api.com\", \"Subscription\":\"basic\"}")
				.post("https://api.covid19api.com/auth/access_token").getHeaders();
		List<Header> headerList = responseHeader.asList();
		for (int i = 0; i < headerList.size(); i++) {
			String eachresponseHeader = (headerList.get(i).getName() + ":" + headerList.get(i).getValue());
			System.out.println(eachresponseHeader);

		}
		responseHeader = request.when().urlEncodingEnabled(true)
				.body("{\"Email\":\"test1@covid19api.com\", \"Subscription\":\"basic\"}")
				.post("https://api.covid19api.com/auth/access_token").getHeaders();
		String contentLengthHeaderValue= responseHeader.getValue("Content-Length");
		int expectedcontentLengthHeaderValue = 132;
		Assert.assertEquals(contentLengthHeaderValue, Integer.toString(expectedcontentLengthHeaderValue));
		
		

	}
	@Test
	public void validationWithoutAuthentication(){
	
	
	RequestSpecification request = RestAssured.given();
	HashMap<String, Object> requestHeaders = new LinkedHashMap<String, Object>();
	requestHeaders.put("Content-Type", "application/json");
	request.headers(requestHeaders);
	String endPointUrl = "https://api.covid19api.com/auth/access_token";
	int actualStatusCode = request.when().urlEncodingEnabled(true)
			.body("{\"Email\":\"test1@covid19api.com\", \"Subscription\":\"basic\"}")
			.post("https://api.covid19api.com/auth/access_token").getStatusCode();
	int expectedStatusCode = 401;
	Assert.assertEquals(actualStatusCode, expectedStatusCode);
	
	

}
}
