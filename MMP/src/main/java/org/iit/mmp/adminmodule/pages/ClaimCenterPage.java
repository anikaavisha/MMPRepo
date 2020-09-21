package org.iit.mmp.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaimCenterPage {

	private WebDriver driver;
	
	private By searchID = By.id("search");
	private By searchButtonXpath = By.xpath("//input[contains(@class,'tfbutton')]");
	//private By nameXpath =By.xpath("//div[@id='show']//tbody/tr/td[1]");
	private By nameXpath =By.xpath("//div[@id='show']//tbody/tr/td/a");
	private By ssnXpath =By.xpath("//div[@id='show']//tbody/tr/td[2]");
	private By ageXpath =By.xpath("//div[@id='show']//tbody/tr/td[3]");
	
	
	
	public ClaimCenterPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	public boolean searchPatient(String ssn){
		driver.findElement(searchID).sendKeys(ssn);
		driver.findElement(searchButtonXpath).click();
		return true;
		}
	
	public HashMap <String,String> patientData(){
		//HashMap Object
		HashMap<String,String> patientFieldValues = new HashMap<String,String>();
		
		//getting values from field
		String firstName = driver.findElement(nameXpath).getText();
		String ssn =driver.findElement(ssnXpath).getText();
		String age = driver.findElement(ageXpath).getText();
		
		//string in HashMap
		patientFieldValues.put("FIrstName", firstName);
		patientFieldValues.put("SSN",ssn);
		patientFieldValues.put("Age",age);
		System.out.println(patientFieldValues);
		return patientFieldValues;
		
	}
	
	public boolean nameClick(){
		driver.findElement(nameXpath).click();
		return true;
	}

}
