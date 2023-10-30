package practice;


import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class anuj1 {
public static void main(String[] args) throws InterruptedException {
	
	Date d=new Date();
    String []dArr=d.toString().split("");
	String currentDate=dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
	System.out.println(currentDate);    System.out.println(currentDate);
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.className("commonModal__close")).click();
	
	WebElement FROM = driver.findElement(By.xpath("//input[@id='fromCity']"));
//	Select s=new Select(FROM);
//	s.selectByIndex(1);
	
    FROM.sendKeys("Bangkok, Thailand");
    driver.findElement(By.xpath("//p[text()='Bangkok, Thailand']")).click();
    
    WebElement TO =driver.findElement(By.xpath("//input[@id='toCity']"));
    TO.sendKeys("Kolkata, India");
    driver.findElement(By.xpath("//p[text()='Kolkata, India']")).click();
    
    /*String Flagg="false";
    while(Flagg=="false") {
    	if(driver.findElements(By.xpath("//div[@aria-label='Mon Dec 04 2023']")).size()>0){
    		
    		driver.findElement(By.xpath("//div[@aria-label='Mon Dec 04 2023']")).click();
    		Flagg="true";
    	}
    	else{
    		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
    	}
    }
    
    
  //  driver.findElement(By.xpath("//div[@aria-label='Wed Oct 04 2023']")).click();
    
    driver.findElement(By.xpath("//p[text()='Tap to add a return date for bigger discounts']")).click();
    
    String flag = "false";
    while(flag=="false") { 
	   if(driver.findElements(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).size()>0){
		   driver.findElement(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).click();
		   flag="true";
	   }
  
   else {
	   driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
   }
    }*/
    
 
    driver.findElement(By.xpath("//div[@aria-label='Sat Jul 09 2023']"+currentDate+"']")).click();
    
}
}
