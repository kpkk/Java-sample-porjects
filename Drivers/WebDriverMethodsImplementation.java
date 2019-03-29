package webDriverMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class WebDriverMethodsImplementation extends Reporter implements Wdmethods {
	
	public RemoteWebDriver driver;
	Actions act;
	

	@Override
	public void startApplication(String browser, String url)  {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver=new ChromeDriver();
				
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
			else if(browser.equalsIgnoreCase("internetexplorer")) {
				System.setProperty("webdriver.internetexplorer.driver", "./Drivers/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				
			}
			else {
				System.setProperty("webdriver.safari.driver", "./Drivers/safaridriver.exe");
				driver=new SafariDriver();
			}
			
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(url);
				
			
		} catch (WebDriverException e) {
			
				System.err.println("browser window couldn't launch");
			
		}
		
		
			}
		finally {
			takePicture();
		}
		
	}

	@Override
	public WebElement identifyElement(String locator, String locValue)   {
		
		try {
			switch (locator) {
			case "id": driver.findElement(By.id(locValue));
			case "name": driver.findElement(By.name(locValue));
			case "class": driver.findElement(By.className(locValue));
			case "tagName": driver.findElement(By.tagName(locValue));
			case "linkText": driver.findElement(By.linkText(locValue));
			case "partialLinkText": driver.findElement(By.partialLinkText(locValue));
			case "xpath": driver.findElement(By.xpath(locValue));
			case "cssSelector": driver.findElement(By.cssSelector(locValue));
			}
		} 
		catch (InvalidSelectorException e) {
			
				System.err.println("invalidSelectorException has occurred for given  "+locator +" and "+locValue, "fail");
			
			}
		}catch (NoSuchElementException e) {
			
			System.err.println("No element with "+locator +" and "+locValue+" wasn't found", "fail");
			
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+locator +" and "+locValue+" element would have either not attached to the DOM or re-generated", "fail");
			
		}
		finally {
			takePicture();
		}
		
		return null;
	}

	@Override
	public WebElement identifyElementWithId(String locValue)  {
		try {
			driver.findElement(By.id(locValue));
		}catch (InvalidSelectorException e) {
			
			System.err.println("invalidSelectorException has occurred for given Id and its value "+locValue, "fail");
			
		}catch (NoSuchElementException e) {
			
			System.err.println("No element with id and value "+locValue+" was found", "fail");
			} 
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+locValue+" element would have either not attached to the DOM or re-generated", "fail");
			
		}
		finally {
			takePicture();
		}
		return null;
	}

	@Override
	public List<WebElement> identifyElements(String locator, String locValue)  {
		
		try {
			switch (locator) {
			case "id": driver.findElements(By.id(locValue));
			case "name": driver.findElements(By.name(locValue));
			case "class": driver.findElements(By.className(locValue));
			case "tagName": driver.findElements(By.tagName(locValue));
			case "linkText": driver.findElements(By.linkText(locValue));
			case "partialLinkText": driver.findElements(By.partialLinkText(locValue));
			case "xpath": driver.findElements(By.xpath(locValue));
			case "cssSelector": driver.findElements(By.cssSelector(locValue));
			}
		} 
		catch (InvalidSelectorException e) {
			
			System.err.println("invalidSelectorException has occurred for given  "+locator +" and "+locValue, "fail");
			
		}catch (NoSuchElementException e) {
			
			System.err.println("No element with "+locator +" and "+locValue+" wasn't found", "fail");
			
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+locator +" and "+locValue+" element would have either not attached to the DOM or re-generated", "fail");
			
		}
		finally {
			takePicture();
		}
		return null;
	}

	@Override
	public void type(WebElement ele, String value)  {
		try {
		ele.sendKeys(value);
		
		System.err.println(value+"was successfully enetered in the given "+ele, "pass");
		
		}
		catch (NoSuchElementException e) {
			
			System.err.println("No element  "+ele +" found to type "+value, "fail");
			
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred can't find the element"+ele+" to type "+value, "fail");
			
		catch(Exception e1 ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		}
	}

	@Override
	public void click(WebElement ele) {
		try {
		ele.click();
		}catch(NoSuchElementException e) {
			System.err.println("no such element found to click"+e.getMessage());
		}catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public void pickFromDropDown(WebElement ele, String textValue) {
		try {
			Select s=new Select(ele);
			s.selectByVisibleText(textValue);
		} catch(NoSuchElementException e) {
			System.err.println("no such element found to type in the value"+e.getMessage());
		}catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public void pickFromDropDownByIndex(WebElement ele, int index) {
		try {
			Select s=new Select(ele);
			s.selectByIndex(index);
		} catch(NoSuchElementException e) {
			System.err.println("no such element found to type in the value"+e.getMessage());
		}catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expText) {
		  boolean verify=false;
			String text = ele.getText();
			 verify=text.equals(expText);
				return verify;
			
	
		
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expText) {
		boolean verifyPar=false;
		String text = ele.getText();
		verifyPar=text.contains(expText);
			return verifyPar;
		
	}

	@Override
	public String getText(WebElement ele) {
		try {
			String text = ele.getText();
		}catch(NoSuchElementException e) {
			System.err.println("no such element found to type in the value"+e.getMessage());
		}catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
		return null;
	}

	@Override
	public String getAttributeValue(WebElement ele, String attribute, String attributeValue) {
		try {
			String attributeCurrentValue = ele.getAttribute(attributeValue);
		}catch(NoSuchElementException e) {
			System.err.println("no such element found to type in the value"+e.getMessage());
		}catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		return null;
	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.err.println("no alert was present to switch the focus"+e.getMessage());
			e.printStackTrace();
		}catch (UnhandledAlertException e) {
			System.err.println(" alert was not handled properly "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			System.err.println("no alert was present to switch the focus"+e.getMessage());
			e.printStackTrace();
		}catch (UnhandledAlertException e) {
			System.err.println(" alert was not handled properly "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public String getAlertText() {
		try {
			driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			System.err.println("no alert was present to switch the focus"+e.getMessage());
			e.printStackTrace();
		}catch (UnhandledAlertException e) {
			System.err.println(" alert was not handled properly "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		return null;
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			System.err.println("no such frame present to switch the focus"+ e.getMessage());
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
	}

	@Override
	public void switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.err.println("no such frame present to switch the focus"+ e.getMessage());
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public void switchBacktoDeafutlWindow() {
		try {
			driver.switchTo().defaultContent();
		} catch (NoSuchWindowException e) {
			System.err.println("no such frame present to switch the focus"+ e.getMessage());
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		for(int i=0;i<=1000;i++) {
			try {
				FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./Snaps/Image"+i+".jpg"));
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("can't store the screenshot in the specified path"+e.getMessage());
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public String getWindowhandle() {
	try {
		String windowHandle = driver.getWindowHandle();
	} catch (WebDriverException e) {
		System.err.println("no such frame present to switch the focus"+ e.getMessage());
		e.printStackTrace();
	}catch(Exception e ) {
		System.err.println("unknown error occurred"+e.getMessage());
	}
	finally {
		takePicture();
	}
		return null;
	}

	@Override
	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return null;
	}

	@Override
	public void closewindow() {
		driver.close();
		
	}

	@Override
	public void closeAllWindows() {
		driver.quit();
		
	}

	@Override
	public void dragNdrop(WebElement sourceEle,WebElement destEle) {
		 
		act=new Actions(driver);
		act.dragAndDrop(sourceEle, destEle).build().perform();
		
	}

	@Override
	public void dragNdropByOffSet(WebElement sourceEle, int x, int y) {
		
		 new Actions(driver).dragAndDropBy(sourceEle, x, y).build().perform();
		
	}

	@Override
	public void clickHold(WebElement ele) {
		act=new Actions(driver);
		act.clickAndHold(ele).build().perform();
		
	}

	@Override
	public void release(WebElement ele) {
		act=new Actions(driver);
		act.release(ele).build().perform();
		
	}

	@Override
	public void hoverOverThenClickAnother(WebElement moveEle, WebElement clickEle) {
		act=new Actions(driver);
		act.moveToElement(moveEle).pause(3000L).click(clickEle).build().perform();
		
	}

	@Override
	public void slider(WebElement ele, int x, int y) {
		act=new Actions(driver);
		act.clickAndHold(ele).dragAndDropBy(ele, x, y).build().perform();
		
	}

	@Override
	public boolean isDisplayed(WebElement ele) {
		boolean value= false;
		value= ele.isDisplayed();
		return value;
	}

	@Override
	public boolean isSelected(WebElement ele) {
		boolean select= false;
		select=ele.isSelected();
		return select;
	}

	@Override
	public boolean isEnabled(WebElement ele) {
		boolean enable= false;
		enable=ele.isEnabled();
		return enable;
	}

	@Override
	public void switchToWindow(int index) {
	
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
	}

	@Override
	public boolean verifyAttributeValue(WebElement ele, String attribute, String attributeValue,String expAttrValue) {
		boolean attriVal=false;
		attribute=ele.getAttribute(attributeValue);
		attriVal=expAttrValue.equals(attribute);
		return attriVal;
	}

	@Override
	public void typeInAlert(String text) {
	driver.switchTo().alert().sendKeys(text);
		
	}

}
