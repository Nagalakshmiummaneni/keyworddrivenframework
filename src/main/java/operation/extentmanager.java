package operation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentmanager {
	static WebDriver driver;
	 private static ExtentReports extent;
	    private static ExtentSparkReporter Reporter;
	    private static ExtentTest test;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            String reportPath = System.getProperty("user.dir") + "/report/extentReport.html";
	            Reporter = new ExtentSparkReporter(reportPath);
	            Reporter.config().setDocumentTitle("Automation Report");
	            Reporter.config().setReportName("Keyword Driven Testing Report");
	            Reporter.config().setTheme(Theme.STANDARD);

	            extent = new ExtentReports();
	            extent.attachReporter(Reporter);
	        }
	        return extent;
	    }
	    public static ExtentTest createTest(String testName) {
	        test = extent.createTest(testName);
	        return test;
	    }

	    public static String captureScreenshot(String screenshotName) {
	      
	        TakesScreenshot ts=(TakesScreenshot)getDriver(); 
			File  src=ts.getScreenshotAs(OutputType.FILE);
			  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String path=System.getProperty("user.dir") + "/screenshot/" + screenshotName + "_" + dateName + ".png";
			
			File destination=new File(path);
			src.renameTo(destination);
			return path;

	    }

	    public static void flushReport() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

	    public static ExtentTest getTest() {
	        return test;
	    }

		public static WebDriver getDriver() {
			return driver;
		}

		public static void setDriver(WebDriver driver) {
			extentmanager.driver = driver;
		}
	   
	}
