import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TC_005_Menu {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.navigate().to("https://jqueryui.com/menu/");
		d.switchTo().frame(0);
		WebElement elec = d.findElement(By.xpath("//div[@id='ui-id-4']"));
		Actions act=new Actions(d);
		WebElement homeE = d.findElement(By.xpath("//div[@id='ui-id-5']"));
		System.out.println(homeE.isEnabled());
		WebElement carHifi = d.findElement(By.xpath("//div[@id='ui-id-6']"));
		
		act.moveToElement(elec).pause(2000).click(carHifi).build().perform();

	}

}
