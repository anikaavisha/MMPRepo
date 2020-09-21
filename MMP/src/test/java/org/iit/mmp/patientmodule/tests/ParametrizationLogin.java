package org.iit.mmp.patientmodule.tests;

import java.util.concurrent.TimeUnit;

import org.iit.mmp.patientmodule.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametrizationLogin {
	public WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Parameters({"userName","passwordValue","expectedText"})
	@Test
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
