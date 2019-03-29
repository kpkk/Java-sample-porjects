package ashleyDemoTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_AddToCart {
	
	
	
	@Test(dataProvider="ExcelDataProvider")
	public void addToCart(String item, String qty) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ashleyfurniture.com/");
		//driver.findElement(By.xpath("//div[@class='layer-wiziwig']//font")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("//input[@id='q']")).sendKeys(item,Keys.ENTER);
		driver.findElement(By.xpath("(//img[@class='alternate-image'])[2]")).click();
		
		driver.findElement(By.xpath("//a[text()='Check Availability']")).click();
	
		driver.findElement(By.xpath("//input[@name='dwfrm_zipcodeentry_postal']")).sendKeys("60610",Keys.TAB);
		driver.findElement(By.xpath("//button[@name='dwfrm_zipcodeentry_update']")).click();
		//driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		
		
//	driver.findElement(By.xpath("//div[@class='pushcrew-https-branding-modal-context-box']//a")).click();
	Thread.sleep(3000);
	WebElement quantity = driver.findElement(By.xpath("//select[@name='Quantity']"));
	
		Select s=new Select(quantity);
		
		s.selectByValue(qty);
		
		
		
		
	}
	
	
	
	@DataProvider(name="ExcelDataProvider")
	public Object[][] feedData() throws IOException{
		return ReadFromExcel.readExcel("Data");
		
	}
	
		
	}



