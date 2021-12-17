package UIPagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// add the locators
	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.NAME, using = "login")
	@CacheLookup
	WebElement login;

	public void LoginWPage(String un, String pw) {
		try {
			username.sendKeys(un);
			Thread.sleep(2000);
			password.sendKeys(pw);
			Thread.sleep(2000);
			login.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
