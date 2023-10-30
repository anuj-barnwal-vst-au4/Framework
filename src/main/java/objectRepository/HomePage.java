package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import gernericUtilities.webDriverUtility;

public class HomePage extends webDriverUtility {
	
//decleration drop down,frames,windows,textFields,popups                                                      
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
		//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		public WebElement getOrganizationsLink() {
			return organizationsLink;
		}

		public WebElement getContactsLink() {
			return ContactsLink;
		}

		public WebElement getProductsLink() {
			return productsLink;
		}

		public WebElement getAdministratorLinkElement() {
			return administratorImg;
		}

		public WebElement getSignOutLink() {
			return SignOutLink;
		}
		
		//Business Library
		
		/**
		 * This method will click on organizations link
		 */
		public void clickOnOrganizationLink() {
			organizationsLink.click();
		}	
		/**
		 *This method will click on contacts link 
		 */
		public void clickOnContactslink() {
			ContactsLink.click();
		}
		
		/**
		 * This method will click on products link
		 */
		public void clickOnProductsLink() {
			productsLink.click();
		}
		
		/**
		 * This method will logout the application
		 */
		public void logoutOfApp(WebDriver driver)throws InterruptedException {
			mouseHoverAction(driver,administratorImg);
			Thread.sleep(1000);
			SignOutLink.click();
		}
	}