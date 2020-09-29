package org.iit.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AdminMessagesPage {
	private WebDriver driver;
	private By contactReasonXpath = By.xpath("//table[@class='table']//tbody/tr[2]/td[2]");
	private By subjectXpath =By.xpath("//table[@class='table']//tbody/tr[3]/td[2]");
	
	public AdminMessagesPage(WebDriver driver){
		this.driver = driver;
		
	}
	public boolean verifyMessage(String patientModuleReason, String patientModuleSubject){
		SoftAssert sa = new SoftAssert();
		String contactReason = driver.findElement(contactReasonXpath).getText();
		String subject = driver.findElement(subjectXpath).getText();
		sa.assertEquals(contactReason,patientModuleReason );
		sa.assertEquals(subject, patientModuleSubject);
		sa.assertAll();
		return true;
		}
	

}
