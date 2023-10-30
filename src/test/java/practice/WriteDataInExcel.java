package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WriteDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("D:\\E-Korban_Framework\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("organisation");
		sh.createRow(10).createCell(4).setCellValue("ANUJ");
		FileOutputStream fos=new FileOutputStream("D:\\E-Korban_Framework\\src\\test\\resources\\TestData.xlsx");
		book.write(fos);
		
	}

}
