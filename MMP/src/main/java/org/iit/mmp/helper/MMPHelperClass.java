package org.iit.mmp.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMPHelperClass {
	private WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By submitButton = By.name("submit");
	String moduleName = "//span[contains(text(),'%module%')]";
    //url - http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php
	
	public MMPHelperClass(WebDriver driver) {
		this.driver = driver;
	}

	// Method - To Navigate to different tab
	public void navigateToModule(String module){
		String moduleXpath = moduleName.replace("%module%", module);
		driver.findElement(By.xpath(moduleXpath)).click();
	}

	// Method- To login into Application
	//url-
	public boolean patientLogin(String userName, String passwordValue, String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(passwordValue);
		driver.findElement(submitButton).click();
		return true;
	}

	// Method - To Wait till WebElement is ready for clicking
	public void waitingForElmentToBeClicked(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement elementFound = wait.until(ExpectedConditions.elementToBeClickable(element));
		elementFound.click();

	}
	public void waitingForElementToBeVisible(By locator ,String value){
	WebDriverWait wait = new WebDriverWait(driver,100);
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	element.sendKeys(value);
		
		
		
	}
	
	public void navigateToModuleWithWait(String module) {
		String moduleXpath = moduleName.replace("%module%", module);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement elementFound = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(moduleXpath))));
		elementFound.click();

	}

}
