package ContactsTests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import gernericUtilities.BaseClass;
import gernericUtilities.ExcelFileUtility;
import gernericUtilities.JavaUtility;
import gernericUtilities.PropertyFileUtility;
import gernericUtilities.webDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;
import objectRepository.createNewContactPage;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test(groups={"SmokeSuites","RegressionSuite"})
	public void createContactWithOrgTest() throws IOException, InterruptedException {
//	public static void main(String[] args) throws InterruptedException, IOException {
	
		// Step 1: Create all the required Objects
//				JavaUtility jUtil = new JavaUtility();
//				ExcelFileUtility eUtil = new ExcelFileUtility();
//				PropertyFileUtility pUtil = new PropertyFileUtility();
//				webDriverUtility wUtil = new webDriverUtility();
//				WebDriver driver = null;
////				EdgeOptions options=new EdgeOptions();
////				options.addArguments("--disable-notifications");
//				
//
//				// Step 2: Read The Required Data
//				String BROWSER = pUtil.readDataFromPropertyFile("browser");
//				String URL = pUtil.readDataFromPropertyFile("url");
//				String USERNAME = pUtil.readDataFromPropertyFile("un");
//				String PASSWORD = pUtil.readDataFromPropertyFile("password");

				String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 3) + jUtil.randomNumber();
				String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 2);

//				// Step 3: Launch the browser
//				if(BROWSER.equalsIgnoreCase("chrome")) {
//					WebDriverManager.chromedriver().setup();
//					driver=new ChromeDriver();
//					System.out.println(BROWSER+"launched");
//				}
//				else if(BROWSER.equalsIgnoreCase("firefox")) {
//					WebDriverManager.firefoxdriver().setup();
//					driver=new FirefoxDriver();
//					System.out.println(BROWSER+" launched");
//				}
//				else if(BROWSER.equalsIgnoreCase("edge")) {
//					WebDriverManager.edgedriver().setup();
//					driver=new EdgeDriver();
//					System.out.println(BROWSER+ " launched");
//				}
//				else
//				{
//					System.out.println("invalid browser name");
//				}
//				wUtil.maximizeWindow(driver);
//				wUtil.implicitWait(driver);
//
//				// Step 4: Load the URL
//				driver.get(URL);
//				
//				//Step 5: Login To Application
//				LoginPage lp = new LoginPage(driver);
//				lp.loginToApp(USERNAME, PASSWORD);

				//Step 6: click on Organization
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLink();
				
				//Step 7: Click on Create Organization look Up Image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnOrganizationLookUpImg();
				
				//Step 8: Create new Organization with Mandatory fields
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrganization(ORGNAME);
				
				//Step 9: Validate for Organization
				OrganizationInformationPage oip = new OrganizationInformationPage(driver);
				String orgHeader = oip.getHeaderText();
				Assert.assertTrue(orgHeader.contains(ORGNAME));
				System.out.println(orgHeader);
				
//				if(orgHeader.contains(ORGNAME))
//				{
//					System.out.println(orgHeader);
//					System.out.println("Organization Created");
//				}
//				else
//				{
//					System.out.println("FAIL");
//				}
				
				//Step 10: Click On Contacts Link
				hp.clickOnContactslink();
				
				//Step 11: Click on Create contact Look Up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Step 12: Create Contact with Organization
				createNewContactPage cncp = new createNewContactPage(driver);
				cncp.createNewContact(driver, LASTNAME, ORGNAME);
				
				//Step 13: Validation
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.getHeadertext();
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
				
//				if(contactHeader.contains(LASTNAME))
//				{
//					System.out.println(contactHeader);
//					System.out.println("PASS");
//				}
//				else
//				{
//					System.out.println("FAIL");
//				}
				
				//Step 14: Logout
				hp.logoutOfApp(driver);
				
				//Step 15: Close the Browser
				driver.quit();
				

	}

}
