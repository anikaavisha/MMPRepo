package org.iit.mmp.patientmodule.tests;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.util.ApplicationLibraryClass;
import org.iit.util.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenXLSLoginPatient extends BaseClass {

	

	
	@BeforeMethod
		public void openPatienLogin(){
			LoginPage lpObject = new LoginPage(driver);
			lpObject.openApp("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			}

	

	@DataProvider(name = "DP")
	public String[][] calling() throws IOException {
        String Array[][] = ApplicationLibraryClass.readingXlsFile(System.getProperty("user.dir")+"//src//test//resource//TestData//PatientLogin.xls");
		return Array;
	}

	@Test(dataProvider = "DP")
	public void loggingP(String userName, String passwordValue, String expectedText) throws InterruptedException {
		LoginPage p = new LoginPage(driver);
		boolean result = p.patientLoginDD(userName, passwordValue, expectedText);
		System.out.println(result);

	}

	
}
