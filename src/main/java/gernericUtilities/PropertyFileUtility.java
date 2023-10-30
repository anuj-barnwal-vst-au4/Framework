package gernericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic method to read data from property file
 * @author anujp
 *
 */
public class PropertyFileUtility {
	/**
	 * this method will read data from property file and return the value to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key)throws IOException  {
		
	FileInputStream fis =new FileInputStream("D:\\E-Korban_Framework\\src\\test\\resources\\CommonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty(key);
	return value;
	
	}
}
