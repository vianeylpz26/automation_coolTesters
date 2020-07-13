package cemexgo.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.CommonsMethods;
import login.cemexgo.Login;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class FirstTest {

	String url, user, password, language;
	WebDriver driver;
	
	@BeforeTest
	public void readJSON() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
		Object obj = parser.parse(new FileReader("json\\firstTest\\credentials.json"));
		JSONObject jsonObject = (JSONObject) obj;
		url = (String) jsonObject.get("url");
		user = (String) jsonObject.get("user");
		password = (String) jsonObject.get("password");
		language = (String) jsonObject.get("language");

	}

	@Parameters({ "Browser" })
	@Test
	public void loginCemexgo(String browser) throws Exception {

		driver = CommonsMethods.StartDriver(url, browser);
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginCemexgo(user, password, language);
	
	}

	@Parameters({ "Browser2" })
	@Test
	public void loginCemexgoFailure(String browser) throws Exception {

		driver = CommonsMethods.StartDriver(url, browser);
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginCemexgo(user, password, language +"Test");
		
		
		}
	
	@AfterMethod(alwaysRun = true)
    public void closeBrowser(){
		if(driver!=null) {
		driver.close();
		}
        
    }
}	