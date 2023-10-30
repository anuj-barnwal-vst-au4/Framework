package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class writeDataInPropertyFile {

	public static void main(String[] args) throws IOException {
		
		Properties prop=new Properties();
		prop.put("NAME","ANUJ BARNWAL");
		FileOutputStream fos=new FileOutputStream("D:\\E-Korban_Framework\\src\\test\\resources\\CommonData.properties",true);
		prop.store(fos,"");
		

	}

}
