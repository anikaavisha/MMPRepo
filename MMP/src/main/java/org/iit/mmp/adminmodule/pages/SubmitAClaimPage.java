package org.iit.mmp.adminmodule.pages;

import java.util.Random;

import org.iit.util.ApplicationLibraryClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SubmitAClaimPage {
	private WebDriver driver;
	private By firstNameName = By.name("fname");
	private By lastnameName = By.name("lname");
	private By middleNameName = By.name("mname");
	private By dateOfBirthName = By.name("dob");
	private By maleXpath = By.xpath("//input[@name='gender'][1]");
	private By femaleXpath = By.xpath("//input[@name='gender'][2]");
	private By employedXpath = By.xpath("//input[@id='worksts']");
	private By unemployedXpath = By.xpath("//input[@name='worksts']");
	private By insurancepolicyXpath = By.id("license");
	private By selectDoctorID = By.id("doc");
	private By dateOfServiceID = By.id("dos");
	private By planOfServiceID = By.id("pser");
	private By selectModifierCode = By.id("mcode");
	private By npiCodeName = By.name("npi");
	private By selectICDCodeID = By.id("dia");
	private By selectCPTCodeID =By.name("procedurecode");
	private By balanceID = By.id("bal");
	private By insuranceCompanyID = By.name("insname");
	private By checkboxID = By.id("ch");
	private By submitClaimXpath = By.xpath("//input[@type='submit']");
	private By resetXpath = By.xpath("//input[@type='reset']");
	private By cancelXpath = By.xpath("//input[@type='button']");
	

	public SubmitAClaimPage (WebDriver driver){
		this.driver = driver;
		}
	
	public boolean claimDetails(String referringDR  ,int modiferCode, int icdCode ,int cptCode,String insuranceCompany) throws InterruptedException{
		
		Random random = new Random();
		int alphNumb = 65 + random.nextInt(26);
		//Patient first Name will be autopopulated
		String firstN =driver.findElement(firstNameName).getAttribute("value");
		System.out.println(firstN);
		//Patient last name will be auto populated
		String lastN = driver.findElement(lastnameName).getAttribute("value");
		System.out.println(lastN);
		driver.findElement(middleNameName).sendKeys((char)alphNumb+"middlename"+(char)alphNumb);
		driver.findElement(dateOfBirthName).getAttribute("value");
		driver.findElement(femaleXpath).click();
		Thread.sleep(10000);
		driver.findElement(employedXpath).click();
		driver.findElement(insurancepolicyXpath).sendKeys(Integer.toString(250+random.nextInt(100000)));
		Select doctor = new Select(driver.findElement(selectDoctorID));
		doctor.selectByVisibleText(referringDR);
		String pastDate = ApplicationLibraryClass.pastDate();
		driver.findElement(dateOfServiceID).sendKeys(pastDate);
		driver.findElement(planOfServiceID).sendKeys((char)alphNumb + "PLAN");
	    Select select = new Select(driver.findElement(selectModifierCode));
	    select.selectByVisibleText(Integer.toString(modiferCode));
	    Select select1 = new Select(driver.findElement(selectICDCodeID));
	    select1.selectByVisibleText(Integer.toString(icdCode));
	    Thread.sleep(10000);
	    Select select2 = new Select(driver.findElement(selectCPTCodeID));
	    select2.selectByIndex(2);
	    driver.findElement(balanceID).sendKeys(Integer.toString(100+random.nextInt(800)));
	    Select select3 = new Select(driver.findElement(insuranceCompanyID));
	    select3.selectByVisibleText(insuranceCompany);
	    driver.findElement(checkboxID).click();
	    driver.findElement(submitClaimXpath).click();
	    String text = driver.findElement(By.xpath("(//br)[1]/following-sibling::br")).getText();
	    System.out.println(text);
	    return true;
		
	}
	
	
	
	

}
