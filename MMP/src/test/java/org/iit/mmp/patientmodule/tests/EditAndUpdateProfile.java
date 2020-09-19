package org.iit.mmp.patientmodule.tests;

import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.ProfilePage;
import org.iit.util.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditAndUpdateProfile extends BaseClass {
	Random rand = new Random();
	int alphNumb = 65 + rand.nextInt(26);
	HashMap<String, String> expectedHMap = new HashMap<String, String>();
	HashMap<String, String> actualHMap = new HashMap<String, String>();

	// locators
	By firstNameID = By.id("fname");
	By lastNameID = By.id("lname");
	By licenseID = By.id("licn");
	By ssnID = By.id("ssn");
	By stateID = By.id("state");
	By cityID = By.id("city");
	By addressID = By.id("address");
	By zipcodeID = By.id("zipcode");
	By ageID = By.id("age");
	By heightID = By.id("height");
	By weightID = By.id("weight");
	By pharmacyID = By.id("pharmacy");
	By pharmacyAddressID = By.id("pharma_adress");
	By emailID = By.id("email");

	// Login
	// Navigate to Profile Page
	// Click on Edit Button
	// Editing different fields like
	// weight,age,height,firstName,Lastname,License,ssn
	// Store values in hashMap - Expected
	// Click on Save button
	// Validate Alert Box Message and Click OK
	// Get the updated values from the fields and Store in HashMap
	// Compare Both hashmap , 1st hashMap will have expected value and 2nd will
	// have actual value
	//
	//

	@Test
	public void verifyEditValue() {
		SoftAssert sa = new SoftAssert();
		ProfilePage pp = new ProfilePage(driver);
		MMPHelperClass p = new MMPHelperClass(driver);
		// Login
		p.patientLogin("ria1", "Ria12345",
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		// Navigate To Profile
		p.navigateToModule("Profile");
		// Click on Edit Button
		boolean r = pp.clickEditButton();
		sa.assertTrue(r);
		// int weight = rand.nextInt(70);
		// int age = rand.nextInt(100);
		// int height = rand.nextInt(100);
		// String fName = (char)alphNumb + "TEST";
		// Editing different fields like
		// weight,age,height,firstName,Lastname,License,ssn and storing expected
		// value in HashMap
		
		expectedHMap = pp.editValue(Integer.toString(rand.nextInt(70)), weightID, "weightKey");
		expectedHMap = pp.editValue(Integer.toString(rand.nextInt(10)), heightID, "heightKey");
		expectedHMap = pp.editValue(((char) alphNumb + "FNAME"), firstNameID, "firstNameKey");
		expectedHMap = pp.editValue(((char) alphNumb + "LNAME"), lastNameID, "lastNameKey");
		expectedHMap = pp.editValue("2" + "" + (1000000 + rand.nextInt(9000000)), licenseID, "licenseKey");
		expectedHMap = pp.editValue(Integer.toString(100000000 + rand.nextInt(900000000)), ssnID, "ssnKey");
		expectedHMap = pp.editValue(Integer.toString(rand.nextInt(100)), ageID, "ageKey");
		System.out.println(expectedHMap);
		// Click Save and  Validate Alert Box Message and Click OK
		boolean r1 = pp.verifyUpdateMessage("Your Profile has been updated.");
		sa.assertTrue(r1);
		// Get the updated values from the fields and Store in HashMap
		actualHMap = pp.gettingUpdatedValue(weightID, "weightKey");
		actualHMap = pp.gettingUpdatedValue(ageID, "ageKey");
		actualHMap = pp.gettingUpdatedValue(heightID, "heightKey");
		actualHMap = pp.gettingUpdatedValue(firstNameID, "firstNameKey");
		actualHMap = pp.gettingUpdatedValue(lastNameID, "lastNameKey");
		actualHMap = pp.gettingUpdatedValue(licenseID, "licenseKey");
		actualHMap = pp.gettingUpdatedValue(ssnID, "ssnKey");
		System.out.println(actualHMap);
		// Compare Both hashmap , 1st hashMap will have expected value and 2nd
		// will have actual value
		boolean finalW = pp.verifyUpdatedvalue("weightKey");
		boolean finalA = pp.verifyUpdatedvalue("ageKey");
		boolean finalH = pp.verifyUpdatedvalue("heightKey");
		boolean finalFN = pp.verifyUpdatedvalue("firstNameKey");
		boolean finalLN = pp.verifyUpdatedvalue("lastNameKey");
		boolean finallicense = pp.verifyUpdatedvalue("licenseKey");
		boolean finalssn = pp.verifyUpdatedvalue("ssnKey");
		sa.assertTrue(finalW);
		sa.assertTrue(finalA);
		sa.assertTrue(finalH);
		sa.assertTrue(finalFN);
		sa.assertTrue(finalLN);
		sa.assertTrue(finallicense);
		sa.assertTrue(finalssn);
		sa.assertAll();

	}

}
