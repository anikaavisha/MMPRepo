package org.iit.mmp.patientmodule.tests;


import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.MessagesPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MessageValidationPatient extends BaseClass{
	
//	Login
//	Navigate to Messages tab
//	Fill Contact Info and Message and Send
//	Verify Message Sent Successful message
	
	@Test
	public void messageVerification(){
	SoftAssert sa = new SoftAssert();
    MMPHelperClass p = new MMPHelperClass(driver);
    MessagesPage mp = new MessagesPage(driver);
    //logging into application
	p.patientLogin("ria1", "Ria12345","http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	//Navigate to Messages
	p.navigateToModule("Messages");
	//Fill Contact Info and Message and Send
	boolean result = mp.sendMessage("Not Feeling Good", "want To book appointment");
	sa.assertTrue(result);
	//validate message sent successfully
	result= mp.messageValidation("Messages Successfully sent.");
	sa.assertTrue(result);
	sa.assertAll();
	
	
		
	}

}

