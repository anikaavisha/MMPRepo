package org.iit.mmp.patientmodule.tests;


import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.SearchSymptomsPage;
import org.iit.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSymptomPatient extends BaseClass{
//	Login
//	Navigate to Symptoms Page
//	Enter Symptoms
//	Veirfy Symptoms
	
	@Test
	public void patientSymptoms(){
		MMPHelperClass lp = new MMPHelperClass(driver);
		SearchSymptomsPage p = new SearchSymptomsPage(driver);
		//Login
		lp.patientLogin("XTESTX4912","XTest!123456","http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//Navigate to Symptom page 
		lp.navigateToModule("Search Symptoms");
		//Enter Symptom
		String symptom = p.enterSymptoms("fever");
		//Verify Symptom displayed correctly
		boolean result= p.symptomVerififcation(symptom);
		Assert.assertTrue(result);
		
	}

}
