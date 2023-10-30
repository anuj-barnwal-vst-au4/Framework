package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    
	@Test(dataProvider = "getData")
	public void addProductToCart(String name,int price,int qty,String model) {
		
		System.out.println("Mobile name is : "+ name +" price is: "+ price+" qty is: " + qty + " model is: " + model);

	}
	@DataProvider
	public Object[][]getData()
	{
		Object[][] data=new Object[3][4];//3 sets of data with 4 details in each set
		data [0][0]="Samsung";
		data [0][1]=10000;
		data [0][2]=20;
		data [0][3]="m14";
		
		data [1][0]="Nokia";
		data [1][1]=15000;
		data [1][2]=15;
		data [1][3]="N72";
		
		data [2][0]="Realme";
		data [2][1]=18000;
		data [2][2]=10;
		data [2][3]="N72";
		
		return data;
		
	}
}

