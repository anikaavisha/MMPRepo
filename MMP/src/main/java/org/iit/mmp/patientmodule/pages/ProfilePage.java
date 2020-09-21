package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProfilePage {
	
	private WebDriver driver;
	private By editButtonID = By.id("Ebtn");
	private By ageFieldID = By.id("age");
	private By saveButtonID = By.id("Sbtn");
	private By viewHistoryButton = By.linkText("View History");
	private By ssnID = By.id("ssn");
	private By firstNameID = By.id("fname");
	private By  ageID = By.id("age");
	
	HashMap<String, String> expectedhMap = new HashMap<String, String>();
	HashMap<String, String> actualhMap = new HashMap<String, String>();

	public ProfilePage(WebDriver driver) {
		this.driver = driver;

	}

	// Click on Edit Button
	public boolean clickEditButton() {
		driver.findElement(editButtonID).click();
		return true;
	}

	// Editing different fields like
	// weight,age,height,firstName,Lastname,License,ssn
	// Store values in hashMap - Expected
	// Click on Save button

	public HashMap<String, String> editValue(String fieldValue, By locator, String key) {
		WebElement e = driver.findElement(locator);
		e.clear();
		e.sendKeys(fieldValue);
		expectedhMap.put(key, fieldValue);
		return expectedhMap;
	}

	// Validate Alert Box Message and Click OK
	public boolean verifyUpdateMessage(String expectedMsg) {
		driver.findElement(saveButtonID).click();
		Alert a = driver.switchTo().alert();
		String actualMsg = a.getText().trim();
		Assert.assertEquals(actualMsg, expectedMsg);
		a.accept();
		return true;
	}

	// Get the updated values from the fields and Store in HashMap
	public HashMap<String, String> gettingUpdatedValue(By locator, String key) {
		String updateFieldValue = driver.findElement(locator).getAttribute("value");
		actualhMap.put(key, updateFieldValue);
		return actualhMap;
	}

	// Compare Both hashmap , 1st hashMap will have expected value and 2nd will
	// have actual value
	public boolean verifyUpdatedvalue(String key) {
		Assert.assertEquals(actualhMap.get(key), expectedhMap.get(key));
		return true;

	}
	
	//Method to get SSN of Patient from patient Profile Page
	public String getSSN(){
		String patientSSN= driver.findElement(ssnID).getAttribute("value");
		System.out.println(patientSSN);
		return patientSSN;
	}
	
	//Method to get Value(age,ssn,name) from patient Profile page and store in HashMap
	public HashMap <String,String> patientData(){
		//HashMap Object
		HashMap<String,String> patientFieldValues = new HashMap<String,String>();
		
		//getting values from field
		String firstName = driver.findElement(firstNameID).getAttribute("value");
		String ssn =driver.findElement(ssnID).getAttribute("value");
		String age = driver.findElement(ageID).getAttribute("value");
		
		//string in HashMap
		patientFieldValues.put("FIrstName", firstName);
		patientFieldValues.put("SSN",ssn);
		patientFieldValues.put("Age",age);
		System.out.println(patientFieldValues);
		return patientFieldValues;
		
	}
	
	
	
	
}
