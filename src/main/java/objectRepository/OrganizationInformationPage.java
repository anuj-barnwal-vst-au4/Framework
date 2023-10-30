package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	//decleartion
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement OrgHeaderText;

//initialization
public OrganizationInformationPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

//utilization
public WebElement getOrgHeaderText() {
	return OrgHeaderText;
}

//business library
/**
 * This method will capture the header text and return it to caller
 * @return
 */
public String getHeaderText() {
	return OrgHeaderText.getText();
}
}
