package ashleyDemoTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webDriverMethods.WebDriverMethodsImplementation;

public class TC_003_RegisterUser extends WebDriverMethodsImplementation {
		
	@Test(dataProvider="fetchUserData")
	public void registerUser(String fname, String lname, String eMail,String confirmemail, String passwd,String confirmpwd) {
		
		startApplication("chrome", "https://www.ashleyfurniture.com/");
		WebElement account = identifyElement("xpath", "//a[@class='user-account']");
		click(account);
		WebElement createAccount = identifyElement("xpath", "//a[text()='Create Account']");
		WebElement Fname = identifyElement("xpath", "//input[@id='dwfrm_profile_customer_firstname']");
		type(Fname, fname);
		WebElement Lname = identifyElement("id", "dwfrm_profile_customer_lastname");
		type(Lname,lname );
		WebElement email = identifyElement("id", "dwfrm_profile_customer_email");
		type(email, eMail);
		WebElement confirmEmail = identifyElement("id", "dwfrm_profile_customer_emailconfirm");
		type(confirmEmail, confirmemail);
		WebElement pwd = identifyElement("id", "dwfrm_profile_login_password");
		type(pwd, passwd);
		WebElement confirmPwd = identifyElement("id", "dwfrm_profile_login_passwordconfirm");
		type(pwd, confirmpwd);
		WebElement checkBox = identifyElement("id", "dwfrm_profile_customer_ageconsent");
		System.out.println(isSelected(checkBox));
		click(checkBox);
		WebElement submit = identifyElement("name", "dwfrm_profile_confirm");
		click(submit);
	}
	
	
	@DataProvider(name="fetchUserData")
	public Object[][] feedData() throws IOException{
		return ReadFromExcel.readExcel("AshleyRegisterDetails");
		
	}
		
		
	}


