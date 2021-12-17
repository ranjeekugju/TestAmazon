package frameworkP;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtil {
	
	public static WebDriver driver;
	private static final int pageElementLoadWait=30;

	public BaseUtil() {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public boolean waitForElementVisible(WebElement element) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver,pageElementLoadWait);
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			flag = true;
		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		return flag;
	}
		
	public boolean waitForElementClickable(WebElement element) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, pageElementLoadWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
		
	public boolean navigateURL(String siteUrl) {
		boolean flag = false;
		try {
			driver.navigate().to(siteUrl);
			flag = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
//	public static void takeScreenshot(WebDriver driver, String fileName) {
//		String imageName = fileName;
//		try {
//			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenshot, new File(imageName));
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	public void clickElementSelenium(WebElement element) {

		try {
			waitForElementClickable(element);
			element.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterText(WebElement element,String Text) {
		waitForElementClickable(element);
		try {
			if (element != null ) {
				element.clear();
				element.sendKeys(Text);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean selectElementByText (WebElement element,String input) {
		waitForElementClickable(element);
		boolean flag= false;
		try {
			
			if(element != null) {
				Select dropdwn = new Select(element);
				dropdwn.selectByVisibleText(input);
				flag= true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;		
	}

	
	public boolean jsClick(WebElement element) {
		boolean flag = false;
		waitForElementClickable(element);
		try {
	
			JavascriptExecutor exe = (JavascriptExecutor) driver;
			exe.executeScript("arguments[0].click();", element);
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public void submit(WebElement element) {
		boolean flag = false;
		waitForElementClickable(element);
		try {
			element.submit();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		return flag;
	}
	
	public void Enter(WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public void switchtab() {
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			char[] getWindowhandles = null;
			System.out.println(getWindowhandles);
			driver.switchTo().window(tabs2.get(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}