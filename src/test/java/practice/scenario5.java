package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import objectRepository.ContactInfoPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class scenario5 {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("password");
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getUser_nameEdt().sendKeys("admin");
		lp.getUser_passwordEdt().sendKeys("password");
		lp.getLoginBtn().click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		WebElement dropdown=driver.findElement(By.name("salutationtype"));
		Select s=new Select(dropdown);
		s.selectByIndex(1);
		
		driver.findElement(By.name("firstname")).sendKeys("Anuj");
	//	driver.findElement(By.name("lastname")).sendKeys("Barnwal");
		
		ContactInfoPage sif=new ContactInfoPage(driver);
		sif.getLastnameEntElement().sendKeys("anu");
		
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
		driver.findElement(By.name("title")).sendKeys("TESTER");
		driver.findElement(By.id("email")).sendKeys("Anujqsp@Gmail.com");
		driver.findElement(By.id("phone")).sendKeys("(432) 432-8339");
		
		driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
		WebElement dropdown1=driver.findElement(By.name("assigned_group_id"));
		Select s1=new Select(dropdown1);
		s1.selectByIndex(2);
		driver.findElement(By.cssSelector(".crmbutton.small.save")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		WebElement admin=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
