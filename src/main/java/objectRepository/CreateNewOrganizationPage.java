package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gernericUtilities.webDriverUtility;

public class CreateNewOrganizationPage extends webDriverUtility{
//Decleration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDwn;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
//initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return industryDropDwn;
	}

	public WebElement getTypeDropDwn() {
		return typeDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	//business libraray
	/**
	 *This method will create new organization with mandatory fields 
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}

	/**
	 * This method will create new organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganization(String ORGNAME,String INDUSTRY) {
		OrgNameEdt.sendKeys();
		handleDropdown(industryDropDwn,INDUSTRY );
		SaveBtn.click();
	}
	/**
	 * This method will create new organization with industry drop down and type
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param Type
	 */
	public void createOrganization(String ORGNAME,String INDUSTRY,String Type) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDwn,INDUSTRY );
	//	handleDropdown(typeDropDwn,Type );
		SaveBtn.click();
	
}
}
