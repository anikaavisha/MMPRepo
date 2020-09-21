package org.iit.mmp.patientmodule.tests;


import java.util.HashMap;

import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.ScheduleApptPage;
import org.iit.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleApptPatient extends BaseClass{
//	Login
//	Navigate to Schedule Appt
//	Book Appt and store Appt data in hashmap
//	Verify Appt Details in the First Row of Appt table on home page
//	Verify Appt Deatils on Schedule AApt Page
	
	@Test
	public void bookingAppt() throws InterruptedException{
	SoftAssert sa = new SoftAssert();
	MMPHelperClass lp =new MMPHelperClass(driver);
	ScheduleApptPage sap = new  ScheduleApptPage(driver);
	//Login
	lp.patientLogin("ria1","Ria12345","http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	//Navigate to Schedule Appt page
	lp.navigateToModule("Schedule Appointment");
	//BOOK Appt and Store data in HashMap
	HashMap<String,String> h= sap.bookAppt("Beth", "September/15/2020", "12Pm", "Not Good");
	System.out.println(h);
	//Verify Appt Details on Home Page
	boolean result= sap.verifyapptDetailsHPage(h);
	sa.assertTrue(result);
	//Verify Appt Details on Schedule Appt page
	boolean result1 = sap.verifyApptDetailsSPage(h);
	sa.assertTrue(result1);

}
}
