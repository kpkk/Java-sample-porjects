import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TC_006_Spinner {

	
		@Test
		public void sppinner() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/spinner/");
		d.switchTo().frame(0);
		WebElement selectValue = d.findElement(By.xpath("//input[@id='spinner']"));
		selectValue.sendKeys("111");
		WebElement upwards = d.findElement(By.xpath("//input[@id='spinner']/following::a"));
		
		Actions act=new Actions(d);
		
		act.clickAndHold(upwards).pause(5000).release().build().perform();
		WebElement toggleDisable = d.findElement(By.xpath("//button[@id='disable']"));
		toggleDisable.click();
		boolean enabled = selectValue.isEnabled();
		System.out.println(enabled);
		WebElement toggleWidget = d.findElement(By.xpath("//button[@id='destroy']"));
		toggleWidget.click();
		toggleWidget.click();
		WebElement popUpValue = d.findElement(By.xpath("//button[@id='getvalue']"));
		popUpValue.click();
		String text = d.switchTo().alert().getText();
		System.out.println(text);
		d.switchTo().alert().accept();
		
		
		
		
		

	}

}
