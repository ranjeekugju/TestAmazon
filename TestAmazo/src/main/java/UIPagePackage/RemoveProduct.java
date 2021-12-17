package UIPagePackage;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import frameworkP.BaseUtil;

public class RemoveProduct extends BaseUtil {
	WebDriver driver;

	public RemoveProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[@data-feature-id='delete']/span")
	@CacheLookup
	WebElement DeleteBtn;
	
	@FindBy(how = How.XPATH, using = " //div/span[contains(.,'Subtotal')]//following-sibling::span/span")
	@CacheLookup
	WebElement UpdatedSumTotal;
	
	@FindBy(how = How.XPATH, using = " //div/span[contains(.,'Subtotal')]//following-sibling::span")
	@CacheLookup
	WebElement UpdatedSumTotalA;
	
	
	@FindBy(how = How.CSS, using = ".sc-cart-header .a-spacing-mini")
	@CacheLookup
	WebElement RemovedCartMessage;

	
	public void deleteProduct() {
		
		try {
			String PreviousSumTotal = UpdatedSumTotal.getText();
			PreviousSumTotal = PreviousSumTotal.trim();
			PreviousSumTotal = PreviousSumTotal.replace(",", "");
			int BeforeDelPrice = (int) Double.parseDouble(PreviousSumTotal);
			clickElementSelenium(DeleteBtn);
			String RemovedMsg = RemovedCartMessage.getText();
			Assert.assertEquals(RemovedMsg, "Your Amazon Cart is empty.");
			String AfterSumTotal = UpdatedSumTotalA.getText();
			AfterSumTotal = AfterSumTotal.trim();
			AfterSumTotal = AfterSumTotal.replace(",", "");
			int AfterDelPrice = (int) Double.parseDouble(AfterSumTotal);
			
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			
			String originalHandle = driver.getWindowHandle();
			for (String handle: driver.getWindowHandles()) {
				if(!handle.equals(originalHandle)){
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);			
			Assert.assertEquals(0, AfterDelPrice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
