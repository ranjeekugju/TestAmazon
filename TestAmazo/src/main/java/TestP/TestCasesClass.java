package TestP;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UIPagePackage.AddProductToCart;
import UIPagePackage.IncreaseItem;
import UIPagePackage.ProductFinder;
import UIPagePackage.RemoveProduct;
import frameworkP.BaseUtil;
import frameworkP.BrowserCreation;
import frameworkP.ScreenshotCapture;

public class TestCasesClass extends HelperClass {

	public TestCasesClass() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Test(priority= 1)
	public void positiveTest1() {
		try {
			System.out.println("Inside Positive Test");
			driver.get("http://amazon.in");
			
			ProductFinder productFinderpage = PageFactory.initElements(driver, ProductFinder.class);
			productFinderpage.findProduct("HP 100 Wired USB Keyboard");
			Thread.sleep(6000);
			AddProductToCart addToCart = PageFactory.initElements(driver, AddProductToCart.class);
			addToCart.selectProduct(driver,"HP 100 Wired USB Keyboard");
			Thread.sleep(5000);		
			IncreaseItem purchaseFlight = PageFactory.initElements(driver, IncreaseItem.class);
			purchaseFlight.increaseCount(driver, "10");		
			Thread.sleep(5000);
			
			RemoveProduct removeP = PageFactory.initElements(driver, RemoveProduct.class);
			removeP.deleteProduct();

			String bookingFlightDetails = System.getProperty("user.dir")+"\\"+"Screenshots\\"+"Test1"+".png";
			ScreenshotCapture.takeScreenshot(driver, bookingFlightDetails);
			
			Thread.sleep(5000);

			
			System.out.println("Finishd Positive---->>>>");
		}
		catch(Exception e) {e.printStackTrace();
		}
	}

	@Test(priority= 2)
	public void PositiveTest2() {
		try {
			System.out.println("Inside Positive Test 2");
			driver.get("http://amazon.in");
			
			ProductFinder productFinderpage = PageFactory.initElements(driver, ProductFinder.class);
			productFinderpage.findProduct("SanDisk Ultra Flair 128GB USB 3.0 Pen Drive");
			Thread.sleep(6000);
			AddProductToCart addToCart = PageFactory.initElements(driver, AddProductToCart.class);
			addToCart.selectProduct(driver,"SanDisk Ultra Flair 128GB USB 3.0 Pen Drive");
			Thread.sleep(5000);		
			IncreaseItem purchaseFlight = PageFactory.initElements(driver, IncreaseItem.class);
			purchaseFlight.increaseCount(driver, "10");		
			Thread.sleep(5000);
			
			RemoveProduct removeP = PageFactory.initElements(driver, RemoveProduct.class);
			removeP.deleteProduct();

			String bookingFlightDetails = System.getProperty("user.dir")+"\\"+"Screenshots\\"+"Test2"+".png";
			ScreenshotCapture.takeScreenshot(driver, bookingFlightDetails);
			
			Thread.sleep(5000);

			
			System.out.println("Finishd Positive Test 2---->>>>");
		}
		catch(Exception e) {e.printStackTrace();
		}
	}
	
}