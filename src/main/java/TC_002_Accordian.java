import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Verify;

public class TC_002_Accordian {

	public static void main(String[] args) throws AWTException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.get("https://jqueryui.com/draggable/");
		
		WebElement frame = d.findElement(By.xpath("//iframe[@class='demo-frame']"));
		d.switchTo().frame(frame);
		
		WebElement drag = d.findElement(By.xpath("//div[@id='draggable']"));
		//WebElement drop = d.findElement(By.xpath("//div[@id='droppable']"));
		Actions act=new Actions(d);
	
		 int x = drag.getLocation().getX();
		 int y = drag.getLocation().getY();
		 System.out.println(x+" "+y);
		 act.dragAndDropBy(drag, x+75, y+100).build().perform();
		/*act.dragAndDrop(drag, drop).build().perform();
		
		String text = drop.getText();
		
		System.out.println(text);*/
		
	}

}
