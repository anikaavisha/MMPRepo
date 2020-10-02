package org.iit.mmp.adminmodule.tests;

import java.awt.AWTException;

import org.iit.mmp.adminmodule.pages.PatientPage;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Test;

public class ReportsTest extends BaseClass{
	
@Test
public void reportVerification() throws InterruptedException, AWTException{
	UsersPage upObject = new UsersPage(driver);
	PatientPage ppObject = new PatientPage(driver);
	upObject.adminUrl("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
	upObject.adminLogin("Thomas_444", "Edison_444");
	upObject.navigateToAdminModule("Patients");
	ppObject.findPatient("162423545");
	ppObject.addReport("06/15/2019");
	}
}
