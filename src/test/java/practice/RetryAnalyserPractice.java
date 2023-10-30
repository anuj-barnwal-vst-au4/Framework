package practice;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
		@Test(retryAnalyzer =gernericUtilities.RetryAnalyserImplementation.class )
			public void analyserPractice() {
	//		Assert.fail();
				System.out.println("hi");
			}
		}

