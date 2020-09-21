package org.iit.mmp.patientmodule.tests;


import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.FeesPage;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FeesPatient extends BaseClass{
	
//	Login
//	Navigate To fees Tab
//	Click on PayNow Button
//	Select Payment
//	Click On Continue Button
//	Verify Payment displayed on next page is correct
//	Enter All data
	
	@Test
	public void fee() {
		MMPHelperClass lp = new MMPHelperClass(driver);
		FeesPage fp = new FeesPage(driver);
		SoftAssert sa = new SoftAssert();
		//Login
        lp.patientLogin("ria1", "Ria12345",
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
        //Navigate To fee Module
		lp.navigateToModule("Fees");
		//Method-PayNowButton,Select Payment,Continue
		boolean result1 = fp.slectingFee("$50");
		sa.assertTrue(result1);
		//Method - Verify Payment displayed on next page is correct
		boolean result2 = fp.feeVerification("$50");
		sa.assertTrue(result2);
		//Enter All Data
		boolean result3 = fp.patientInfo();
		sa.assertTrue(result3);
		sa.assertAll();

	}

}
