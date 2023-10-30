package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class scenario2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Sustine SOlution");
		
		driver.findElement(By.id("bill_city")).sendKeys("Israel");
		
		driver.findElement(By.name("website")).sendKeys("www.SustineTiger.com");
		
		driver.findElement(By.id("phone")).sendKeys("(431) 432-8339");
		
		driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
		WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		Select s=new Select(dropdown);
		s.selectByValue("Marketing Group");
		//driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		driver.findElement(By.cssSelector(".crmbutton.small.save")).click();
		
		//validation
		String contactId=driver.findElement(By.className("dvtCellInfo")).getText();
		if(contactId.contains("CON19")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
		
		WebElement admin=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
