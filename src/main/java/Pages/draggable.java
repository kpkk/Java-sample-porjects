package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class draggable {
	public WebDriver driver;
	
	public draggable() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.CLASS_NAME, using= "demo-frame") 
	WebElement ele;
	public draggable switchToFrame() {
		driver.switchTo().frame(ele);
		return this;
	}
	
	@FindBy(how=How.ID,using="dem-frame")
	WebElement dragEle;
	public draggable dragElement() {
		Actions act=new Actions(driver);
		act.dragAndDropBy(dragEle, 100, 250);
		return this;
	}
}
