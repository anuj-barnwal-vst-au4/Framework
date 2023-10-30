package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//decleartion
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	
	//initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getcontactHeaderText() {
		return contactHeaderText;
	}

	/**
	 * This method will capture the header and return it to caller
	 * @return
	 */
	public String getHeadertext() {
		return contactHeaderText.getText();
	}
	
}
