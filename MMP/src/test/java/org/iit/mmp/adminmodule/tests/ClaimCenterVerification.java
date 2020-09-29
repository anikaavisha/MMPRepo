package org.iit.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.mmp.adminmodule.pages.ClaimCenterPage;
import org.iit.mmp.adminmodule.pages.SubmitAClaimPage;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.ProfilePage;
import org.iit.util.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClaimCenterVerification extends BaseClass {
	// Login into patient Module
	// Navigate To Profile Page
	// Get SSN Of patient
	// Logout of Patient Module
	// Login into Admin module
	// Navigate to Claim Center
	// Search For Patient with SSN
	// Verify Patient content matches with Patient Module Profile page
	// If Content matches - Click on patient Name to navigate to patient record
	// Fill up the claim information
	@Parameters({ "pUname", "pPwd", "pUrl", "aUname", "aPwd", "drName", "modifierCode", "icdCode", "cptCode",
			"insuranceCompany" })
	@Test
	public void patientClaim(String pUname, String pPwd, String pUrl, String aUname, String aPwd, String drName,
			int modifierCode, int icdCode, int cptCode, String insuranceCompany) throws InterruptedException {
		// Creating Objects to Use Methods
		HashMap<String, String> expectedHashMap = new HashMap<String, String>();
		HashMap<String, String> actualHasMap = new HashMap<String, String>();
		MMPHelperClass helperObject = new MMPHelperClass(driver);
		ClaimCenterPage claimCenterObject = new ClaimCenterPage(driver);
		ProfilePage profilePageObject = new ProfilePage(driver);
		UsersPage usersPageObject = new UsersPage(driver);
		SubmitAClaimPage submitAClaimPageObject = new SubmitAClaimPage(driver);

		// Logging into Patient Module
		helperObject.patientLogin(pUname, pPwd, pUrl);
		// Navigating to profile tab
		helperObject.navigateToModule("Profile");
		// Getting Patient SSN
		String patientSSN = profilePageObject.getSSN();
		// Storing Patient Name,SSN,age in HashMap
		expectedHashMap = profilePageObject.patientData();
		// creating javascriptexecutor object for scrolling up,so Logout tab is
		// visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-3000)");
		// navigating to logout, to logout from Patient module
		helperObject.navigateToModule("Logout");
		// Logging into admin module
		usersPageObject.adminLogin(aUname, aPwd);
		// Navigating to Claim Center tab
		usersPageObject.navigateToAdminModule("Claim Center");
		Thread.sleep(10000);
		// Search for patient by using patient ssn
		claimCenterObject.searchPatient(patientSSN);
		// store Patient Name,ssn,age in HashMap
		actualHasMap = claimCenterObject.patientData();
		// Compare both HashMap to verify data is same on Patient Module and
		// Admin module
		Assert.assertEquals(actualHasMap, expectedHashMap);
		// Navigating to Patient submit claim page by clicking on patient Name
		claimCenterObject.nameClick();
		// Submit a Claim
		submitAClaimPageObject.claimDetails(drName, modifierCode, icdCode, cptCode, insuranceCompany);
	}
}
