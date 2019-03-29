import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TC_004_DatePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/datepicker/");
		d.switchTo().frame(0);
		Actions act=new Actions(d);
		 d.findElement(By.xpath("//input[@class='hasDatepicker']")).click();
		 WebElement calendar = d.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		
		WebElement prev = d.findElement(By.xpath("//span[text()='Prev']"));
		act.moveToElement(calendar).pause(4000).moveToElement(prev).click().build().perform();
		
		WebElement date = d.findElement(By.xpath(("//a[text()='6']")));
		act.moveToElement(date).pause(2000).click(date).build().perform();

	}

}
