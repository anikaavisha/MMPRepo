package org.iit.mmp.patientmodule.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public WebDriver driver;
	By username = By.id("username");
	By password  =  By.id("password");
	By submitButton =By.name("submit");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean patientStatusApprovedLoginVerification(String url,String userName,String pwd){
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitButton).click();
		//verify text after logging in.Text is userName.
        String actualText = driver.findElement(By.xpath("//h3[.=' "+userName+"  ']")).getText();
        Assert.assertEquals(actualText, userName);
        return true;
		
		
	}
	
	public boolean patientStatusRejectedLoginVerification(String url,String userName,String pwd){
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitButton).click();
		Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Your Account Has Been Rejected!. ";
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
        alert.accept();
        return true;
		
		
	}
	
	public boolean patientStatusPendingLoginVerification(String url,String userName,String pwd){
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitButton).click();
		Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Admin Approval is pending. ";
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
        alert.accept();
        return true;
		
		
	}
	
	
	//Method to test Login and Verify Login is successful 
	public boolean patientLoginDD(String userName, String passwordValue,String expectedText) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(passwordValue);
		driver.findElement(submitButton).click();
        String actualText = driver.findElement(By.xpath("//h3[.=' "+expectedText+"  ']")).getText();
        Assert.assertEquals(actualText, expectedText);
        return true;

	}
	
	//"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php"
	//Method to Open Patient Module
	public void openApp(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	
	
	
	


}
