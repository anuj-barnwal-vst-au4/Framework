package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
//rule1- declaration
@FindBy(name= "user_name")
private WebElement user_nameEdt;

@FindBy(name="user_password")
private WebElement user_passwordEdt;

@FindAll({@FindBy(id="submitButton"),@FindBy(xpath ="//input[@type='submit']")})
private WebElement loginBtn;

//rule2-Initialization
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//rule-3 Utilization
public WebElement getUser_nameEdt() {
	return user_nameEdt;
}

public WebElement getUser_passwordEdt() {
	return user_passwordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

//Business library-generic method according to need of project
/**
 * This method will use to login in application
 * @param USERNAME
 * @param PSWRD
 */
	
public void loginToApp(String UN, String PWD) {
	user_nameEdt.sendKeys(UN);
	user_passwordEdt.sendKeys(PWD);
	loginBtn.click();
}
}
