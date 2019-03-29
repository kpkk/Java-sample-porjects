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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class WebDriverMethodsImplementation implements Wdmethods {
	
	public RemoteWebDriver driver;
	Actions act;
	public int i=0;
	

	@Override
	public void startApplication(String browser, String url)  {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-Notifications");
				driver=new ChromeDriver(options);

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



		finally {
			takePicture();
		}

	}

	@Override
	public WebElement identifyElement(String locator, String locValue)   {
		
		try {
			switch (locator) {
			case ("id"): return driver.findElement(By.id(locValue));
			case ("name"):return driver.findElement(By.name(locValue));
			case ("class"):return driver.findElement(By.className(locValue));
			case "tagName":return driver.findElement(By.tagName(locValue));
			case "linkText":return driver.findElement(By.linkText(locValue));
			case "partialLinkText":return driver.findElement(By.partialLinkText(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "cssSelector":return driver.findElement(By.cssSelector(locValue));
			}
		} 
		catch (InvalidSelectorException e) {
			
			System.err.println("invalidSelectorException has occurred for given  "+locator +" and "+locValue);
			
		}
		catch(NoSuchElementException e) {
			
			System.err.println("No element with "+locator +" and "+locValue+" wasn't found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+locator +" and "+locValue+" element would have either not attached to the DOM or re-generated");
			
		}
		finally {
			takePicture();
		}
		
		return null;
	}

	@Override
	public WebElement identifyElementWithId(String locValue)  {
		try {
			return driver.findElement(By.id(locValue));
		}catch (InvalidSelectorException e) {
			
			System.err.println("invalidSelectorException has occurred for given Id and its value "+locValue);
			
		}catch (NoSuchElementException e) {
			
			System.err.println("No element with id and value "+locValue+" was found");
			
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+locValue+" element would have either not attached to the DOM or re-generated");
			
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
			case "id": return driver.findElements(By.id(locValue));
			case "name": return driver.findElements(By.name(locValue));
			case "class":return driver.findElements(By.className(locValue));
			case "tagName":return driver.findElements(By.tagName(locValue));
			case "linkText":return driver.findElements(By.linkText(locValue));
			case "partialLinkText":return driver.findElements(By.partialLinkText(locValue));
			case "xpath":return driver.findElements(By.xpath(locValue));
			case "cssSelector":return driver.findElements(By.cssSelector(locValue));
			}
		} 
		catch (InvalidSelectorException e) {
			
			System.err.println("invalidSelectorException has occurred for given  "+locator +" and "+locValue);
			
		}catch (NoSuchElementException e) {
			
			System.err.println("No element with "+locator +" and "+locValue+" wasn't found");
			
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+locator +" and "+locValue+" element would have either not attached to the DOM or re-generated");
			
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
		
		System.err.println(value+"was successfully enetered in the given "+ele);
		
		}
		catch (NoSuchElementException e) {
			
			System.err.println("No element  "+ele +" found to type "+value);
			
		}catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred can't find the element"+ele+" to type "+value);
		}
		catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
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
	public void pickFromDropDownByText(WebElement ele, String textValue) {
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
			try {
				String text = ele.getText();
				 verify=text.equals(expText);
			} catch (NoSuchElementException e) {
				System.err.println(ele+" no such element was found to verify text");
			}catch (StaleElementReferenceException e) {
				
				System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
				
			}finally {
				takePicture();
			}
				return verify;
			
	
		
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expText) {
		boolean verifyPar=false;
		try {
			String text = ele.getText();
			verifyPar=text.contains(expText);
		} catch (NoSuchElementException e) {
			System.err.println(ele+" no such element was found to verify partial text");
		}catch (StaleElementReferenceException e) {
			
			System.err.println("the element would have not attached to the DOM or re-generated"+e.getMessage());
			
		}finally {
			takePicture();
		}
			return verifyPar;
		
	}

	@Override
	public String getText(WebElement ele) {
		String text="";
		try {
			 text = ele.getText();
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
		
		return text;
	}

	@Override
	public String getAttributeValue(WebElement ele, String attributeValue) {
		String attributeCurrentValue="";
		try {
			 attributeCurrentValue = ele.getAttribute(attributeValue);
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
		return attributeCurrentValue;
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
		String alertText="";
		try {
			alertText=driver.switchTo().alert().getText();
			System.out.println("alert text was attained successfully "+alertText);
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
		return alertText;
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
		
			try {
				FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./Snaps/Image.jpg"));
			}  catch (IOException e) {
				System.err.println("can't store the screenshot in the specified path"+e.getMessage());
				e.printStackTrace();
			}
		}
		
		
	

	@Override
	public String getWindowhandle() {
	try {
		String windowHandle = driver.getWindowHandle();
		System.out.println("succesfully switched to the window"+windowHandle);
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
		Set<String> windowHandles=null;
		 try {
			windowHandles = driver.getWindowHandles();
		} catch (NoSuchWindowException e) {
			System.err.println("NoSuchWindowException has occurred");
		}
		
		return windowHandles;
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
		 
		try {
			act=new Actions(driver);
			act.dragAndDrop(sourceEle, destEle).build().perform();
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element either "+sourceEle+" or "+sourceEle+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred, either "+sourceEle +" element or "+destEle+" element would have either not attached to the DOM or re-generated");
			
		}finally {
			takePicture();
		}
		
	}

	@Override
	public void dragNdropByOffSet(WebElement sourceEle, int x, int y) {
		
		 try {
			new Actions(driver).dragAndDropBy(sourceEle, x, y).build().perform();
		}catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+sourceEle+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+sourceEle+ " element would have either not attached to the DOM or re-generated");
			
		}finally {
			takePicture();
		}
		
	}

	@Override
	public void clickHold(WebElement ele) {
		try {
			act=new Actions(driver);
			act.clickAndHold(ele).build().perform();
			System.out.println(ele+"element was clicked and held succesfully");
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+ele+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+ele+ " element would have either not attached to the DOM or re-generated");
			
		}finally {
			takePicture();
		}
		
	}

	@Override
	public void release(WebElement ele) {
		try {
			act=new Actions(driver);
			act.release(ele).build().perform();
			System.out.println(ele+"element was released succesfully");
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+ele+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+ele+ " element would have either not attached to the DOM or re-generated");
			
		}finally {
			takePicture();
		}
		
	}

	@Override
	public void hoverOverThenClickAnother(WebElement moveEle, WebElement clickEle) {
		try {
			act=new Actions(driver);
			act.moveToElement(moveEle).pause(3000L).click(clickEle).build().perform();
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element either "+moveEle+" or "+clickEle+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred, either "+moveEle +" element or "+clickEle+" element would have either not attached to the DOM or re-generated");
			
		}finally {
			takePicture();
		}
		
	}

	@Override
	public void slider(WebElement ele, int x, int y) {
		try {
			act=new Actions(driver);
			act.clickAndHold(ele).dragAndDropBy(ele, x, y).build().perform();
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+ele+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+ele+ " element would have either not attached to the DOM or re-generated");
			
		}finally {
			takePicture();
		}
		
	}

	@Override
	public boolean isDisplayed(WebElement ele) {
		boolean value= false;
		try {
			value= ele.isDisplayed();
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+ele+" was found");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+ele+ " element would have either not attached to the DOM or re-generated");
			
		}
		return value;
	}

	@Override
	public boolean isSelected(WebElement ele) {
		boolean select= false;
		try {
			select=ele.isSelected();
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+ele+" was found to check if it is selected ");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+ele+ " element would have either not attached to the DOM or re-generated");
			
		}
		return select;
	}

	@Override
	public boolean isEnabled(WebElement ele) {
		boolean enable= false;
		try {
			enable=ele.isEnabled();
		} catch(NoSuchElementException e) {
			
			System.err.println("NoSuchElementException has occurred , No element  "+ele+" was found to check if it is enabled ");
		}
		catch (StaleElementReferenceException e) {
			
			System.err.println("StaleElementReferenceException occurred for the given "+ele+ " element would have either not attached to the DOM or re-generated");
			
		}
		return enable;
	}

	@Override
	public void switchToWindow(int index) {
	
		try {
			Set<String> windowHandle = driver.getWindowHandles();
			ArrayList<String> allWindowhandles=new ArrayList<String>();
			driver.switchTo().window(allWindowhandles.get(index));
			System.out.println("succesfully switched to the window of specified index "+index);
		} catch (NoSuchWindowException e) {
			System.err.println("NoSuchWindowException has occurred");
			e.printStackTrace();
		}
	}

	@Override
	public void  verifyAttributeValue(WebElement ele, String attribute, String expAttrValue) {
		
		if(getAttributeValue(ele, attribute).equals(expAttrValue)) {
			
				System.out.println("the attribute value is matching with the expected value");
			
		}else {
			
			System.err.println("the attribute value is not matching with the expected value");
			
		}
		
	}
	

	@Override
	public void typeInAlert(String text) {
	try {
		driver.switchTo().alert().sendKeys(text);
	} catch (NoAlertPresentException e) {
		System.err.println("no alert was present to switch the focus"+e.getMessage());
		e.printStackTrace();
	}catch (UnhandledAlertException e) {
		System.err.println(" alert was not handled properly "+e.getMessage());
		e.printStackTrace();
	}catch(Exception e ) {
		System.err.println("unknown error occurred"+e.getMessage());
	}
		
	}

	

	@Override
	public void pickFromDropDownByValue(WebElement ele, String value) {
		try {
			Select s=new Select(ele);
			s.selectByValue(value);
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
	public boolean verifyTitle(String expTitle) {
		boolean verify=false;
		verify =driver.getTitle().equals(expTitle);
		return verify;
	}

	

	

	@Override
	public void switchBackToPreviousWindow() {
		try {
			driver.switchTo().parentFrame();
		} catch (NoSuchFrameException e) {
			System.err.println("NoSuchFrameException has occurred");
		}finally {
			takePicture();
		}
		
	}

}
