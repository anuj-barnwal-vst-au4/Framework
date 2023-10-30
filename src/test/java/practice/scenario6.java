package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class scenario6 {

	public static void main(String[] args) {
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.xpath("//a[text()='Documents']")).click();
//		WebElement dropdown=driver.findElement(By.id("bas_searchfield"));
//		Select s=new Select(dropdown);
//		s.selectByIndex(3);
//		driver.findElement(By.xpath("//td[text()='Action']/../descendant::input[1]")).click();
//		
//		WebElement admin=driver.findElement(By.xpath(""));
//		Actions act=new Actions(driver);
//		act.moveToElement(admin).perform();
		
	}

}
