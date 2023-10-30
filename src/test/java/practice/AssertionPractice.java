package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
/**
 * softAssert
 */
	@Test
	public void practice() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(1,1);
		System.out.println("step1");
		Assert.assertEquals(1,1);
		System.out.println("step 2");
	}
	
	/**
	 * hardAssert
	 */
	@Test
	public void practice1(){
		SoftAssert sa=new SoftAssert();
		System.out.println("step5");
		System.out.println("step6");
		
		sa.assertEquals(false,true);
		
		System.out.println("step7");
		System.out.println("step8");
		
		Assert.assertEquals(0,1);
		sa.assertEquals("A", "A");
	}
}
