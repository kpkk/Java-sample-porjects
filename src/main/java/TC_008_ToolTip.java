import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TC_008_ToolTip {

	@Test
	public void toolTip(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://jqueryui.com/tooltip/");
		d.switchTo().frame(0);
		Actions act=new Actions(d);
        WebElement age = d.findElement(By.xpath("//input[@id='age']"));
      //  age.sendKeys("25");
        act.moveToElement(age).build().perform();
        WebElement tooltip = d.findElement(By.xpath("//div[@class='ui-tooltip-content']"));
       System.out.println(tooltip.isDisplayed());
       System.out.println(tooltip.getText());
       
       
	}

}
