package org.iit.mmp.patientmodule.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.util.ApplicationLibraryClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DataDrivenXLSXLoginPatient  {
	public WebDriver driver;
	
	/*@BeforeClass
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
	}*/

	@BeforeMethod
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@DataProvider(name = "DP")
	public String[][] gettingdata() throws IOException {
		ApplicationLibraryClass r = new ApplicationLibraryClass();
		String[][] excelD = r.readingXlsxFile("ReadingXLSXFile.xlsx");
		return excelD;

	}

	@Test(dataProvider = "DP")
	public void loggingP(String userName, String passwordValue, String expectedText) throws InterruptedException {
	LoginPage p = new LoginPage(driver);
	boolean result = p.patientLoginDD(userName, passwordValue, expectedText);
	System.out.println(result);

	}
	
	@AfterMethod
	public void closeApp(){
		driver.close();
	}

	
}
