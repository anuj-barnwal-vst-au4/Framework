package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
//Decleration
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement createOrgLookUpImg;

//initialization
public OrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
//utilization

public WebElement getCreateOrgLookUpImg() {
	return createOrgLookUpImg;
}
//Business Library
/**
 * This method will click on create org look up image
 */
public void clickOnOrganizationLookUpImg() {
	createOrgLookUpImg.click();
}

public String getHeaderText() {
	// TODO Auto-generated method stub
	return null;
}
}
