package org.iit.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		protected WebDriver driver;
		
		
		@BeforeTest
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();

		}
	//Commenitng After Test
               //@AfterTest
		//public void closeBrowser(){
		//	driver.close();
		//}
		
		
		
				

}
