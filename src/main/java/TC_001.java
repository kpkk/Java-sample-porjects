import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

import cucumber.api.Argument;
import org.junit.Assert;

public class TC_001 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		
		RemoteWebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.navigate().to("http://demo.automationtesting.in/Index.html");
		
		d.findElement(By.xpath("//input[@id='email']/following::a")).click();
		
		String title = d.getTitle();
		
		Verify.verify(true, "Register");
		//Assert.assertEquals(title, "Register");
		
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("pradeep");
		d.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("kadarla");
		d.findElement(By.xpath("//label[text()='Address']/following::textarea")).sendKeys("Navallur, OMR");
		
		d.findElement(By.xpath("//input[@type='email']")).sendKeys("user@mail.com");
		d.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876531");
		WebElement gender = d.findElement(By.xpath("//input[@name='radiooptions']"));
		System.out.println(gender.isSelected());
		gender.click();
		
		d.findElement(By.xpath("//input[@id='checkbox3']")).click();
		 d.findElement(By.xpath("//div[@id='msdd']")).click();
		 
		 Actions a=new Actions(d);
		 a.moveToElement(d.findElement(By.xpath("//a[text()='Catalan']"))).pause(2000).click().build().perform();
		
		a.moveToElement(d.findElement(By.xpath("//a[text()='English']"))).click().build().perform();
		
		WebElement skill = d.findElement(By.xpath("//select[@id='Skills']"));
		
		Select skillBox=new Select(skill);
		
		List<WebElement> SkillOptions = skillBox.getOptions();
		
		System.out.println(SkillOptions.size());
		
		skillBox.selectByIndex(SkillOptions.size()-2);
		
		WebElement Country = d.findElement(By.xpath("//select[@id='countries']"));
		
		Select CountryBox=new Select(Country);
		
		CountryBox.selectByVisibleText("Argentina");
		
		WebElement SelectCountry = d.findElement(By.xpath("//span[@class='selection']/span"));
		
       SelectCountry.sendKeys("Denmark");
       
       /*//List<WebElement> countryList = SelectCountryBox.getOptions();
       
       JavascriptExecutor js=(JavascriptExecutor)d;
       js.executeScript("arguments[0].scrollIntoView(true);", countryList.get(17));*/
       
       WebElement year = d.findElement(By.xpath("//select[@id='yearbox']"));
       
       Select yearBox=new Select(year);
       yearBox.selectByValue("1917");
       
       WebElement month = d.findElement(By.xpath("(//select[@type='text'])[4]"));
       
       Select monthBox=new Select(month);
       monthBox.selectByValue("January");
       
       WebElement day = d.findElement(By.xpath("//select[@id='daybox']"));
       
       Select DayBox=new Select(day);
       DayBox.selectByVisibleText("15");
       
       d.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("ABCD12");
       
       d.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("ABCD12");
       
       d.findElement(By.xpath("//button[@id='submitbtn']")).submit();
       
       //2nd page
       d.findElement(By.xpath("//a[text()='WebTable']")).click();
       
       WebElement webTable = d.findElement(By.xpath("//div[@class='ui-grid-contents-wrapper']"));
       
       List<WebElement> rows = webTable.findElements(By.tagName("div"));
       System.out.println(rows.size());
       int index=0;
       for(WebElement cols: rows) {
    	   String text = rows.get(index).getText();
    	   System.out.println(text);
    	   index++;
    	   /*List<WebElement> cols = webTable.findElements(By.tagName("div"));
    	  
    	   System.out.println(cols.get(i).getText());*/
       }
       
       a.doubleClick(d.findElement(By.xpath("//div[@class='avddbl']//button"))).perform();
       
    
     d.findElement(By.xpath("//input[@type='text']")).sendKeys("abc");
       d.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("abc");
       boolean enabled = d.findElement(By.xpath("//button[text()='Save']")).isEnabled();
       System.out.println(enabled);
       WebDriverWait wait=new WebDriverWait(d, 10);
       
       
       
       wait.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("(//button[text()='Cancel'])[2]"))));
        d.findElement(By.xpath("(//button[text()='Cancel'])[2]")).click();
       Thread.sleep(5000);
       a.contextClick(d.findElement(By.xpath("//div[@class='contextshw']//preceding::del-click//i"))).perform();
       d.findElement(By.xpath("//button[text()='Cancel']")).click();
       
       //3rd page
       
       WebElement switchTo = d.findElement(By.xpath("//a[text()='SwitchTo']"));
       
       a.moveToElement(switchTo).pause(3000).click(d.findElement(By.xpath("//a[text()='Alerts']"))).build().perform();
       
       d.findElement(By.xpath("//li[@class='active']//a")).click();
       d.findElement(By.xpath("//div[@id='OKTab']//button")).click();
       
       String text = d.switchTo().alert().getText();
       
       System.out.println(text);
       d.switchTo().alert().accept();
       
       d.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
       
       d.findElement(By.xpath("//div[@id='CancelTab']//button")).click();
       
       String text2 = d.switchTo().alert().getText();
       
       System.out.println(text2);
       
       d.switchTo().alert().accept();
       
       d.findElement(By.xpath("//div[@id='CancelTab']//button")).click();
       
       d.switchTo().alert().dismiss();
       String text3 = d.findElement(By.xpath("//p[@id='demo']")).getText();
       Assert.assertTrue(text3, text3.contains("You Pressed Cancel"));
       Thread.sleep(3000);
       d.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
       
      
       
       d.findElement(By.xpath("//div[@id='Textbox']//button")).click();
       
       String popUpMessage = d.switchTo().alert().getText();
       
       System.out.println(popUpMessage);
       d.switchTo().alert().sendKeys("pradeep");
       d.switchTo().alert().accept();
       
       String alertconfirmMessage = d.findElement(By.xpath("//p[@id='demo1']")).getText();
       
       System.out.println(alertconfirmMessage);
       String expmessage="Hello pradeep How are you today";
       Assert.assertEquals(alertconfirmMessage, expmessage);
       Thread.sleep(2000);
       
       WebElement switchToTab = d.findElement(By.xpath("//a[@class='dropdown-toggle']"));
       a.moveToElement(switchToTab).pause(3000).click(d.findElement(By.xpath("//a[text()='Windows']"))).build().perform();
       
       d.findElement(By.xpath("//div[@id='Tabbed']/a/button")).click();
       
       Set<String> windowHandles = d.getWindowHandles();
       
       ArrayList<String> ListOfWindows=new ArrayList<String>(windowHandles);
       
       d.switchTo().window(ListOfWindows.get(ListOfWindows.size()-1));
       String title2 = d.getTitle();
       
       System.out.println("title2");
       List<WebElement> links = d.findElements(By.tagName("a"));
       
       for(WebElement eachLink: links) {
    	   String LinkText = eachLink.getText();
    	   System.out.println(LinkText);
       }
       
       d.switchTo().window(ListOfWindows.get(0));
       d.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
       d.findElement(By.xpath("//button[text()='click']")).click();
       
       Set<String> windowHandles2 = d.getWindowHandles();
       ListOfWindows.clear();
       ListOfWindows.addAll(windowHandles2);
       
       d.switchTo().window(ListOfWindows.get(1));
       System.out.println(d.getCurrentUrl());
       d.switchTo().window(ListOfWindows.get(0));
       d.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
       d.findElement(By.xpath("//div[@id='Multiple']/button")).click();
       Set<String> windowHandles3 = d.getWindowHandles();
       
       ListOfWindows.clear();
       ListOfWindows.addAll(windowHandles3);
       int size = windowHandles3.size();
       System.out.println(size);
       d.switchTo().window(ListOfWindows.get(size-1));
       d.switchTo().window(ListOfWindows.get(0));
       
       WebElement switchToTab2 = d.findElement(By.xpath("//a[@class='dropdown-toggle']"));
       a.moveToElement(switchToTab2).pause(2000).click(d.findElement(By.xpath("//a[text()='Frames']"))).build().perform();
       
       WebElement frame = d.findElement(By.xpath("//iframe[@name='SingleFrame']"));
       
       d.switchTo().frame(frame);
       d.findElement(By.xpath("//div[@class='row']//input")).sendKeys("pradeep");
       
       d.switchTo().defaultContent();
       d.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
       
       WebElement OuterFrame = d.findElement(By.xpath("//div[@id='Multiple']/iframe"));
       
       d.switchTo().frame(OuterFrame);
       
       WebElement innerFrame = d.findElement(By.xpath("//div[@class='container']//iframe"));
       d.switchTo().frame(innerFrame);
       d.findElement(By.xpath("//div[@class='row']//input")).sendKeys("kumar");
       d.switchTo().frame(0);
       d.switchTo().defaultContent();
       d.quit();
       
		
		
		

	}

}
