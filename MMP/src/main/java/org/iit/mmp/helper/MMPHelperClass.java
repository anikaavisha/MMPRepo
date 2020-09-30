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
	//Method -  Waiting for element to be visible and this will return element which can be used to send keys or click
	public WebElement waitingForElementToBeVisible(By locator){
	WebDriverWait wait = new WebDriverWait(driver,200);
	//wait until element is visible
	WebElement webelement= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	return webelement;
	
	
	}
	//Method - Waiting for next Page Title to be displayed before locating any element
	public boolean explicitWaitForTitle(String title){
	WebDriverWait wait = new WebDriverWait(driver,100);
	return wait.until(ExpectedConditions.titleContains(title));
}
    //Method - Waiting for the text to be displayed
	public boolean explicitWaitFortext(By locator , String text ){
		WebDriverWait wait = new WebDriverWait(driver,60);
		boolean textDisplayed =  wait.until(ExpectedConditions.textToBePresentInElementLocated(locator ,text));
		return textDisplayed;
	}
	
	//Navigating to Patient Module with wait
	public void navigateToModuleWithWait(String module) {
	String moduleXpath = moduleName.replace("%module%", module);
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	WebElement elementFound = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(moduleXpath))));
	elementFound.click();

	}

}
