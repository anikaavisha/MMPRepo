package org.iit.mmp.patientmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MessagesPage {
	public WebDriver driver;
	//String messagesTab = "//span[contains(text(),'%module%')]";
	By contactReasonID =By.id("subject");
	By subjectID = By.id("message");
	By sendButtonXpath = By.xpath("//input[@value='Send']");
	
	public MessagesPage(WebDriver driver){
		this.driver = driver;
		}
	
	//Fill Contact Info and Message and Send
    public boolean sendMessage(String contactReason,String message){

		driver.findElement(contactReasonID).sendKeys(contactReason);
		driver.findElement(subjectID).sendKeys(message);
		driver.findElement(sendButtonXpath).submit();
		return true;
		
	}
   //Verify Message Sent Successful message
	public boolean messageValidation(String expectedMessage){
		Alert mssg = driver.switchTo().alert();
		String actualMessage= mssg.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		mssg.accept();
		return true;
		
	}

}
