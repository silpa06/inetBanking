package utilities;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {

	
	public static ExtentReports extent;
	
	
	
	public static ExtentReports extentReportGenerator()
	{
	String path =System.getProperty("user.dir")+"\\Reports\\report.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Functional Test Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester","Silpa Jakkareddy");
		return extent;
	}
	

}
