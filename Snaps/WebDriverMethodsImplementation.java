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
import org.openqa.selenium.WebDriver;
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
				reportStep("browser"+browser+"has successfully launched", "pass");
			
		} catch (WebDriverException e) {
			
				try {
					reportStep("browser"+browser +"failed to lauch"+e.getMessage(), "fail");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				throw new RuntimeException();
			
		}
		
		 catch (Exception e) {
				// TODO Auto-generated catch block
			 try {
				reportStep("browser"+browser +"failed to lauch", "fail");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 throw new RuntimeException();
			}
		finally {
			//takePicture();
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
			try {
				reportStep("invalidSelectorException has occurred for given  "+locator +" and "+locValue, "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (NoSuchElementException e) {
			try {
				reportStep("No element with "+locator +" and "+locValue+" wasn't found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred for the given "+locator +" and "+locValue+" element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			//takePicture();
		}
		
		return null;
	}

	@Override
	public WebElement identifyElementWithId(String locValue)  {
		try {
			driver.findElement(By.id(locValue));
		}catch (InvalidSelectorException e) {
			try {
				reportStep("invalidSelectorException has occurred for given Id and its value "+locValue, "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (NoSuchElementException e) {
			try {
				reportStep("No element with id and value "+locValue+" was found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred for the given "+locValue+" element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			try {
				reportStep("invalidSelectorException has occurred for given  "+locator +" and "+locValue, "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (NoSuchElementException e) {
			try {
				reportStep("No element with "+locator +" and "+locValue+" wasn't found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred for the given "+locator +" and "+locValue+" element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		try {
			reportStep(value+"was successfully enetered in the given "+ele, "pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch (NoSuchElementException e) {
			try {
				reportStep("No element  "+ele +" found to type "+value, "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred can't find the element"+ele+" to type "+value, "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		catch(Exception e1 ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
		//	takePicture();
		}
		}
	}

	@Override
	public void click(WebElement ele) {
		try {
		ele.click();
		try {
			reportStep(ele+" element was succesfully clicked", "pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred No element "+ele+" was found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred, couldn't click on "+ele +" as element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			//takePicture();
		}
		
	}

	@Override
	public void pickFromDropDownByText(WebElement ele, String textValue) {
		try {
			Select s=new Select(ele);
			s.selectByVisibleText(textValue);
			try {
				reportStep(ele+"element was picked from the drop down succesfully using"+textValue, "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred, No element "+ele+" was found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred, couldn't find the element "+ele +"from dropdown as element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		catch(Exception e1 ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		}
		
	}

	@Override
	public void pickFromDropDownByIndex(WebElement ele, int index) {
		try {
			Select s=new Select(ele);
			s.selectByIndex(index);
			try {
				reportStep(ele+"element was selected from the dropdown succesfully", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred, No element "+ele+" was found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred, couldn't find the element "+ele +"from dropdown as element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		catch(Exception e1 ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		}
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expText) {
		  boolean verify=false;
			try {
				String text = ele.getText();
				 verify=text.equals(expText);
				 try {
					reportStep(ele+"element text is matching with the expected text"+expText,"pass");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchElementException e) {
				try {
					reportStep(ele+"element text is not matching with the expected text"+expText,"fail");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				return verify;
			
	
		
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expText) {
		boolean verifyPar=false;
		try {
			String text = ele.getText();
			verifyPar=text.contains(expText);
			try {
				reportStep(ele+"text is partially matching with the expected text"+expText, "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep(ele+"element text is not matching with the expected text"+expText,"fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			return verifyPar;
		
	}

	@Override
	public String getText(WebElement ele)  {
		String text="";
		try {
			 text = ele.getText();
			 try {
				reportStep(ele+"element text has been attained which is"+text, "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred, No element "+ele+" was found to get text", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred, couldn't find the element "+ele +"to get text as element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			takePicture();
		}
		
		return text;
	}

	@Override
	public String getAttributeValue(WebElement ele,  String attributeValue) {
		
		String attributeCurrentValue="";
		try {
			 attributeCurrentValue = ele.getAttribute(attributeValue);
			 reportStep(ele+"element's attribute value has been attained, which is"+attributeCurrentValue, "pass");
		}catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred, No element "+ele+" was found to get attribute value", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException occurred, couldn't find the element "+ele +"to get attribute value as element would have either not attached to the DOM or re-generated", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			reportStep("succesfully accepted the pop up","pass");
		} catch (NoAlertPresentException e) {
			try {
				reportStep("NoAlertPresentException has occurred, no alert has appeared to accept", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}catch (UnhandledAlertException e) {
			try {
				reportStep("UnhandledAlertException has occurred, alert wasnt handled", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			reportStep("succesfully canceled the alert by doing dismiss operation on the pop up","pass");
		} catch (NoAlertPresentException e) {
			try {
				reportStep("NoAlertPresentException has occurred, no alert has appeared to accept", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}catch (UnhandledAlertException e) {
			try {
				reportStep("UnhandledAlertException has occurred, alert wasnt handled", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		String text="";
		try {
			text=driver.switchTo().alert().getText();
			reportStep("Successfully got the text from the alert", "pass");
		} catch (NoAlertPresentException e) {
			try {
				reportStep("NoAlertPresentException has occurred, no alert has appeared to accept", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}catch (UnhandledAlertException e) {
			try {
				reportStep("UnhandledAlertException has occurred, alert wasnt handled", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}catch(Exception e ) {
			System.err.println("unknown error occurred"+e.getMessage());
		}
		finally {
			takePicture();
		}
		return text;
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("succesfully switched to the frame", "pass");
		} catch (NoSuchFrameException e) {
			try {
				reportStep("NoSuchFrameException failed to switch to the frame, may be the element"+ele+"would have not found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
			reportStep("succesfully switched to the frame using index", "pass");
		}  catch (NoSuchFrameException e) {
			try {
				reportStep("NoSuchFrameException failed to switch to the frame", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
			reportStep("succesfully switched back to the default window using index", "pass");
		} catch (NoSuchWindowException e) {
			try {
				reportStep("NoSuchWindowException occurred failed to switch back to the window", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
		try {
			reportStep("WebDriverException has occurred", "fail");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		 
		try {
			act=new Actions(driver);
			act.dragAndDrop(sourceEle, destEle).build().perform();
			try {
				reportStep(sourceEle+"source element has been dragged successfully to the destination element"+destEle, "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep(sourceEle+"source element hasn't been dragged to the destination element"+destEle+"as one of them would have not found", "pass");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void dragNdropByOffSet(WebElement sourceEle, int x, int y) {
		
		 try {
			new Actions(driver).dragAndDropBy(sourceEle, x, y).build().perform();
			try {
				reportStep(sourceEle+"source element has been dragged successfully by the specified" +x+" and "+y+ " co-ordinates", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep(sourceEle+"source element hasn't been dragged by the specified" +x+" and "+y+ " co-ordinates", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void clickHold(WebElement ele) {
		try {
			act=new Actions(driver);
			act.clickAndHold(ele).build().perform();
			try {
				reportStep(ele+"element was succesfully clicked", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred "+ele+" was not found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void release(WebElement ele) {
		try {
			act=new Actions(driver);
			act.release(ele).build().perform();
			try {
				reportStep(ele+"element has been released succesfully", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred "+ele+" was not found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void hoverOverThenClickAnother(WebElement moveEle, WebElement clickEle) {
		try {
			act=new Actions(driver);
			act.moveToElement(moveEle).pause(3000L).click(clickEle).build().perform();
			try {
				reportStep("successfully moved on to the element "+moveEle+" then clicked on clickable element"+clickEle, "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred either move element "+moveEle+" or clickable element "+clickEle+" would have not found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException has occurred either move element "+moveEle+" or clickable element "+clickEle+" would have not attached to the DOM", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void slider(WebElement ele, int x, int y) {
		try {
			act=new Actions(driver);
			act.clickAndHold(ele).dragAndDropBy(ele, x, y).build().perform();
			try {
				reportStep(ele+" element was succesfully dragged by the specified "+x+ "and" +y+" co-ordinates", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred element "+ele+" was not found", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean isDisplayed(WebElement ele) {
		boolean value= false;
		try {
			value= ele.isDisplayed();
			try {
				reportStep(ele+"element was displayed succesfully", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred "+ele+"wasn't found to display", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException has occurred  element "+ele+"  would have not attached to the DOM", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public boolean isSelected(WebElement ele) {
		boolean select= false;
		try {
			select=ele.isSelected();
			try {
				reportStep(ele+"element was selected succesfully", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred "+ele+"wasn't found to select", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException has occurred  element "+ele+"  would have not attached to the DOM", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return select;
	}

	@Override
	public boolean isEnabled(WebElement ele) {
		boolean enable= false;
		try {
			enable=ele.isEnabled();
			try {
				reportStep(ele+"element was enabled", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			try {
				reportStep("NoSuchElementException has occurred "+ele+"wasn't found to notify whether or not its enabled", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (StaleElementReferenceException e) {
			try {
				reportStep("StaleElementReferenceException has occurred  element "+ele+"  would have not attached to the DOM", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return enable;
	}

	@Override
	public void switchToWindow(int index) {
	
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String>allWindowHandles=new ArrayList<String>();
			allWindowHandles.addAll(windowHandles);
			driver.switchTo().window(allWindowHandles.get(index));
			try {
				reportStep("succesfully switched to the window of interest"+index, "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchWindowException e) {
			try {
				reportStep("NoSuchWindowException occurred, failed to switch to the window of interest"+index, "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void verifyAttributeValue(WebElement ele, String attribute,String expAttrValue) {
		
		if(getAttributeValue(ele, attribute).equals(expAttrValue)) {
			try {
				reportStep("the attribute value is matching with the ezpected value", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				reportStep("the attribute value is not matching with the ezpected value", "fail");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void typeInAlert(String text) {
	try {
		driver.switchTo().alert().sendKeys(text);
		try {
			reportStep("text has been succesfully netered in the alert text box", "pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (NoAlertPresentException e) {
		try {
			reportStep("NoAlertPresentException has occurred, no alert has appeared to accept", "fail");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}catch (UnhandledAlertException e) {
		try {
			reportStep("UnhandledAlertException has occurred, alert wasnt handled", "fail");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
		
	}

	@Override
	public void pickFromDropDownByValue(WebElement ele, String value) {
		try {
		Select s=new Select(ele);
		s.selectByValue(value);
		try {
			reportStep(ele+"element was picked from the drop down succesfully using"+value, "pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (NoSuchElementException e) {
		try {
			reportStep("NoSuchElementException has occurred, No element "+ele+" was found", "fail");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}catch (StaleElementReferenceException e) {
		try {
			reportStep("StaleElementReferenceException occurred, couldn't find the element "+ele +"from dropdown as element would have either not attached to the DOM or re-generated", "fail");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	}
	

	@Override
	public void switchBackToPreviousWindow() {
		 try {
			driver.switchTo().parentFrame();
			try {
				reportStep("succesfully switched the focus back to the previous frame", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFrameException e) {
			try {
				reportStep("NoSuchFrameException has occurred failed to switch the focus back to the previous frame", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean verifyTitle(String expTitle) {
		boolean title=true;
		try {
			String title2 = driver.getTitle();
			 title = title2.equalsIgnoreCase(expTitle);
			 try {
				reportStep("page title has been verified succesfully", "pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (WebDriverException e) {
			try {
				reportStep("WebDriverException has occurred", "fail");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return title;
	}

}
