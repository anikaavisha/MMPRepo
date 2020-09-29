package org.iit.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.mmp.adminmodule.pages.PatientPage;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.ScheduleApptPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScheduleAppointmentByAdmin extends BaseClass{
	
	//Login Into Admin Module
	//Navigate to Patients tab
	//Enter SSN - 666001238
	//Click on search button
	//Click on patientName
	//Click on create Visit Button
	//Click on Book Appointment
	//Enter Date 
	//Enter Time
	//Click Continue Button
	//Clear Field and write symptoms
	//Click on Submit Button
	//Navigate to Logout tab
	//Login as Patient
	//Make sure Appointment details are displayed on Home Page first row
	//Navigate to schedule appointment page and verify appt details are displayed correctly
@Parameters({"aUrl","aUname","aPwd","ssn","drName","time","sym","pUname","pPwd","pUrl"})	
@Test
public void adminScheduleAppt(String aUrl,String aUname,String aPwd ,String ssn ,String drName ,String time ,String sym ,String pUname ,String pPwd ,String pUrl) throws InterruptedException{
	PatientPage ppObject = new PatientPage(driver);
	UsersPage upObject = new UsersPage(driver);
	MMPHelperClass helperClassObject =new MMPHelperClass(driver);
	ScheduleApptPage sapObject = new ScheduleApptPage(driver);
	HashMap<String,String> expectedHMap = new HashMap<String,String>();
	upObject.adminUrl(aUrl);
	try {
		upObject.adminLogin(aUname, aPwd);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	upObject.navigateToAdminModule("Patients");
	Thread.sleep(10000);
	ppObject.findPatient(ssn);
	Thread.sleep(10000);
	ppObject.createVisit();
	expectedHMap = ppObject.bookAppt(drName,time,sym);
	System.out.println(expectedHMap);
	helperClassObject.patientLogin(pUname, pPwd, pUrl);
	sapObject.verifyapptDetailsHPage(expectedHMap);
	helperClassObject.navigateToModule("Schedule Appointment");
	sapObject.verifyApptDetailsSPage(expectedHMap);
	
	
	}
}
