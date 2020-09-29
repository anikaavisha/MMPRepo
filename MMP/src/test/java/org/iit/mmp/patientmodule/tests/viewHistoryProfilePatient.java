package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.ProfileViewHistoryPage;
import org.iit.util.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class viewHistoryProfilePatient extends BaseClass {
    //Open Patient Module
	//Navigate to patient Profile
	@BeforeMethod
	public void openApp() {
		MMPHelperClass p = new MMPHelperClass(driver);
		p.patientLogin("XTESTX4912", "XTest!123456",
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		p.navigateToModule("Profile");

	}
    //Calling method to verify total appt 
	
	@Test
	public void patientTotalAppt() throws InterruptedException {
		ProfileViewHistoryPage pp = new ProfileViewHistoryPage(driver);
		int totalAppt = pp.totalAppts();
		System.out.println(totalAppt);

	}
    //Calling Method to verify past appt
	@Test
	public void patientApptDetails() throws InterruptedException {
		ProfileViewHistoryPage p = new ProfileViewHistoryPage(driver);
		String apptDetails = p.patientApptDetailsValidation("Not Good", "9/15/2021", "12Pm", "Beth");
		System.out.println(apptDetails);

	}
    //Method to verify past prescription
	@Test
	public void patientPrescription() throws InterruptedException {
		ProfileViewHistoryPage p = new ProfileViewHistoryPage(driver);
		String prescription = p.prescriptionValidation("Folic Acid");
		System.out.println(prescription);

	}

}
