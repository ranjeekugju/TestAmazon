package frameworkP;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCapture {

	public ScreenshotCapture() {
		// TODO Auto-generated constructor stub
	}
	
	public static void takeScreenshot(WebDriver driver, String fileName) {
		String imageName = fileName;
		try {
			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(imageName));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
