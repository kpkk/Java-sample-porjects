package ashleyDemoTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import webDriverMethods.WebDriverMethodsImplementation;

public class TC_002_NavigateThroughFurniture extends WebDriverMethodsImplementation {

 @Test
	public void furnitureview() throws InterruptedException {
		
		startApplication("chrome", "https://www.ashleyfurniture.com/");
		
		WebElement furniture = identifyElement("xpath", "//div[@class='off-canvas-nav-show']/following-sibling::ul//a");
		WebElement nightStands = identifyElement("xpath", "//a[text()='Nightstands']");
		hoverOverThenClickAnother(furniture, nightStands);
		WebElement sortByDropDown = identifyElement("xpath", "//select[@id='grid-sort-footer']");
		pickFromDropDownByText(sortByDropDown, "New Arrivals");
		
		List<WebElement> identifyElements = identifyElements("xpath", "//a[@class='thumb-link']");
		System.out.println(identifyElements.size());
		
		List<WebElement> priceList = identifyElements("xpath", "//span[@class='product-sales-price']");
		System.out.println(priceList.size());
		
		ArrayList<Integer> allPrices=new ArrayList<Integer>();
		Thread.sleep(5000L);
		for(WebElement eachPrice: priceList) {
			String text = eachPrice.getText();
			String replaceAll = text.replaceAll("\\D", "");
			//float parseFloat = Float.parseFloat(replaceAll);
			int priceNumber = Integer.parseInt(replaceAll);
			allPrices.add(priceNumber);
		}
		
		System.out.println(allPrices);
		
		
		int max = Collections.max(allPrices);
		System.out.println(max);
		WebElement maxPriceItem = identifyElement("xpath", "//span[contains(text(),'"+max+"')]/preceding::div[3]/a");
		
		click(maxPriceItem);
		
		
		

		
	}
}
