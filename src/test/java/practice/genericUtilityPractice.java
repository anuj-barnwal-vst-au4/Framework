package practice;

import java.io.IOException;

import gernericUtilities.ExcelFileUtility;
import gernericUtilities.JavaUtility;
import gernericUtilities.PropertyFileUtility;


public class genericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
//	for PropertYUtility
	PropertyFileUtility pfu=new PropertyFileUtility();
	String URL=pfu.readDataFromPropertyFile("browser");
	System.out.println(URL);
	
//	String UN=pfu.readDataFromPropertyFile("un");
//	System.out.println(UN);
//	String PWD=pfu.readDataFromPropertyFile("password");
//	System.out.println(PWD);
	
//	for ExcelUtility
	ExcelFileUtility efu=new ExcelFileUtility();
	String data = efu.readDataFromExcelSheet("contacts", 0, 1);
	System.out.println(data);
	
//	for JavaUtility	randomNumber
	JavaUtility java=new JavaUtility();
	int value = java.randomNumber();
	System.out.println(value);
	
//	for JavaUtility	date	
	String date=java.getSystemDate();
	System.out.println(date);
	
	}
}
