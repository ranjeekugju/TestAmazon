package TestP;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import frameworkP.BrowserCreation;

public class HelperClass {
	public static WebDriver driver;
	BrowserCreation brObj;

	public HelperClass() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeSuite
	public void beforeSuite () {
		System.out.println("in before Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("in Before Class method");
	}
	
	@BeforeMethod
	public void beforeMehtodClass() {
		System.out.println(" in before method");
		HelperClass.driver = BrowserCreation.getDriver("chrome");
	}
	
	@AfterMethod
	public void close() {
		System.out.println("in after method");
//		driver.close();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("in after class");
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite() throws IOException {
		System.out.println(" in after suite");
		driver.quit();
	}
			
}
