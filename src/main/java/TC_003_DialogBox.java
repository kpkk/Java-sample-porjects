import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TC_003_DialogBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/dialog/");
		d.switchTo().frame(0);
		WebElement dragDialog = d.findElement(By.xpath("//span[text()='Basic dialog']"));
		Actions act=new Actions(d);
	//	act.clickAndHold(dragDialog).dragAndDropBy(dragDialog, 300, 500).build().perform();
		WebElement resize = d.findElement(By.xpath("//div[@id='dialog']//following::div"));
		act.clickAndHold(resize).dragAndDropBy(resize, 306, 38).build().perform();
		

	}

}
