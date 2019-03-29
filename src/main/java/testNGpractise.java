import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGpractise {
	
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("@BeforeSuite-this runs at the very begginging");
	}@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest-this runs once before class runs");
	}@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass-this runs before every befor method is run");
	}@BeforeMethod
	public void beforeMethod() {
		System.out.println("this runs before every at test");
	}@Test
	public void atTest() {
		System.out.println("@Test-this is the main test method");
	}@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod-this runs after the at test is run");
	}@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass-this runs after the after method");
	}@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest-this runs after the every after class is run");
	}@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite-this runs at the very last");
	}@Test(invocationCount=2)
	public void atTest1() {
		System.out.println("@Test1-this is another main test method");
	}
	

}
