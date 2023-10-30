package gernericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * this class consists of generic method related to java
 * @author anujp
 *
 */
public class JavaUtility {
/**
 * This method will generate a random number for every run and return it to the caller
 * @return
 */
	public int randomNumber() {
		Random r=new Random();
		int value = r.nextInt(1000);
		return value;
	}

public String getSystemDate() {
	/**
	 * this method will capture the current system date in required format
	 * @return
	 * simpleDateFormat (class)
	 */
	Date d=new Date();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String date=formatter.format(d);
	return date;
	
	
}
}
