package login.cemexgo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonsMethods;



public class Login extends CommonsMethods {
	
	
	@FindBy(xpath="//input[contains(@id,'username-field')] | //input[contains(@id,'username')]") 
	WebElement txt_userName;
	@FindBy(xpath="//input[@formcontrolname='password'] | //input[@id='password'] ")
	WebElement txt_password;
	@FindBy(xpath="//*[contains(@id,'btn')]")
	WebElement btn_login;
	@FindBy(xpath=" //*[contains(@data-tid,\"languages\")]") 
	WebElement link_language;
	@FindBy(xpath="//*[contains(@data-tid,'cmx-login-languages-item')]")
	List<WebElement> list_language;
	@FindBy(xpath="//*[contains(@id,'ashboard-container')]")
	WebElement header;
	
	public Login(WebDriver driver) {
	    super(driver);
	}
	
	public void loginCemexgo(String userName, String password, String language) throws Exception {
		clickObject(link_language);
		selectElementByValue(list_language, language);
		setText(txt_userName, userName);
		setText(txt_password, password);
		clickObject(btn_login);
		reviewElement(header);
		takeScreenShot("Home");
	}
	

	
	
}
