package keyword_driven2_test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import operation.base;
import operation.extentmanager;
import readexcel.readexcel;

public class exeutiontest {
	WebDriver driver;
	
	 @BeforeTest
	    public void setupReport() {
	        
	        extentmanager.getInstance();
	    }
	@Test
	public void test() throws Exception {
		 extentmanager.createTest("Keyword Driven2 Test");
		base b=new base();
	    Properties prop=b.init_properties();
		readexcel excel=new readexcel();
		excel.read("sheet2",prop);
	}
	
	 @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            String screenshotPath = extentmanager.captureScreenshot(result.getName());
	            extentmanager.getTest().fail("Test Failed, Screenshot captured").addScreenCaptureFromPath(screenshotPath);
	        }
	        else if (result.getStatus() == ITestResult.SUCCESS) {
	        	  String screenshotPath = extentmanager.captureScreenshot(result.getName());
		            extentmanager.getTest().pass("Test passes, Screenshot captured").addScreenCaptureFromPath(screenshotPath);
	      		}
			}
	 @AfterTest
	    public void tearDownReport() {
	        // Flush the report after all tests
	        extentmanager.flushReport();
	    }

}
