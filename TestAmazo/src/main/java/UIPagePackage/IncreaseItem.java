package UIPagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import bsh.util.Util;
import frameworkP.BaseUtil;

public class IncreaseItem extends BaseUtil{
	WebDriver driver;

	public IncreaseItem(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(how = How.ID, using = "nav-cart-count")
	@CacheLookup
	WebElement CartCount;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Qty:']//parent::span//parent::span//parent::span//preceding-sibling::select")
	@CacheLookup
	WebElement QuantityK;
	
	@FindBy(how = How.CSS, using = ".sc-gift-option > label > input")
	@CacheLookup
	WebElement GiftCheckBox;

	@FindBy(how=How.CSS, using = "#sc-subtotal-amount-buybox .a-size-medium")
	@CacheLookup
	WebElement CartCountA;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'a-color-price')]")
	@CacheLookup
	WebElement SumTotal;
	
	@FindBy(how = How.CSS, using = "#sc-subtotal-amount-buybox .a-size-medium")
	@CacheLookup
	WebElement SumTotalCart;
	
	@FindBy(how = How.CSS, using = "#nav-cart")
	@CacheLookup
	WebElement CartBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@name='quantityBox']")
	@CacheLookup
	WebElement InputFieldTenPlus;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'sc-update-link')]//*[contains(@class, 'a-button-text')]")
	@CacheLookup
	WebElement UpdateCartQntButton;
	
	public void increaseCount(WebDriver driver,String qunt) {
		
		try {
			
			System.out.println("Started increase items");
			
			String FirstCartCount = (CartCount.getText());
			int IntialCartCount = Integer.parseInt(FirstCartCount);
			System.out.println(FirstCartCount);
			
			String BeforeP = SumTotal.getText();
			System.out.println(BeforeP);
			BeforeP = BeforeP.trim();
			BeforeP = BeforeP.replace(",", "");
			
			int BeforePInt = (int)Double.parseDouble(BeforeP);
			Thread.sleep(5000);

			System.out.println("after wait method");
			
			clickElementSelenium(CartBtn);
			
			Thread.sleep(5000);
			
			System.out.println("clicked on cart btn");
			
			clickElementSelenium(GiftCheckBox);
//			JavascriptExecutor exe = (JavascriptExecutor)driver;
//			exe.executeScript("arguments[0].style.visibility = 'visible';arguments[0].style.overflow ='visible';arguments[0].style.height ='3px';arguments[0].style.width ='1px';arguments[0].style.opacity ='1'", SelectElm);
//			SelectElm.click();
			
			Thread.sleep(15000);

			if ( Integer.parseInt(qunt)< 10 ) {
				Select quantity = new Select(QuantityK);
				quantity.selectByValue(qunt);
			}
			else {
				Select quantity = new Select(QuantityK);
				Thread.sleep(10000);
				quantity.selectByIndex(Integer.parseInt(qunt));
				Thread.sleep(2000);
				waitForElementClickable(InputFieldTenPlus);
				InputFieldTenPlus.sendKeys(Keys.CONTROL + "a");
				Thread.sleep(3000);
				InputFieldTenPlus.sendKeys(Keys.DELETE);
				Thread.sleep(3000);
				InputFieldTenPlus.sendKeys(Keys.BACK_SPACE);
				Thread.sleep(2000);
				InputFieldTenPlus.sendKeys(qunt);
				Thread.sleep(2000);
				clickElementSelenium(UpdateCartQntButton);
			}
			
			Thread.sleep(6000);
			WebElement wd2 = driver.findElement(By.cssSelector("#sc-subtotal-amount-buybox .a-size-medium"));
			System.out.println("after driver " + wd2);
			String SumTotalP = SumTotalCart.getText();
			System.out.println(SumTotalP);
			
			SumTotalP = SumTotalP.trim();
			SumTotalP = SumTotalP.replace(",", "");
			int AfterIncP = (int)Double.parseDouble(SumTotalP);
			
			int FinalPrice= BeforePInt * (Integer.parseInt(qunt));
			System.out.println("Final price is : -->>"+FinalPrice);

			
			String CartCountAddingtoCart = CartCountA.getText();
			CartCountAddingtoCart = CartCountAddingtoCart.trim();
			CartCountAddingtoCart = CartCountAddingtoCart.replace(",", "");
			int CartCountafteADD = (int)Double.parseDouble(CartCountAddingtoCart);
			System.out.println("Final Cart Value is : -- "+CartCountAddingtoCart);
			Assert.assertEquals(FinalPrice, CartCountafteADD);
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
