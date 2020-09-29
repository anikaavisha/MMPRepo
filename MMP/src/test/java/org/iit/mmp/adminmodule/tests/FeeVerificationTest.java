package org.iit.mmp.adminmodule.tests;

import org.iit.mmp.adminmodule.pages.PatientPage;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.FeesPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FeeVerificationTest extends BaseClass {
	// Log into Admin Module
	// Navigate To Patient Tab
	// Search for patient by ssn and click on Name
	// Click On Create Fee Button
	// Select Appointment from Dropdown
	// Select Service from Dropdown
	// Verify Correct Fee is displayed
	// Click on Submit
	// Alert Box will be displayed.Verify Message "Fee Successfully Entered. "
	// and click ok
	// Login into Patient Module
	// Navigate to fees tab
	// Verify fee entered above(By Admin) is added
    @Parameters({"aUrl","aUname","aPwd","ssn","apptDate","service","fees","pUname","pPwd","pUrl"})
	@Test(description="verification of fees entered by admin is added in patient module")
	public void feeVerification(String aUrl,String aUname,String aPwd, String ssn, String apptDate ,String service , String fees, String pUname, String pPwd , String pUrl) throws InterruptedException{
		UsersPage upObject = new UsersPage(driver);
		PatientPage ppObject = new PatientPage(driver);
		MMPHelperClass helperObject = new MMPHelperClass(driver);
		FeesPage feeObject = new FeesPage(driver);
		
		//Login into Admin Module
		upObject.adminUrl(aUrl);
		upObject.adminLogin(aUname,aPwd);
		//Navigate to Patients tab
		upObject.navigateToAdminModule("Patients");
		ppObject.findPatient(ssn);
		//Adding Fees and Submit
		ppObject.addFees(apptDate,service,fees);
		//Verify Meesage "Fee Successfully Entered. "
		ppObject.feeMsgVerification();
		//Login into patient Module
		helperObject.patientLogin(pUname, pPwd,pUrl);
		//Navigate to Fees module 
		helperObject.navigateToModule("Fees");
		//Entry is added in Your Outstanding fees row
		feeObject.feeRowVerify(service,apptDate);
		
		
		}

}
