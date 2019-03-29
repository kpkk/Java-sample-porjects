import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TC_003Selectable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/selectable/");
		d.switchTo().frame(0);
		
		List<WebElement> List = d.findElements(By.xpath("//li[@class='ui-widget-content ui-selectee']"));
		Iterator<WebElement> itr = List.iterator();
		Actions act=new Actions(d);
		while(itr.hasNext()) {
			act.clickAndHold(itr.next()).build().perform();
		}
		
		/*WebElement first = d.findElement(By.xpath("//ol[@id='selectable']//li"));
		WebElement second = d.findElement(By.xpath("(//li[@class='ui-widget-content ui-selectee'])[2]"));
		WebElement third = d.findElement(By.xpath("(//li[@class='ui-widget-content ui-selectee'])[3]"));
		Actions act=new Actions(d);
		act.clickAndHold(first).build().perform();
		act.clickAndHold(second).build().perform();
		
		act.clickAndHold(third).click().build().perform();*/
		

	}

}
