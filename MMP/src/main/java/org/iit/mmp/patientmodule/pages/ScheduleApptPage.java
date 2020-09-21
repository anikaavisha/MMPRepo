package org.iit.mmp.patientmodule.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.iit.mmp.helper.MMPHelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleApptPage {
	
	public WebDriver driver;
	By createNewApptButtonXpath =By.xpath("//input[contains(@value,'Create new appointment')]");
	String bookApptButton = "//h4[contains(text(),'%doctorName%')]/ancestor::ul/following-sibling::button[@id='opener']";
	By dateXpath = By.id("datepicker");
	By selectTimeId = By.id("time");
	By continueButtonId = By.id("ChangeHeatName");
	By symptomsId = By.id("sym");
	By submitButton = By.xpath("//input[contains(@type,'submit')]");
	By calendarYearXpath =By.xpath("//span[@class='ui-datepicker-year']");
	By calendarNextArrowXpath = By.xpath("//span[text()='Next']");
	By calendarMonthXpath =  By.xpath("//span[@class='ui-datepicker-month']");
	By calendarDayXpath =By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a");
	By apptFirstRowDate = By.xpath("//table[@class='table']//tbody/tr[1]/td[1]");
	By apptFirstRowTime = By.xpath("//table[@class='table']//tbody/tr[1]/td[2]");
	By apptFirstRowSymptoms = By.xpath("//table[@class='table']//tbody/tr[1]/td[3]");
	By apptFirstRowDoctor = By.xpath("//table[@class='table']//tbody/tr[1]/td[4]");
	By dateSPageXpath = By.xpath("(//h3[@class='panel-title'])[2]");
	By timeSPageXpath = By.xpath("//div[@class='list-group list-statistics']/a[1]");
	By providerSPageXpath = By.xpath("//div[@class='list-group list-statistics']/a[2]");
	By symptomsSPageXpath = By.xpath("//div[@class='list-group list-statistics']/a[3]");
	
	public ScheduleApptPage(WebDriver driver){
		this.driver = driver;
		
	}
	//method to format date
	public String dateformat(String date){
	Date date1 = new Date(date);
	SimpleDateFormat monthFormat = new SimpleDateFormat("MMMMM");
	SimpleDateFormat monthIntFormat = new SimpleDateFormat("MM");
	SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
//	System.out.println(monthFormat.format(date));
//	System.out.println(monthIntFormat.format(date));
//	System.out.println(dayFormat.format(date));
//	System.out.println(yearFormat.format(date));
    String date2 = monthIntFormat.format(date1)+"/"+dayFormat.format(date1)+"/"+yearFormat.format(date1);
return date2;
}
	
//datepicker logic for selecting date through calendar
public void apptDate(String day) {
		
		
		// String day = "October/19/2020";
		String[] date = day.split("/");
		String apptMonth = date[0];
		String apptDay = date[1];
		String apptYear = date[2];
		String calYear = driver.findElement(calendarYearXpath).getText();
		
		while (!(calYear.equals(apptYear))) {
			driver.findElement(calendarNextArrowXpath).click();
			calYear = driver.findElement(calendarYearXpath).getText();
		}
		String calMonth = driver.findElement(calendarMonthXpath).getText();
		while (!(calMonth.equals(apptMonth))) {
			driver.findElement(calendarNextArrowXpath).click();
			calMonth = driver.findElement(calendarMonthXpath).getText();
		}
		List<WebElement> calDays = driver
				.findElements(calendarDayXpath);
		for (int i = 0; i < calDays.size(); i++) {
			String calDay = calDays.get(i).getText();
			if (calDay.equals(apptDay)) {
				calDays.get(i).click();
				break;
			}

		}

	}
	//Method to book appointment and storing Data in HashMap
	public HashMap<String , String> bookAppt(String doctorName ,String date,String timeS,String symptoms) throws InterruptedException{
		HashMap<String , String> hMap = new HashMap<String , String>();
		MMPHelperClass elem = new MMPHelperClass(driver);
		ScheduleApptPage ap = new ScheduleApptPage(driver);
		//Click CreateNewAPPT Button
		driver.findElement(createNewApptButtonXpath).click();
		String bookApptButtonXpath = bookApptButton.replace("%doctorName%",doctorName);
		//calling Method which will wait for element and then click
		elem.waitingForElmentToBeClicked(driver.findElement(By.xpath(bookApptButtonXpath)));
		driver.switchTo().frame("myframe");
		driver.findElement(dateXpath).click();
		//getting date from date picker
		ap.apptDate(date);
		//Selecting time from dropdown
		Select time = new Select(driver.findElement(selectTimeId));
		time.selectByVisibleText(timeS);
		//waiting and clicking on Continue Button
		elem.waitingForElmentToBeClicked(driver.findElement(continueButtonId));
	    driver.findElement(symptomsId).sendKeys(symptoms);
		driver.findElement(submitButton).click();
		//Converting date from September/10/2020 format to 09/10/2020 for HashMap comparison
		String date2 = ap.dateformat(date);
		hMap.put("DoctorName", doctorName);
		hMap.put("Date",date2);
		hMap.put("Time",timeS);
		hMap.put("Symptoms",symptoms);
		return hMap;
		
	}
	//Method to verify appt details in Home Page. It should be the first row of  appt table
	public boolean verifyapptDetailsHPage(HashMap<String,String> hmap ){
		
		HashMap<String , String> hMap1 = new HashMap<String , String>();
		if((hmap.get("DoctorName")).equals((driver.findElement(apptFirstRowDoctor)).getText()) && 
				(hmap.get("Date")).equals((driver.findElement(apptFirstRowDate)).getText())&&
				(hmap.get("Time")).equals((driver.findElement(apptFirstRowTime)).getText())&&
				(hmap.get("Symptoms")).equals((driver.findElement(apptFirstRowSymptoms)).getText())){
			return true;
		}
		
		return false;
		
		}
	
	//Method to verify appt on Schedule Appt page
	
	public boolean verifyApptDetailsSPage(HashMap<String,String> hMap){
		MMPHelperClass lp = new MMPHelperClass(driver);
		lp.navigateToModule("Schedule Appointment");
		if(hMap.get("Date").equals(driver.findElement(dateSPageXpath).getText()) && 
				hMap.get("Time").equals(driver.findElement(timeSPageXpath).getText().split(":")[1].trim()) && 
				hMap.get("DoctorName").equals(driver.findElement(timeSPageXpath).getText().split(":")[1].trim())&&
				hMap.get("Symptoms").equals(driver.findElement(symptomsSPageXpath).getText().split(":")[1])){
			return true;
		}
		
				
		return false;
		
		
	}
	
    }
