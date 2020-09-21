package org.iit.mmp.patientmodule.tests;



import java.util.HashMap;


import org.iit.mmp.patientmodule.pages.RegisterPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatient extends BaseClass  {
	
	//Open app and Click on Reagister Button
	//Enter random data to all the fields
	//

@Test
public void register(){
	
	RegisterPage newPatient = new RegisterPage(driver);
	//Navigate to registerpage 
	newPatient.navigateToRegisterpage("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	//enter random data
	HashMap<String,String> p= newPatient.patientRegisterData();
	System.out.println(p);
	//Verification of registration
	boolean result = newPatient.registerationVerification();
	System.out.println(result);
	
	
}
}
