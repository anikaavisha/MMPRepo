package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.InformationPage;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.util.ApplicationLibraryClass;
import org.iit.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InformationVerification extends BaseClass {

	// Login
	// Click on information tab
	// Get actual text
	// Store Expected Text in text file
	// Read it by fileReadermethod
	// Compare with Actual text
	@Test
	public void verifyInfo() {
		MMPHelperClass lin = new MMPHelperClass(driver);
		InformationPage ip = new InformationPage(driver);
		lin.patientLogin("ria1", "Ria12345",
				"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		lin.navigateToModule("Information");
		String actualText = ip.actualTextMethod();
		System.out.println("Actual Text:: "+ actualText);
		String expectedText = ApplicationLibraryClass.readingTextFile(
				System.getProperty("user.dir")+"\\src\\test\\resource\\TestData\\InformationTextPatientModule.txt");
		System.out.println("Expected Text:: "+expectedText);
		Assert.assertEquals(actualText.trim(), expectedText.trim());

	}
}
