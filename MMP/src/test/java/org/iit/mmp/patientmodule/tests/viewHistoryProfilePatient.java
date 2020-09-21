package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.ProfileViewHistoryPage;
import org.iit.util.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class viewHistoryProfilePatient extends BaseClass {

	@BeforeMethod
	public void openApp() {
		MMPHelperClass p = new MMPHelperClass(driver);
		p.patientLogin("ria1", "Ria12345",
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		p.navigateToModule("Profile");

	}

	@Test
	public void patientTotalAppt() throws InterruptedException {
		ProfileViewHistoryPage pp = new ProfileViewHistoryPage(driver);
		int totalAppt = pp.totalAppts();
		System.out.println(totalAppt);

	}

	@Test
	public void patientApptDetails() throws InterruptedException {
		ProfileViewHistoryPage p = new ProfileViewHistoryPage(driver);
		String apptDetails = p.patientApptDetailsValidation("yyy", "9/16/2020", "10Am", "Charlie");
		System.out.println(apptDetails);

	}

	@Test
	public void patientPrescription() throws InterruptedException {
		ProfileViewHistoryPage p = new ProfileViewHistoryPage(driver);
		String prescription = p.prescriptionValidation("Folic Acid");
		System.out.println(prescription);

	}

}
