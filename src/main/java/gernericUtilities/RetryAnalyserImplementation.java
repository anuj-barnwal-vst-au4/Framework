package gernericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class will provide implementation to the IRetryAnlyser interface of TestNg
 * @author anujp
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count =0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
		//0<3 1<3 2<3 3<3 no
		while(count<retryCount) {
			count++; //1 2 3
			return true; //retry retry retry
	}

		return false;  //stop retrying
	}
}
