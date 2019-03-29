package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webDriverMethods.DemoAppCommonMethods;
import webDriverMethods.WebDriverMethodsImplementation;

public class Registerpage extends WebDriverMethodsImplementation {
	
	/*@BeforeTest
	public void testCaseAttributes() {
		testCaseName="DemoAppCommonMethods";
		author="pradeep";
		category="smoke";
		description="navigate to register page";
		
	}*/
	
	@Test
	public void NavigateToRegister() {
		startApplication("chrome", "http://demo.automationtesting.in/Index.html");
		//WebElement arrow = driver.findElement(By.xpath("//img[@id='enterimg']"));
		WebElement arrow=identifyElement("xpath","//input[@id='email']/following::a");
		click(arrow);
		//WebElement FName = driver.findElement(By.xpath("//input[@type='text']"));
		WebElement FName=identifyElement("xpath","//input[@type='text']" );
		type(FName, "pradeep");
		
	}

}
