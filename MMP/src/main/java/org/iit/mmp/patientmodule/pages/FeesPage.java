package org.iit.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FeesPage {

	public WebDriver driver;
	By payNowButton= By.linkText("Pay Now");
	By amountSelectID = By.id("amount");
	By continueButton = By.xpath("//input[@value='Continue']");
    String feeverify ="//p[contains(.,'%fees%')]";
	By fNameID= By.id("name");
	By cardNumberID= By.id("cid");
	By selectCardID = By.id("card_name");
	By cardExpirationMonthID = By.id("cardMonth");
	By cardExpirationYearID= By.id("cardYear");
	By codeID = By.id("cvv");
	String feeTab = "//span[contains(text(),'%module%')]";


	public FeesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
   //Method - Clicking on pay Now and Selecting Payment and Hitting Continue Button
	public boolean slectingFee(String fees) {
		driver.findElement(payNowButton).click();
		Select amount = new Select(driver.findElement(amountSelectID));
		amount.selectByVisibleText(fees);
		driver.findElement(continueButton).click();
		return true;
	}
	
	public boolean feeVerification(String fees){
		String feeXpath = feeverify.replace("%fees%", fees );
		String displayedFees = driver.findElement(By.xpath(feeXpath)).getText();
		Assert.assertEquals(displayedFees, fees);
		return true;
	}
	
	public boolean patientInfo(){
		driver.findElement(fNameID).sendKeys("AAA");
		Select card = new Select(driver.findElement(selectCardID));
		card.selectByIndex(1);
		driver.findElement(cardNumberID).sendKeys("123456");
		Select expirationMonth = new Select(driver.findElement(cardExpirationMonthID));
		expirationMonth.selectByIndex(1);
		Select expirationYear = new Select(driver.findElement(cardExpirationYearID));
		expirationYear.selectByIndex(1);
		driver.findElement(codeID).sendKeys("123");
		return true;

	}

	
	

}
