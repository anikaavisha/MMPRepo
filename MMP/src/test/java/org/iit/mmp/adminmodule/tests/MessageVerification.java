package org.iit.mmp.adminmodule.tests;

import org.iit.mmp.adminmodule.pages.AdminMessagesPage;
import org.iit.mmp.adminmodule.pages.UsersPage;
import org.iit.mmp.helper.MMPHelperClass;
import org.iit.mmp.patientmodule.pages.MessagesPage;
import org.iit.mmp.patientmodule.pages.MessagesPage;
import org.iit.util.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MessageVerification extends BaseClass{
	
	//Login into patient Module
	//Naviagte to Messsage Tab
	//Write down Contact Reason and Subject and Click on Send
	//Verify message sent successfully and click ok
	//Log into Admin Module
	//Navigate to Message tab
	// Verify Message is displayed in first row.
	@Parameters({"pUname" , "pPwd" , "pUrl","contactReason","message","aUname","aPwd"})
	@Test
	public void messageDisplayedinAdmin(String pUname , String pPwd ,String pUrl , String contactReason,String message,String aUname,String aPwd ){
		MMPHelperClass helperObject = new MMPHelperClass(driver);
		MessagesPage messagesPageObject = new MessagesPage(driver);
		UsersPage userPageObject = new UsersPage(driver);
		AdminMessagesPage amessagePageObject = new AdminMessagesPage(driver);
		helperObject.patientLogin(pUname, pPwd,pUrl);
		helperObject.navigateToModule("Messages");
		messagesPageObject.sendMessage(contactReason, message);
		messagesPageObject.messageValidation("Messages Successfully sent.");
		helperObject.navigateToModule("Logout");
		try {
			userPageObject.adminLogin(aUname, aPwd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		userPageObject.navigateToAdminModule("Messages");
		amessagePageObject.verifyMessage(contactReason, message);
		
		
		
		
		
		
	}
	

}
