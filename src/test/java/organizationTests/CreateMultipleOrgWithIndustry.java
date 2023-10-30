package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gernericUtilities.ExcelFileUtility;
import gernericUtilities.JavaUtility;
import gernericUtilities.PropertyFileUtility;
import gernericUtilities.webDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateMultipleOrgWithIndustry {
ExcelFileUtility eUtil=new ExcelFileUtility();
PropertyFileUtility pUtil=new PropertyFileUtility();
webDriverUtility wUtil=new webDriverUtility();
JavaUtility jUtil=new JavaUtility();


@Test(dataProvider = "getData")
public void createMultipleOrg(String ORG,String INDUSTRYNAME) throws IOException, InterruptedException {
	WebDriver driver = null;
	
	// Step 2: Read The Required Data
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("un");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	       
			String ORGNAME = ORG+jUtil.randomNumber();
			
			// Step 3: Launch the browser
			if (BROWSER.equalsIgnoreCase("chrome")) {
		//		WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER + " launched");
			} else if (BROWSER.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println(BROWSER + " launched");
			} else if (BROWSER.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER + " launched");
			} else {
				System.out.println("Invalid Browser Name");
			}

			wUtil.maximizeWindow(driver);
			wUtil.implicitWait(driver);
			
			// Step 4: Load the URL
			driver.get(URL);

			// Step 5: Login To Application
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);

			// Step 6: click on Organization
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();

			// Step 7: Click on Create Organization look Up Image
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnOrganizationLookUpImg();
Thread.sleep(2000);
			// Step 8: Create new Organization with Mandatory fields
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createOrganization(ORGNAME, INDUSTRYNAME);
			wUtil.takesScreenshot(driver, ORGNAME);
			Thread.sleep(2000);
			// Step 9: Validate for Organization
			 OrganizationInformationPage oip= new OrganizationInformationPage(driver);
			String orgHeader = oip.getHeaderText();
			if (orgHeader.contains(ORGNAME)) {
				System.out.println(orgHeader);
				System.out.println("Organization Created");
			} else {
				System.out.println("FAIL");
			}
			
			//Step 10: Logout
			hp.logoutOfApp(driver);
}
		@DataProvider
		public Object[][] getData() throws EncryptedDocumentException, IOException  {
			return eUtil.readMultipleData("multipleOrganisation");
		}
	
}
