import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TC_007_Tabs {

	@Test
	public  void tabs() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/tabs/");
		d.switchTo().frame(0);
		
		WebElement tab1 = d.findElement(By.xpath("//a[@id='ui-id-1']"));
		System.out.println(tab1.getText());
		String text = d.findElement(By.xpath("//div[@id='tabs-1']//p")).getText();
		System.out.println(text);
		WebElement tab2 = d.findElement(By.xpath("//a[@id='ui-id-2']"));
		tab2.click();
		System.out.println(tab2.getText());
		String text2 = d.findElement(By.xpath("//div[@id='tabs-2']//p")).getText();
		System.out.println(text2);
		
		WebElement tab3 = d.findElement(By.xpath("//a[@id='ui-id-3']"));
		tab3.click();
		System.out.println(tab3.getText());
		
		String text3 = d.findElement(By.xpath("//div[@id='tabs-3']//p")).getText();
		System.out.println(text3);
		JavascriptExecutor js=(JavascriptExecutor)d;
		//To scroll down to the bottom of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//to scroll vertically down based on pixel value, to scroll up we should use negative integer
		js.executeScript("window.scrollBy(0,1000)");
		//to scroll horizontally right based on pixel value, to scroll left we should use negative integer
		js.executeScript("window.scrollBy(1000,0)");
		//to scroll until a particular element is visible
	//	js.executeScript("arguments[0].scrollIntoView()", tab3);

	}

}
