package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNgPractice {
	
	@Test()
	public void createCustomer() {
		Assert.fail();
	System.out.println("Customer create");
	}
	
	//dependsOnMethods it will execute based on  method
	@Test(dependsOnMethods = "createCustomer")
	public void customerModify() {
	System.out.println("customer modify");
	}
	
	@Test 
	public void deleteCustomer(){
		System.out.println("Customer deleted");
	}
	
	
	
	/*
    @Test(invocationCount = 0,priority=1)
	public void createCustomer() {
	System.out.println("Customer create");
	}
	
    @Test (enabled = false)
	public void newCustomerAdded(){
		System.out.println("Customer deleted");
	}
	//invocationCount=0, it wont execute
	@Test(invocationCount = 0)
	public void customerNew() {
	System.out.println("customer modify");
	}
	
	//enabled = false, it wont execute
	@Test (enabled = false)
	public void newCustomer(){
		System.out.println("Customer deleted");
	}*/
	
}
