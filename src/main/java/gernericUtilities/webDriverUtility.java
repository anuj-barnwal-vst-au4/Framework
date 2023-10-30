package gernericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;

/**
 * this class consists of all generic methods related to driver actions
 * @author anujp
 *
 */
public class webDriverUtility {
	
   /**
    * This method will maximize the window
    * @param driver
    */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will fullScreen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	 /**
	  * This method will wait for the page to load
	  * @param driver
	  */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	 /**
	  * This method will wait for the particular element to be visible in DOM
	  * @param driver
	  * @param element
	  */
	public void waitForElementToBeVisible(WebDriver driver ,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for the particular element to be click able
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver ,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropDown by using index number
	 * here i m using overloading process,bcoz we are using same method name(handleDrowdown) but different formal arguments 
	 * @param a
	 */
	public void handleDropdown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
		
	}
	/**
	 * This method will handle dropDown by using value
	 * @param element
	 * @param value
	 */
	
	public void handleDropdown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
		
	}
	
	/**
	 * This method will handle dropDown by using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(text);
	}
	
	/**
	 * This method will mouse overing Action the element to particular webElement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will move the cursor based on offset and click on web page
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveAndClick(WebDriver driver) {
		Actions act=new Actions(driver);
	//	act.scrollByAmount(x, y).perform();
		act.moveByOffset(10,10).click().perform();
		
	}
	
	/**
	 * This method will scroll to the particular webElement
	 * @param driver
	 * @param value
	 */
	public void scrollToElement(WebDriver driver,WebElement value) {
		Actions act=new Actions(driver);
		act.scrollToElement(value).perform();
	}
	/**
	 * This method will right click to particular webElement
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will double click to particular webElement
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions act =new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will drag and drop operation
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement dragEle,WebElement dropEle) {
		Actions act =new Actions(driver);
		act.dragAndDrop(dragEle,dropEle).perform();
	}
	
	/**
	 * This method will handle frame by Index
	 * @param driver
	 */
	public void swithToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by Name or Id
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver,String NameOrId) {
		driver.switchTo().frame(NameOrId);
	}
	
	/**
	 * This method will handle frame by webElement
	 * @param driver
	 * @param element
	 */
	public void swithToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 *  This method will change driver focus to parent frame
	 *  
	 * @param driver
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will focus driver to the main page
	 * @param driver
	 */
	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will scroll done by 500 unit
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500;", "");
	}
	/**
	 * This method will scroll up by 500 unit
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500;", "");
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will fetch the alert text and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will take screenshot and return the tgt path
	 * @param driver
	 * @param screenshotName
	 * @throws IOException 
	 */
	public String takesScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("D:\\E-Korban_Framework\\Screenshot"+screenshotName+".png"); // ".\\Screenshots\\"+Scenario+".png"
//		FileHandler.copy(src, tgt);
//		return dst.getAbsolutePath();
		Files.copy(src, dst);
		return dst.getAbsolutePath(); //used for extent report
	}
	/**
	 * This method will switch from one window to another based on window Title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//Step 1: get all the window IDs
		Set<String> allWinIds = driver.getWindowHandles();
		
		//Step 2: Navigate thru each window
		for(String winID:allWinIds)
		{
			//Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 4: Compare act title with expected partial Title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
}
