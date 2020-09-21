package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPage {
	public WebDriver driver;
	
    String patientName;
   
    
    By firstNameID = By.id("firstname");
	By lastNameID = By.id("lastname");
	By licenseID = By.id("license");
	By ssnID = By.id("ssn");
	By stateID = By.id("state");
	By cityID = By.id("city");
	By addressID = By.id("address");
	By zipcodeID = By.id("zipcode");
	By ageID = By.id("age");
	By heightID = By.id("height");
	By weightID = By.id("weight");
	By pharmacyID = By.id("pharmacy");
	By pharmacyAddressID = By.id("pharma_adress");
	By emailID = By.id("email");
	By usernameID = By.id("username");
	By passwordID = By.id("password");
	By confirmPasswordID = By.id("confirmpassword");
	By securityID = By.id("security");
	By answerID = By.id("answer");
	By saveButton = By.name("register");
	By registerButtonXpath =By.xpath("//input[@value='Register']");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method- To Login into Patient login page and click on Register Button
	
	public boolean navigateToRegisterpage(String url){
		driver.get(url);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(registerButtonXpath).click();
		return true;
		}

	//Method - For Registering New patient and click on save Button and Returns HahMap which has all new patient data
	
	public HashMap<String, String> patientRegisterData() {
		Random n = new Random();
		int alphNumb = 65 + n.nextInt(26);
//		//to generate 9 digits random number
//		int ssnValue = 100000000 + n.nextInt(900000000);
//		//to generate 8 digits random number that starts with 2
//		String licenseValue = "2" + "" + (1000000 + n.nextInt(9000000));
//		//to generate 5 digit random number
//		int zipCode = 10000 + n.nextInt(90000);
//		//to generate age between 10 and 114
//		int ageValue = 10 + n.nextInt(95);
//		//to generate random number between 30 and 229.Height is in cms
//		int heightValue = 30 +n.nextInt(200);
//		//to generate random number between 5 to 74
//		int weightValue = 5 + n.nextInt(70);
//		//to generate random number between 65 and 90
	    
//		String firstName = (char) alphNumb + "TEST" + (char) alphNumb;
//		String lastName = "TEST" + (char) alphNumb + "" + (char) alphNumb;
//		String stateValue = "TEST" + (char) alphNumb;
//		String cityValue = (char) alphNumb + "TEST" + (char) alphNumb + (char) alphNumb;
//		String addressValue = n.nextInt(200) + " TEST Drive";
//		String pharmacyName = "TEST" + (char) alphNumb + " Pharmacy";
//		String pharmacyAddress = n.nextInt(200) + " Madision Drive";
//		String emailAddress = (char) alphNumb +n.nextInt(100)+"!"+"@hotmail.com";
//		String userName = (char) alphNumb + "TEST" +(char) alphNumb+ n.nextInt(10000);
//		String passwordValue = (char) alphNumb + "a!" + n.nextInt(1000000);
//		String securityAns = (char) alphNumb + "TEST";
		HashMap<String, String> patientHashMap = new HashMap<String, String>();
		
		
		WebElement fNameLocator= driver.findElement(firstNameID);
		fNameLocator.clear();
		String firstName = (char) alphNumb + "TEST" + (char) alphNumb;
		fNameLocator.sendKeys(firstName);
		patientHashMap.put("FirstName", fNameLocator.getAttribute("value"));
		
		WebElement lastNameLocator= driver.findElement(lastNameID);
	    lastNameLocator.clear();
		String lastName="TEST" + (char) alphNumb + "" + (char) alphNumb;
		lastNameLocator.sendKeys(lastName);
		patientHashMap.put("LastName", lastNameLocator.getAttribute("value"));
		
		WebElement licenseLocator = driver.findElement(licenseID);
	    licenseLocator.clear();
		String licenseValue= "2" + "" + (1000000 + n.nextInt(9000000));
		licenseLocator.sendKeys(licenseValue);
		patientHashMap.put("License", licenseLocator.getAttribute("value"));
		
		WebElement ssnLocator = driver.findElement(ssnID);
		ssnLocator.clear();
		ssnLocator.sendKeys(Integer.toString(100000000 + n.nextInt(900000000)));
		patientHashMap.put("SSN", ssnLocator.getAttribute("value"));
		
		WebElement stateLocator = driver.findElement(stateID);
        stateLocator.clear();
		stateLocator.sendKeys("TEST" + (char) alphNumb);
		patientHashMap.put("State", stateLocator.getAttribute("value"));
		
		WebElement cityLocator = driver.findElement(cityID);
		cityLocator.clear();
		cityLocator.sendKeys((char) alphNumb + "TEST" + (char) alphNumb + (char) alphNumb);
		patientHashMap.put("City", cityLocator.getAttribute("value"));
		
		WebElement addressLocator = driver.findElement(addressID);
		addressLocator.clear();
		addressLocator.sendKeys(n.nextInt(200) + " TEST Drive");
		patientHashMap.put("PatientAddress", addressLocator.getAttribute("value"));
		
		
		WebElement zipcodeLocator =driver.findElement(zipcodeID);
		zipcodeLocator.clear();
		zipcodeLocator.sendKeys(Integer.toString(10000 + n.nextInt(90000)));
		patientHashMap.put("Zipcode", zipcodeLocator.getAttribute("value"));
		
		
		WebElement ageLocator = driver.findElement(ageID);
		ageLocator.clear();
		ageLocator.sendKeys(Integer.toString(10 + n.nextInt(65)));
		patientHashMap.put("Age", ageLocator.getAttribute("value"));
		
		WebElement heightLocator = driver.findElement(heightID);
		heightLocator.clear();
		heightLocator.sendKeys(Integer.toString(n.nextInt(200)));
		patientHashMap.put("Height", heightLocator.getAttribute("value"));
		
		
		WebElement weightLocator = driver.findElement(weightID);
		weightLocator.clear();
		driver.findElement(weightID).sendKeys(Integer.toString(5 + n.nextInt(70)));
		patientHashMap.put("Weight", weightLocator.getAttribute("value"));
		
		WebElement pharmacyNameLocator = driver.findElement(pharmacyID);
		pharmacyNameLocator.clear();
		pharmacyNameLocator.sendKeys("TEST" + (char) alphNumb + " Pharmacy");
		patientHashMap.put("Pharmacy", pharmacyNameLocator.getAttribute("value"));
		
		WebElement pharmacyAddressLocator = driver.findElement(pharmacyAddressID);
		pharmacyAddressLocator.clear();
		pharmacyAddressLocator.sendKeys( n.nextInt(20000) + " Madision Drive");
		patientHashMap.put("PharmacyAddress", pharmacyAddressLocator.getAttribute("value"));
		
		WebElement emailLocator = driver.findElement(emailID);
		emailLocator.clear();
		emailLocator.sendKeys((char)alphNumb +n.nextInt(100000)+"Test!"+"@hotmail.com");
		patientHashMap.put("EmailAddress", emailLocator.getAttribute("value"));
		
		WebElement userNameLocator =driver.findElement(usernameID);
		userNameLocator	.clear();
		userNameLocator.sendKeys((char) alphNumb + "TEST" +(char) alphNumb+ n.nextInt(10000));
		patientHashMap.put("UserName", userNameLocator.getAttribute("value"));
		
		
		WebElement passwordLocator = driver.findElement(passwordID);
		passwordLocator.clear();
		passwordLocator.sendKeys((char)alphNumb+"Test!"+"123456");
		patientHashMap.put("Password", passwordLocator.getAttribute("value"));
		
		WebElement confirmPasswordLocator = driver.findElement(confirmPasswordID);
		confirmPasswordLocator.clear();
		confirmPasswordLocator.sendKeys((char)alphNumb+"Test!"+"123456");
		patientHashMap.put("ConfirmPassword", confirmPasswordLocator.getAttribute("value"));
		
		Select selectQ = new Select(driver.findElement(securityID));
		selectQ.selectByIndex(2);
		WebElement secAnsLocator = driver.findElement(answerID);
		secAnsLocator.clear();
		secAnsLocator.sendKeys((char) alphNumb + "TEST");
		patientHashMap.put("SecurityQuestionAns", secAnsLocator.getAttribute("value"));
		//Click on Save Button
		driver.findElement(saveButton).click();
		
		return patientHashMap;
		}
		
	
	//Method - To Verify New patient Registration	
	
	public boolean registerationVerification(){
		//Registration verification
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Thank you for registering with MMP. ";
		Assert.assertEquals(actualText, expectedText);
		alert.accept();
		return true;
		}
	
	
	
	//Method to Register New patient and returns Patient SSN, Name, UserName,Pwd
	
	public String newPatientInfo(){
		
		Random n = new Random();
		int alphNumb = 65 + n.nextInt(26);
		
		//Entering random FirstName and this method will return Firstname
		WebElement fNameLocator= driver.findElement(firstNameID);
		fNameLocator.clear();
		String firstName = (char) alphNumb + "TEST" + (char) alphNumb;
		fNameLocator.sendKeys(firstName);
	    patientName = fNameLocator.getAttribute("value");
		
		
		//LastName
		WebElement lastNameLocator= driver.findElement(lastNameID);
	    lastNameLocator.clear();
		String lastName="TEST" + (char) alphNumb + "" + (char) alphNumb;
		lastNameLocator.sendKeys(lastName);
		
		//License
		WebElement licenseLocator = driver.findElement(licenseID);
	    licenseLocator.clear();
		String licenseValue= "2" + "" + (1000000 + n.nextInt(9000000));
		licenseLocator.sendKeys(licenseValue);
		
		//SSN . Returning patient SSN
		WebElement ssnLocator = driver.findElement(ssnID);
		ssnLocator.clear();
		ssnLocator.sendKeys(Integer.toString(100000000 + n.nextInt(900000000)));
		String patientSSN = ssnLocator.getAttribute("value");
		
		//state
		WebElement stateLocator = driver.findElement(stateID);
        stateLocator.clear();
		stateLocator.sendKeys("TEST" + (char) alphNumb);
		
		//city
		WebElement cityLocator = driver.findElement(cityID);
		cityLocator.clear();
		cityLocator.sendKeys((char) alphNumb + "TEST" + (char) alphNumb + (char) alphNumb);
		
		//address
		WebElement addressLocator = driver.findElement(addressID);
		addressLocator.clear();
		addressLocator.sendKeys(n.nextInt(200) + " TEST Drive");
		
		
		//zip
		WebElement zipcodeLocator =driver.findElement(zipcodeID);
		zipcodeLocator.clear();
		zipcodeLocator.sendKeys(Integer.toString(10000 + n.nextInt(90000)));
		
		//age
		WebElement ageLocator = driver.findElement(ageID);
		ageLocator.clear();
		ageLocator.sendKeys(Integer.toString(10 + n.nextInt(65)));
		
		//height
		WebElement heightLocator = driver.findElement(heightID);
		heightLocator.clear();
		heightLocator.sendKeys(Integer.toString(n.nextInt(200)));
		
		
		//weight
		WebElement weightLocator = driver.findElement(weightID);
		weightLocator.clear();
		driver.findElement(weightID).sendKeys(Integer.toString(5 + n.nextInt(70)));
		
		//pharmacy name
		WebElement pharmacyNameLocator = driver.findElement(pharmacyID);
		pharmacyNameLocator.clear();
		pharmacyNameLocator.sendKeys("TEST" + (char) alphNumb + " Pharmacy");
		
		//pharmacy address
		WebElement pharmacyAddressLocator = driver.findElement(pharmacyAddressID);
		pharmacyAddressLocator.clear();
		pharmacyAddressLocator.sendKeys( n.nextInt(20000) + " Madision Drive");
		
		//patient email
		WebElement emailLocator = driver.findElement(emailID);
		emailLocator.clear();
		emailLocator.sendKeys((char)alphNumb +n.nextInt(100000)+"Test!"+"@hotmail.com");
		
		//patient username . This method return patient username
		WebElement userNameLocator =driver.findElement(usernameID);
		userNameLocator	.clear();
		userNameLocator.sendKeys((char) alphNumb + "TEST" +(char) alphNumb+ n.nextInt(10000));
		String patientUserName = userNameLocator.getAttribute("value");
		
		//patient password. this method returns patient password
		WebElement passwordLocator = driver.findElement(passwordID);
		passwordLocator.clear();
		passwordLocator.sendKeys((char)alphNumb+"Test!"+"123456");
		String patientPwd= passwordLocator.getAttribute("value");
		
		//confirm pwd
		WebElement confirmPasswordLocator = driver.findElement(confirmPasswordID);
		confirmPasswordLocator.clear();
		confirmPasswordLocator.sendKeys((char)alphNumb+"Test!"+"123456");
		
		//security question
		Select selectQ = new Select(driver.findElement(securityID));
		selectQ.selectByIndex(2);
		WebElement secAnsLocator = driver.findElement(answerID);
		secAnsLocator.clear();
		secAnsLocator.sendKeys((char) alphNumb + "TEST");
		
		
		//this method will return patient name, patient ssn, patient username, patient pwd
		
		return (""+patientSSN+":"+patientName+":"+patientUserName+":"+patientPwd+"");
		
		}
	
	
// Method - To click on save button once registration is completed
	public boolean SaveButton(){
		driver.findElement(saveButton).click();
		return true;
		
	}


}
