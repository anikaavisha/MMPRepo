package org.iit.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogOutPage {
	
	public WebDriver driver;
	String logoutTab = "//span[contains(text(),'%module%')]";
	
	//Logout Constructor
	
	public LogOutPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public boolean Verifylogout(String expectedTitle) throws InterruptedException{
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		return true;
		
	}

}
