package UIPagePackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import frameworkP.BaseUtil;

public class AddProductToCart extends BaseUtil {
	WebDriver driver;

	public AddProductToCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(how = How.LINK_TEXT, using = "HP 100 Wired USB Keyboard")
	@CacheLookup
	WebElement SelectProduct;

	
	@FindBy(how = How.XPATH, using = "//*[@id='quantity']")
	@CacheLookup
	WebElement Quantity;
	
	
	@FindBy(how = How.NAME, using = "submit.add-to-cart")
	@CacheLookup
	WebElement AddToCart;
	
	@FindBy(how = How.ID, using = "nav-cart-count")
	@CacheLookup
	WebElement CartCount;
	
	@FindBy(how=How.XPATH, using = "//*[@id='nav-cart-count']")
	@CacheLookup
	WebElement CartCountA;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'a-color-price')]")
	@CacheLookup
	WebElement SumTotal;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'a-size-medium-plus')]")
	@CacheLookup
	WebElement AddedToCart;
	
	
	public void selectProduct( WebDriver driver,String ProductName) {
		try {
			Thread.sleep(5000);
			WebElement we = driver.findElement(By.linkText(ProductName));
			clickElementSelenium(we);
			System.out.println("Inside product selection");	
			Thread.sleep(10000);
			
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			
			String FirstCartCount = (CartCount.getText());
			int IntialCartCount = Integer.parseInt(FirstCartCount);
			System.out.println(FirstCartCount);
			
			Select quantity = new Select(Quantity);
//			quantity.selectByIndex(2);
			quantity.selectByValue("1");
			
			waitForElementClickable(Quantity);
			clickElementSelenium(AddToCart);
			Thread.sleep(15000);
			
			String CartVerificationText = AddedToCart.getText();
			Assert.assertEquals("Added to Cart", CartVerificationText);
		
			
			String SumTotalP = SumTotal.getText();
			System.out.println(SumTotalP);
			
			String CartCountAddingtoCart = CartCountA.getText();
			int CartCountafteADD = Integer.parseInt(CartCountAddingtoCart);
			System.out.println(CartCountAddingtoCart);
			
			Assert.assertNotEquals(IntialCartCount,CartCountafteADD);
			
			Thread.sleep(10000);
			System.out.println("Finished Add product");
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
