package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gernericUtilities.webDriverUtility;

public class createNewContactPage extends webDriverUtility{

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	//clcik on + sign in contact infornation (Organization Name)
	@FindBy(xpath= "(//img[@alt='Select'])[1]")
	private WebElement orgLookupImg;
		
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name="search")
	private WebElement orgSearcBtn;
	
	//initialization
	public createNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLastNameEdtElement() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookupImg() {
		return orgLookupImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearcBtn() {
		return orgSearcBtn;
	}
	
//Business Library
	/**
	 * This method will create contact with mandatory fields and save
	 * @param LastName
	 */
	public void createNewContact(String LastName) 
	{
		lastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}

	/**
	 * This method will create contact with Organization
	 * @param driver
	 * @param LastName
	 * @param OrgName
	 */
public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME )
{
		lastNameEdt.sendKeys(LASTNAME);
		orgLookupImg.click();
		switchToWindow(driver,"Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearcBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
        SaveBtn.click();
}
	
}
