package organizationTests;

import org.testng.Assert;

import gernericUtilities.BaseClass;
import gernericUtilities.ExcelFileUtility;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateOrganization extends BaseClass {

	public void createOrg() {
		String ORGNAME= eUtil.readDataFromExcelSheet("organisation",1,2)+jUtil.readDataFromPropertyFile("");
		
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
	}
}
