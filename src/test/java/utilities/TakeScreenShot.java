package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testCases.BaseClass;

public class TakeScreenShot extends BaseClass {
	
	
	public String getScreenShotPath(String TestCaseName) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	Date currentDate = new Date();
	String date = currentDate.toString().replace(" ", "-").replace(":", "-");
	File src_screenShotFile = ts.getScreenshotAs(OutputType.FILE);
	String destPath = System.getProperty("user.dir")+"//ScreenShots//"  +TestCaseName+ date +".png";
	File dest_screenShotFile = new File(destPath);
	FileUtils.copyFile(src_screenShotFile,dest_screenShotFile);
	return destPath;
	} 
}
