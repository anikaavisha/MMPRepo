package org.iit.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchSymptomsPage {
	
	public WebDriver driver;
	String searchSymptomsTab = "//span[contains(text(),'%module%')]";
	By searchSymptomsBox= By.id("search");
	By searchButton = By.name("submit");
	By symptomsValue= By.xpath("//th[contains(.,'Symptoms')]/ancestor::thead/following-sibling::tbody//td[1]");
	
	
	public SearchSymptomsPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public String enterSymptoms( String userSymptoms ){
		//Enter Symptoms
		driver.findElement(searchSymptomsBox).sendKeys(userSymptoms);
		//Click on Search Button
		driver.findElement(searchButton).click();
		return userSymptoms;
	}
		//Verify correct symptoms are displayed
		
		public boolean symptomVerififcation(String userSymptoms){
		String actualSymptom = driver.findElement(symptomsValue).getText();
		Assert.assertEquals(userSymptoms, actualSymptom);
		return true;
		
		
	}
}
	


