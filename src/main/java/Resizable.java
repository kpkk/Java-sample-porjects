import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Resizable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/resizable/");
		d.switchTo().frame(0);
		WebElement resizeHandle = d.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		Point location = resizeHandle.getLocation();
		System.out.println(location);
		Actions act=new Actions(d);
		act.clickAndHold(resizeHandle).dragAndDropBy(resizeHandle, 150,150).build().perform();
		WebElement heading = d.findElement(By.xpath("//h3[@class='ui-widget-header']"));
		System.out.println(heading.getCssValue("color"));
		System.out.println(heading.getCssValue("background-color"));
		System.out.println(heading.getCssValue("font-size"));
		System.out.println(heading.getCssValue("font-family"));
		System.out.println(heading.getCssValue("text-align"));
		

	}

}
