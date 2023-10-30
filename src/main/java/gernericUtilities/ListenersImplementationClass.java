package gernericUtilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

/**
 * 
 */
/**
 * this class provides implementation to ITestListener interface of testNG
 * @author Chaitra M
 *
 */
public class ListenersImplementationClass implements ITestListener {
	

		ExtentReports report;
		ExtentTest test;

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
			String testScriptName = result.getMethod().getMethodName();
			System.out.println(testScriptName+" ==== test script execution started ====");
			
			//create a test script - recognise each @Test
			test = report.createTest(testScriptName);
		
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
			String testScriptName = result.getMethod().getMethodName();
			System.out.println(testScriptName+" ==== Passed ====");
			
			//Log the success
			test.log(Status.PASS, testScriptName+" == PASS ==");
			
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			
			//ScreenShot
			//Exception for failure
			
			String testScriptName = result.getMethod().getMethodName();
			System.out.println(testScriptName+" ==== Failed ====");
			
			//Exception for failure
			System.out.println(result.getThrowable());
			
			//log for failure
			test.log(Status.FAIL, testScriptName+" == Fail ==");
			test.log(Status.INFO, result.getThrowable());
			
			//Screenshot
			String screenShotName = testScriptName + new JavaUtility().getSystemDate();
			
			webDriverUtility w=new webDriverUtility();
			
			try {
				
				String path = w.takesScreenshot(BaseClass.sDriver, screenShotName);
				test.addScreenCaptureFromPath(path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
			String testScriptName = result.getMethod().getMethodName();
			System.out.println(testScriptName+" ==== Skipped ====");
			
			//Exception for failure
			System.out.println(result.getThrowable());
			
			//log for Skip
			test.log(Status.SKIP, testScriptName+" == skipped ==");
			test.log(Status.INFO, result.getThrowable());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
			System.out.println("==== Suite Execution Started ====");
			
	        //Basic Report configuration //Report-17-10-2023-20-04-20.html
			ExtentSparkReporter html=ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
			html.config().setTheme(Theme.DARK);
			html.config().setDocumentTitle("Execution Report");
			html.config().setReportName("Vtiger execution Report");
			
		    report = new ExtentReports();
			report.attachReporter(html);
			report.setSystemInfo("Base Browser", "Firefox");
			report.setSystemInfo("Base Platform", "Windows");
			report.setSystemInfo("Base Environment", "Testing");
			report.setSystemInfo("Reporter Name", "Anuj");
			
			
		}

		private ExtentSparkReporter ExtentSparkReporter(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
			System.out.println("==== Suite Execution Finished ====");
			
			//Report genertion
			report.flush();
			
		}
		}
		
		

		
		
		
		
		
		
	
//		// TODO Auto-generated method stub
//		String testCaseName=result.getMethod().getMethodName();
//		System.out.println(testCaseName+ "=== test script execution started ===");
//	}
//
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		String testCaseName=result.getMethod().getMethodName();
//		System.out.println(testCaseName+ "=== passed ===");
//		
//	}
//
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		//screenshot
//		//exception for failure
//		
//		String testScriptName=result.getMethod().getMethodName();
//		System.out.println(testScriptName+ "=== failed ===");
//		
//		//exception for failure
//		System.out.println(result.getThrowable());
//		
//		String screenShotName=testScriptName+new JavaUtility().getSystemDate();
//		
//		webDriverUtility wUtil=new webDriverUtility();
//		try {
//			wUtil.takesScreenshot(BaseClass.sDriver, screenShotName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		String testCaseName=result.getMethod().getMethodName();
//		System.out.println(testCaseName+ "===skipped ===");
//		
//		//exception for failure
//				System.out.println(result.getThrowable());
//	}
//
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		System.out.println("suite execution started");
//	}
//
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		System.out.println("suite execution finished");
//	}
//
//	
//}
