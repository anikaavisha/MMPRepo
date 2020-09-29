package org.iit.mmp.adminmodule.tests;
import org.iit.mmp.adminmodule.pages.PatientPage;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.ProfileViewHistoryPage;
import org.iit.mmp.patientmodule.tests.viewHistoryProfilePatient;
import org.iit.util.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PrescriptionVerification extends BaseClass {
	//Login into Admin Module
	//Navigate to Patient tab
	//Search for Patient by SSN
	//Click on patientName
	//Click on Add Prsecription
    //Select Appointment 
	//Enter prescription Name
	//Enter prescription description
	//Click on Submit
	//Verify Message "Prescription has been Added." 
	//Click ok
	//Login into Patient Module
	//Navigate to profile
	//Click on View History
	//Click on Past Prescription
	//Verify Prescription is added 
	@Parameters({"aUrl","aUname","aPwd","ssn","apptDate","presName","presDes","pUname","pPwd","pUrl"})
	@Test
	public void presriptionVerifcation(String aUrl, String aUname , String aPwd , String ssn, String apptDate ,String presName, String presDes,String pUname, String pPwd, String pUrl) throws InterruptedException{
		UsersPage upObject = new UsersPage(driver);
		PatientPage ppObject = new PatientPage(driver);
		MMPHelperClass helperObject = new MMPHelperClass(driver);
		ProfileViewHistoryPage historyObject = new ProfileViewHistoryPage(driver);
		//Entering Url in Browser
		upObject.adminUrl(aUrl);
		//Login into  Admin Module
		upObject.adminLogin(aUname,aPwd);
		//navigate to Patient Module
		upObject.navigateToAdminModule("Patients");
		//Finding Patient and clicking on Name
		ppObject.findPatient(ssn);
		//Adding Prescription
		Thread.sleep(10000);
		ppObject.addPresciption(apptDate,presName,presDes);
		//Verify Prescription is added
		ppObject.verifyPres();
		//Login into patient
		helperObject.patientLogin(pUname, pPwd,pUrl);
		//Navigate To profile page
		helperObject.navigateToModule("Profile");
		//verify pescription added in Admin Module is added in Patient Module Past Presription 
		historyObject.adminPresVerify(apptDate,presName,presDes);
		
		
		
		
		
		
	}
	
	

}
