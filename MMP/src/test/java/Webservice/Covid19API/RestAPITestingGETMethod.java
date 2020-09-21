package Webservice.Covid19API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

public class RestAPITestingGETMethod {
// For Verifying Rest WebService we need RestAssured API, which we added in Maven Project.
//We are using Ecllipse to write code and TestNG for exceution and we are adding Rest Assured API in Maven project.
//For generating response , we need Request URL(End Point URL), We will add Request headers in request and we will verify 3 things in reponse. Response Code - Which should be 200, Response Headers we will verify Response header name and value is correct.And most imporatnt id response body. 

	@Test(enabled=false)

	public void validationCovid19APIGetMethod() {
        //Build the Request object
		RequestSpecification requestObject = RestAssured.given();
		
		//Creating HashMap to add Resquest Headers
		HashMap<String, Object> requestHeaders = new LinkedHashMap<String, Object>();
		requestHeaders.put("cache-control", "max-age=0");
		requestHeaders.put("sec-fetch-dest", "document");
		//Adding headers to Request Object
		requestObject.headers(requestHeaders);
		
		// URL Of API 
		String endPointUrl = "https://api.covid19api.com/";
        
		//Creating Response out of request
		Response response = requestObject.when().get(endPointUrl);

		// Validating StatusCode
		int actualResponseCode = response.getStatusCode();
		int expectedResponsecode = 200;
		Assert.assertEquals(actualResponseCode, expectedResponsecode);

		// Validating responseHeaders
		Headers responseHeader = response.headers();
		List<Header> headerList = responseHeader.asList();
		for (int i = 0; i < headerList.size(); i++) {
			System.out.println(headerList.get(i).getName() + ":" + headerList.get(i).getValue());
			if (headerList.get(i).getName().contains("Content-Length")) {
				String actualContentLengthValue = headerList.get(i).getValue();
				int expectedContentLengthValue = 1164;
				Assert.assertEquals(actualContentLengthValue, Integer.toString(expectedContentLengthValue));

			}

		}

		// Validating Response Body. prettyPrint will print json response in readble Json form .In Manual testing this can be done using Json formattor and validator. Json Formattor url - https://jsonformatter.curiousconcept.com/#
		
		String responseBody = response.getBody().prettyPrint();
		System.out.println(responseBody);

		// validating content of response body

		responseBody = response.getBody().asString();
		System.out.println(responseBody);
		JsonPath jPath = new JsonPath(response.getBody().asString());
		//By using json path we can verify content of specific Response body  by using json Synatx for eg : allRoute.Name will display Name content of allRoute tag. This can be done manually using jsonpath.com, just copy paste formated json response and use syntax to get specific content 
		String actualResponseBody = jPath.get("allRoute.Name");
		System.out.println(actualResponseBody);
		String expectedResponseBody = "Get All Data";
		Assert.assertEquals(actualResponseBody, expectedResponseBody);

	}
	
	@Test
	public void validateGetMethod(){
		RequestSpecification request = RestAssured.given();
		HashMap<String,Object> requestHeaders = new LinkedHashMap<String,Object>();
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("sec-fetch-mode","navigate");
		requestHeaders.put("accept-language", "en-US,en;q=0.9");
		request.headers(requestHeaders);
		String endPointUrl = "https://api.covid19api.com/summary";
		
		//response
		Response response = request.when().get(endPointUrl);
		
		//getting responseCode
		int actualRequestStatusCode= response.getStatusCode();
		int expectedRequestStatusCode = 200;
		Assert.assertEquals(actualRequestStatusCode, expectedRequestStatusCode);
		
		//Validating Response body
	 String responseBodyInReadadbleJsonForm  = response.getBody().prettyPrint();
	 System.out.println(responseBodyInReadadbleJsonForm);
	 
	 //Validating reponse body content -Countries
	 
	String responseBody =  response.getBody().asString();
	JsonPath jPath = new JsonPath(responseBody);
	ArrayList actualValueOfGlobal = jPath.get("Countries");
	System.out.println("CountriesData " + actualValueOfGlobal.get(7));
	
	//validating response body Content
	response.getBody().asString();
	JsonPath jPath1 = new JsonPath(response.getBody().asString());
	LinkedHashMap<String,Object> globalContent = jPath1.get("Global");
	System.out.println(globalContent);
	
	//Validating all responseHeader 
	Headers header = response.headers();
	List<Header> headerList= header.asList();
	for(int i=0;i<headerList.size();i++){
	System.out.println(headerList.get(i).getName()+":"+headerList.get(i).getValue());
	}
	
	//Validating specific header
	Headers header1 = response.headers();
	List<Header> headerList1 = header1.asList();
	for(int i=0;i<headerList1.size();i++){
			if((headerList1.get(i).getName()).contains("X-Frame-Options")){
			String actualValue	= headerList1.get(i).getValue();
			String expectedValue = "DENY";
			Assert.assertEquals(actualValue, expectedValue);
			
			}
			
			
	
	}
	
}
	
}
