package UIPagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkP.BaseUtil;

public class ProductFinder extends BaseUtil {

	WebDriver driver;

	public ProductFinder(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "field-keywords")
	@CacheLookup
	WebElement SearchBox;


	public void findProduct(String SearchString) {

		try {
			System.out.println("Enter text on search box");
			enterText(SearchBox, SearchString);
			Thread.sleep(10000);
			Enter(SearchBox);
			System.out.println("----->>>>>selected ");


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}