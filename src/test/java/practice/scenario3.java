package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import objectRepository.OrganizationPage;

public class scenario3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
	//	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateEntElement().click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("Sustine SOlution");
		WebElement industryDropdown=driver.findElement(By.name("industry"));
		Select s=new Select(industryDropdown);
		s.selectByVisibleText("Chemicals");
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		
		WebElement admin=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
