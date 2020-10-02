package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.util.BaseClass;
import org.iit.util.DataBaseTesting;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataBaseTesting extends BaseClass{
	
	@DataProvider (name ="DP")
	public String[][] feedDP() throws Exception{
	DataBaseTesting dbObject = new DataBaseTesting();
	String data[][] = dbObject.feedDP();
	return data;
	}
	
	@BeforeMethod
	public void openApp(){
		LoginPage lpObject = new LoginPage(driver);
		lpObject.openApp("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
	}
	
	@Test(dataProvider ="DP")
	public void verifyLogin(String userName , String passwordValue ,String expectedText) throws InterruptedException{
		LoginPage lpObject = new LoginPage(driver);
		lpObject.patientLoginDD(userName, passwordValue, expectedText);
		
	}
	
	
	
}
