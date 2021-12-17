package frameworkP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserCreation {
	
	public static WebDriver driver;
	
	public BrowserCreation() {
		
	}
	
	public static WebDriver getDriver(String browserName) {
		if(driver==null) {
			if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
//				System.setProperty("webdriver.gecko.driver","C:\\Users\\Ranjeet\\Downloads\\geckodriver.exe");
				driver= new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				
			}
			else if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
//				System.setProperty("webdriver.chrome.driver","C:\\Users\\Ranjeet\\Downloads\\chromedriver.exe");
				driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			}
			else if(browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
//				System.setProperty("webdriver.ie.driver","C:\\Users\\Ranjeet\\Downloads\\IEDriverServer.exe");
				driver= new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			}
		}
		return driver;
	}
}
