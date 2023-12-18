package rahulShetty.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
	
	public static ExtentReports getReportObject()
	{
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		//ExtentReports, ExtentSparkReporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation result");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Abraj");
		extent.flush();
		return extent;
	}

}
