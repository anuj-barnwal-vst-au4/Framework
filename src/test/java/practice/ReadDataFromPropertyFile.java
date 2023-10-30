package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
    //step1: open the document in java readable format
		
		FileInputStream fis =new FileInputStream("D:\\E-Korban_Framework\\src\\test\\resources\\CommonData.properties");
	//	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
    //step2:create object of properties for java.util package
		
		Properties prop =new Properties();
		
	//step3:Load the file input stream into properties
		
		prop.load(fis);
		
	//step4:provide the key  and read the value
		
		String BROWSER=prop.getProperty("browser");
		
		String UN=prop.getProperty("un");
		
		String PASSWORD=prop.getProperty("password");
		
		String URL=prop.getProperty("url");
		
		String FIRSTNAME=prop.getProperty("firstname");
		
		String LASTNAME=prop.getProperty("lastname");
		
		String TITLE=prop.getProperty("title");
		
		String EMAIL=prop.getProperty("email");
		
		String PHONE=prop.getProperty("phone");
		
		WebDriver driver=null;
		
		//launch the browsewr //Run Time Polymorphism :-driver
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println(BROWSER+"launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new ChromeDriver();
			System.out.println(BROWSER+ " launched");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
		WebElement dropdown=driver.findElement(By.name("salutationtype"));
		Select s=new Select(dropdown);
		s.selectByIndex(1);
		
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		
		String mainId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String id:allId) {
			if(!(mainId.equals(id))) {
				driver.switchTo().window(id);
				
			}
		}
		driver.findElement(By.xpath("//a[text()='Sustine SOlution']")).click();
		driver.switchTo().window(mainId);
		driver.findElement(By.name("title")).sendKeys(TITLE);
		driver.findElement(By.id("email")).sendKeys(EMAIL);
		driver.findElement(By.id("phone")).sendKeys(PHONE);
		
		driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
		WebElement dropdown1=driver.findElement(By.name("assigned_group_id"));
		Select s1=new Select(dropdown1);
		s1.selectByIndex(2);
		driver.findElement(By.cssSelector(".crmbutton.small.save")).click();
		
     //validate
		
		String lastName=driver.findElement(By.id("dtlview_Last Name")).getText();
	    if(lastName.contains(LASTNAME)) {
	    	System.out.println("pass");
	    }
	    else {
	    	System.out.println("fail");
	    }	
	//signout
	    
		WebElement admin=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("SignOut successful");
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		
	}

}
