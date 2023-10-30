package ContactsTests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import gernericUtilities.BaseClass;
import gernericUtilities.ExcelFileUtility;
import gernericUtilities.JavaUtility;
import gernericUtilities.PropertyFileUtility;
import gernericUtilities.webDriverUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.createNewContactPage;

@Listeners(gernericUtilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass {
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createContactTest() throws IOException, EncryptedDocumentException{

//	String ORGNAME = excelFileUtility.readDataFromExcelSheet("organisation", 3,2) + jUtility.randomNumber();
	String LASTNAME = eUtil.readDataFromExcelSheet("contacts",1,2);

	
	HomePage hPage=new HomePage(driver);
	hPage.clickOnContactslink();
	Reporter.log("click on contacts link");
	
    ContactsPage cPage=new  ContactsPage(driver);
    cPage.clickOnCreateContactLookUpImg();
    Reporter.log("clicked create contact lookup image");
    
    createNewContactPage cncp = new createNewContactPage(driver);
	cncp.createNewContact(LASTNAME);
	Reporter.log("contact created successfully");
	
	ContactInfoPage cip = new ContactInfoPage(driver);
	String contactHeader = cip.getHeadertext();
	
	// Assert.fail();
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	Reporter.log("Header validated");
	System.out.println(contactHeader);
	}
	
	@Test
	public void Demo() {
		System.out.println("demo");
	}
	
}
