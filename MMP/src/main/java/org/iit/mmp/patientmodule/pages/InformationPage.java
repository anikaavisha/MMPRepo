package org.iit.mmp.patientmodule.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformationPage {
	public WebDriver driver;
	By infoTextXpath = By.xpath("//div[@class='panel-title']");
	
	public InformationPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String actualTextMethod(){
		String actualText = driver.findElement(infoTextXpath).getText().trim();
		return actualText;
		
		
	}
}
