package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProfileViewHistoryPage {
	public WebDriver driver ;
	By viewHistoryButton = By.linkText("View History");
	By pastApptButtonXpath = By.xpath("//input[@value='Past Appointments']");
	By apptRowsXpath = By.xpath("//table[@class='table']//tbody//tr");
	By pastPrescriptionButtonXpath = By.xpath("//input[@value='Past Prescription']");
	By totalPrescriptionButtonXpath = By.xpath("//table[@class='table']//tbody//tr//td");
	By weightFieldID = By.id("weight");
	String patPrescriptionHeading = "//h2[contains(.,'%presHeading%')]";
	By patPresNameXpath = By.xpath("//p[last()]");
	String datePresName ="//table//ul/li[contains(text(),'%presName%')]//p[contains(text(),'%apptDate%')]";
	By presDesXpath = By.xpath("//div//p");
	
	public ProfileViewHistoryPage (WebDriver driver){
		this.driver = driver;
	}
		
	public int totalAppts() {
		driver.findElement(viewHistoryButton).click();
		driver.findElement(pastApptButtonXpath).click();
		List<WebElement> apptRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
		int totalAppts = apptRows.size();
		return totalAppts;

	}

	public String patientApptDetailsValidation(String pSymptoms, String pDate, String pTime, String doctorName)
			throws InterruptedException {
		driver.findElement(viewHistoryButton).click();
		Thread.sleep(30000);
		driver.findElement(pastApptButtonXpath).click();
		List<WebElement> apptRows = driver.findElements(apptRowsXpath);
		for (int i = 0; i < apptRows.size(); i++) {
			String apptDetails = apptRows.get(i).getText();
			if (apptDetails.contains(pSymptoms) && apptDetails.contains(pDate) && apptDetails.contains(pTime)
					&& apptDetails.contains(doctorName)) {
				System.out.println("Appointment found");
				System.out.println(apptDetails);
				return apptDetails;

			}

		}
		return null;

	}

	public String prescriptionValidation(String presHeading) throws InterruptedException {

		driver.findElement(viewHistoryButton).click();
		Thread.sleep(30000);
		driver.findElement(pastPrescriptionButtonXpath).click();
		List<WebElement> totalPrescription = driver.findElements(totalPrescriptionButtonXpath);
		for (int i = 0; i < totalPrescription.size(); i++) {
			String pres = totalPrescription.get(i).getText();
			if (pres.contains(presHeading)) {
				totalPrescription.get(i).click();
				String patPresHeadingXpath = patPrescriptionHeading.replace("%presHeading%", presHeading);
				String patPresHeading = driver.findElement(By.xpath(patPresHeadingXpath)).getText();
				System.out.println(patPresHeading);
				String patPrescriptionName = driver.findElement(patPresNameXpath).getText();
				System.out.println(patPrescriptionName);
				return patPrescriptionName;
}

		}
		return null;

	}
	
	public boolean adminPresVerify(String apptDate,String presName,String presDes ) throws InterruptedException{
		driver.findElement(viewHistoryButton).click();
		Thread.sleep(30000);
		driver.findElement(pastPrescriptionButtonXpath).click();
		String datePresNameM = datePresName.replace("%apptDate%", apptDate);
		String datePresNameXpath = datePresNameM.replace("%presName%", presName);
		driver.findElement(By.xpath(datePresNameXpath)).click();
		String actualPresDes = driver.findElement(presDesXpath).getText().trim();
		Assert.assertEquals(actualPresDes, presDes);
		return true;
		}
}



