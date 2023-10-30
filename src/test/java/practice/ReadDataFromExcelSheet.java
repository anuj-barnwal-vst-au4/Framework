package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//1st approach
		
//		//step:1 open the doc in java readable format
//		FileInputStream fis=new FileInputStream("D:\\E-Korban_Framework\\src\\test\\resources\\TestData.xlsx");
//		
//		//step:2 create a workBook
//		Workbook book =WorkbookFactory.create(fis);
//		
//		//step:3 navigate to required sheet
//		Sheet sh=book.getSheet("Contacts");
//		
//		//step:4 navigate to required row
//		Row rw=sh.getRow(1);
//		
//		//step:5 navigate to cell
//		Cell ce=rw.getCell(2);
//		
//		//Step:6capture the value and print
//		String value=ce.getStringCellValue();
//		System.out.println(value);
		
		
		//2nd approach
		
		FileInputStream fis=new FileInputStream("D:\\E-Korban_Framework\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("organisation");
		
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(3).getCell(2));
		System.out.println(value);

	}

}
