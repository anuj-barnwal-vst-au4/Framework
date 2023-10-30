package practice;

import java.io.IOException;
import java.util.Date;


public class anuj {

	public static void main(String[] args) throws IOException {
	//	driver.get("https://mail.google.com/mail/u/0/#inbox/FMfcgzGtxSpBdMpdzMZZJqLfZgDWxCJD");
		
		Date d = new Date();
		String date=d.toString();
		System.out.println(date);
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);
		
	}

}
