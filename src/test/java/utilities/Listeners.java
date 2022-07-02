package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends TakeScreenShot implements ITestListener {
	
	ExtentReports extent = ExtentReportNG.extentReportGenerator();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
	 test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.info("test successful");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
			try {
				test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()), result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

}
