package gernericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic method related to excel sheet
 * @author anujp
 *
 */
public class ExcelFileUtility {
/**
 * this method will read data from excel sheet and return value to caller
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook book =WorkbookFactory.create(fis);
	String value = book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	return value;
	}
	
	/**
	 * This method will read multiple data from excel sheet at time
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][]readMultipleData(String sheetName ) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
//FileInputStream fis=new FileInputStream("src\\test\\resources\\TestData1 - Copy.xlsx");
