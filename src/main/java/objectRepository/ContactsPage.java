package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//decleartion
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createContactLookupImg;

//initialization
public ContactsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

//utilization
public WebElement getCreateContactLookupImgElement() {
	return createContactLookupImg;
}

//Business Library
public void clickOnCreateContactLookUpImg() {
	createContactLookupImg.click();
}
}