package TestDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearningAdvanceReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the Sparkreport
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/report.html");
		
		//configure the spark report information
		
		spark.config().setDocumentTitle("Regression Testing for the Swag Labs");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.STANDARD);
		
		//CREATE THE EXTENT REPORT
		
		ExtentReports report = new ExtentReports();
		
		//Attach the spark Report and Extent report
		
		report.attachReporter(spark);
		
		//configure the system information in extent report
		
		report.setSystemInfo("Device Name:","Manasa");
		report.setSystemInfo("Operating System:","WINDOWS 11");
		report.setSystemInfo("Browser:","Chrome");
		report.setSystemInfo("BrowserVersion:","Chrome");
		
		//Create the Test Information
		
		ExtentTest test = report.createTest("Regressiontest");
		
		//Steps Information
		
		test.log(Status.INFO, "Step1: Launching The Browser Successfully");
		
		test.log(Status.INFO, "Step2: Navigating to the application via URL Successful");
		
		test.log(Status.PASS, "Step3: VERIFIED the Webpage Successful");
		
		if(true == true)
		{
			test.log(Status.PASS, "Step4: Verified the WebElements Displayed");
		}
		else
		{
			test.log(Status.PASS, "Step4: Verified the WebElements  not Displayed");
		}
		test.log(Status.SKIP, "Step5: Element is hidden");
		
		//Flush the Report Information
		
		report.flush();

	}

}
