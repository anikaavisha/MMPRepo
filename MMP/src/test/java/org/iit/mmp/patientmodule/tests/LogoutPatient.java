package org.iit.mmp.patientmodule.tests;


import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.LogOutPage;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutPatient extends BaseClass{
	
//	Login
//	Navigate to logout and Click
//	Veriy Page Title after Logout
	
	@Test
	public void logoutVerification() throws InterruptedException{
		MMPHelperClass lp = new MMPHelperClass(driver);
		LogOutPage logP = new LogOutPage(driver);
		
		//Login
		lp.patientLogin("ria1","Ria12345","http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//Navigate To logout and Click
		lp.navigateToModule("Logout");
		//Verify Pagetitle is correct after Logout
		boolean result= logP.Verifylogout("NAMTG");
		Assert.assertTrue(result);
		
	}
	
	

}
