package org.iit.mmp.adminmodule.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.iit.util.ApplicationLibraryClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PatientPage {
	private WebDriver driver;
	By ssnID = By.id("search");
	By searchButtonXpath = By.xpath("//input[@class='tfbutton']");
	By nameXpath = By.xpath("//div[@id='show']//tbody/tr//a");
	By createVisitXpath = By.xpath("//p[1]//a[1]//input[1]");
	String bookApptButton = "//h4[contains(text(),'%drName%')]/ancestor::ul/following-sibling::button[@id='opener']";
	By dateID = By.id("datepicker");
	By timeID = By.id("time");
	By continueButtonID = By.id("ChangeHeatName");
	By symptomsName = By.name("sym");
	By submitButtonXpath = By.xpath("//form[@name='symptoms']//div//input");
	By addPrescriptioButtonXpath = By.xpath("//input[@value='Add Precription']");
	By selectApptID = By.id("app_date");
	By prescriptionNameName = By.name("p_name");
	By prescriptionDescriptionName = By.name("p_desc");
	By pressubmitButtonXpath = By.xpath("//input[@type='submit']");
	By createFeeXpath = By.xpath("//input[@value='Create Fee']");
	By serviceID = By.id("service");
	By feeXpath = By.xpath("//div[@id='show']//input[@class='form-control']");
	By feesSubmitXpath = By.xpath("//input[@type='submit']");
	By reportXpath = By.xpath("//input[@value='Reports']");
	By chooseFileXpath = By.xpath("//input[@id='file']");
	By reportName = By.name("report_name");

	public PatientPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method-Find Patient By SSN
	public void findPatient(String ssn) {
		driver.findElement(ssnID).sendKeys(ssn);
		driver.findElement(searchButtonXpath).click();
		driver.findElement(nameXpath).click();
	}

	// Method - CreateVisit Button
	public void createVisit() {
		driver.findElement(createVisitXpath).click();
	}

	// Method - Book Appt
	public HashMap<String, String> bookAppt(String drName, String apptTime, String symptoms)
			throws InterruptedException {
		HashMap<String, String> expectedHMap = new HashMap<String, String>();
		String bookApptButtonXpath = bookApptButton.replace("%drName%", drName);
		driver.findElement(By.xpath(bookApptButtonXpath)).click();
		driver.switchTo().frame("myframe");
		String fDate = ApplicationLibraryClass.futureDate();
		driver.findElement(dateID).sendKeys(fDate);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Select select = new Select(driver.findElement(timeID));
		select.selectByVisibleText(apptTime);
		driver.findElement(continueButtonID).click();
		Thread.sleep(10000);
		WebElement e = driver.findElement(symptomsName);
		e.clear();
		e.sendKeys(symptoms);
		driver.findElement(submitButtonXpath).click();
		expectedHMap.put("DoctorName", drName);
		expectedHMap.put("Time", apptTime);
		expectedHMap.put("Date", fDate);
		expectedHMap.put("Symptoms", symptoms);
		return expectedHMap;
	}

	// Method - Add Prescription
	public boolean addPresciption(String apptDate, String presName, String presDes) {
		driver.findElement(addPrescriptioButtonXpath).click();
		Select select = new Select(driver.findElement(selectApptID));
		select.selectByVisibleText(apptDate);
		driver.findElement(prescriptionNameName).sendKeys(presName);
		driver.findElement(prescriptionDescriptionName).sendKeys(presDes);
		driver.findElement(pressubmitButtonXpath).click();
		return true;

	}

	// Method to verify Prescription
	public boolean verifyPres() {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Prescription has been Added.";
		Assert.assertEquals(actualText, expectedText);
		alert.accept();
		return true;
	}

	// Method to Add Fees by Admin
	public boolean addFees(String apptDate, String service, String expectedFees) throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(createFeeXpath).click();
		Select select1 = new Select(driver.findElement(selectApptID));
		select1.selectByVisibleText(apptDate);
		Select select2 = new Select(driver.findElement(serviceID));
		select2.selectByVisibleText(service);
		//Thread.sleep(10000);
	    String actualFees = driver.findElement(feeXpath).getAttribute("value");
		Assert.assertEquals(actualFees, expectedFees);
		driver.findElement(feesSubmitXpath).click();
		return true;

	}
	
	public boolean feeMsgVerification(){
	Alert alert	= driver.switchTo().alert();
	String actualMsg = alert.getText();
	String expectedMsg ="Fee Successfully Entered. ";
	Assert.assertEquals(actualMsg, expectedMsg);
	alert.accept();
	return true;
	}
	
	public boolean addReport(String apptDate) throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Thread.sleep(10000);
		driver.findElement(reportXpath).click();
		Select select = new Select(driver.findElement(selectApptID));
		select.selectByVisibleText(apptDate);
		driver.findElement(reportName).sendKeys("Test");
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		driver.findElement(chooseFileXpath).click();
		String filePath = "C:\\Users\\ektaj\\RepTest.txt";
		StringSelection clipBoardPath = new StringSelection(filePath);
		//we are copying filePath on clip-board
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath,null);
		//We are using Robot class to use keyboard keys
	    Thread.sleep(10000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return true;
		
	}
}
