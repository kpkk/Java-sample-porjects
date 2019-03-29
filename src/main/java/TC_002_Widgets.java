import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_002_Widgets {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
         RemoteWebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.navigate().to("http://demo.automationtesting.in/Accordion.html");
		
        List<WebElement> AccordianList = d.findElements(By.xpath("//h4[@class='panel-title']"));
        
        for(WebElement EachAccordianList: AccordianList) {
        	EachAccordianList.click();
        	Thread.sleep(2000);
        }
        
        //auto complete
        
        WebElement widget = d.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
        
        Actions a=new Actions(d);
        
        a.moveToElement(widget).pause(2000).click(d.findElement(By.xpath("//a[text()=' AutoComplete ']"))).build().perform();
        
        WebElement searchBox = d.findElement(By.xpath("//span[@class='ui-helper-hidden-accessible']/following::div"));
        
       
        a.moveToElement(searchBox).click().sendKeys("in").build().perform();
        a.click(d.findElement(By.xpath("//a[text()='Argentina']"))).perform();
        
        a.moveToElement(searchBox).click().sendKeys("ab").build().perform();
        a.click(d.findElement(By.xpath("//a[text()='Gabon']"))).build().perform();
        
        d.findElement(By.xpath("(//div[@class='ui-autocomplete-multiselect-item']//span)[2]")).click();
        
        JavascriptExecutor js=(JavascriptExecutor) d;
      
      //  js.executeScript("window.scrollBy(0,1000)");
        WebElement widgetEle = d.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
        
     //   js.executeScript("arguments[0].scrollIntoView();", widgetEle);
        
        WebElement home = d.findElement(By.xpath("//a[text()='Home']"));
        //vertical scroll
        js.executeScript("window.scrollBy(0,1000)");
        //horizontal scroll
        js.executeScript("window.scrollBy(1000,0)");
        
        
        //date Picker
        WebElement widgetDate = d.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
        WebElement datePick = d.findElement(By.xpath("//a[text()=' Datepicker ']"));
        
        a.moveToElement(widgetDate).pause(2000).click(datePick).build().perform();
        
        WebElement datePick1 = d.findElement(By.xpath("//input[@id='datepicker1']"));
        boolean enabled = datePick1.isEnabled();
        System.out.println(enabled);
        datePick1.click();
        
        WebElement dates = d.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
        
        WebElement date = d.findElement(By.xpath("//a[text()='20']"));
      //  a.moveToElement(dates).pause(2000).click(date).perform();
      //  d.findElement(By.xpath("//a[text()='20']")).click();
        
        WebElement datePick2 = d.findElement(By.xpath("//input[@id='datepicker2']"));
        datePick2.click();
        
        WebElement month = d.findElement(By.xpath("//select[@class='datepick-month-year']"));
        
        Select s=new Select(month);
        
        s.selectByValue("5/2019");
        
        WebDriverWait wait=new WebDriverWait(d,30);
        
        WebElement dateMay = d.findElement(By.xpath("//a[@class='dp1557297000000']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='dp1557297000000']")));
        
        Thread.sleep(5000);
        a.moveToElement(dateMay).pause(2000).click().build().perform();
       // d.findElement(By.xpath("//a[@class='dp1557297000000']")).click();
        WebElement scrollFb = d.findElement(By.xpath("(//div[@class='row']//a)[3]"));
        
        js.executeScript("arguments[0].window.scrollintoView();",scrollFb);
        
        js.executeScript("window.scrollBy(0,-1000)");
        
        //slider
        
        WebElement slidemenu = d.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
        
        a.moveToElement(slidemenu).pause(2000).click(d.findElement(By.xpath("//a[text()=' Slider ']"))).build().perform();
        
        WebElement slidebar = d.findElement(By.xpath("//div[@id='slider']//a"));
        
        a.clickAndHold(slidebar).dragAndDropBy(slidebar, 0, 200);
        
       
        
        
        
        
	}
        
        
        
	}


