/**
 * 
 */
package webDriverMethods;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

/**
 * @author KrishnaPradeep.K
 *
 */
public interface Wdmethods {
	
	/** This method takes two arguments one as a  browser name and url to navigate 
	 * @param - browser
	 * @param - url
	 * this method is responsible for maximizing the window and adding an implicit wait and load the url
	 * @author KrishnaPradeep.K
	 *
	 */
	
	public void startApplication(String browser,String url) ;
	
	/** This method takes two arguments locator and locator value
	 * @param - locator
	 * @param - locValue
	 * @return- WebElement
	 * @author KrishnaPradeep.K
	 *  this method is responsible to identify a webElement in the DOM based on the locator and its corresponding value 
	 
	 */
	
	public WebElement identifyElement(String locator,String locValue);
	
	/** This method takes only a single argument which is locator ID's value
	 * @author KrishnaPradeep.K
	 * @param - locValue
	 * @return - WebElement
	 *  This method is responsible for finding an element by using ID as a locator
	 *  This method returns a webElement 
	
	 */
	
	public WebElement identifyElementWithId(String locValue) ;
	
	/** this method takes two arguments one is locator and other one is its value
	 * @param -locator
	 * @param - locValue
	 * @author KrishnaPradeep.K
	 * @return- List<WebElement>
	 * this method responsible for finding the group of elements based on locator and value
	 * it returns a List of webElement 
	
	 */
	
	public List<WebElement> identifyElements(String locator, String locValue);
	
	
	/** This method accepts two arguments one a web element and other one string value to pass as send keys 
	 * @param- ele
	 * @param-  value
	 * @author KrishnaPradeep.K
	 * this method is responsible to do sendkeys operation against an input text box
	
	 */
	
	public void type(WebElement ele, String value);
	
	/** This method takes a webElement as an argument
	 * @param - ele 
	 * @author KrishnaPradeep.K
	 * this method is responsible to do click operation on a particular element 
	 */
	
	public void click(WebElement ele);
	
	
	/** This method is takes two arguments one is web element and another one is string value
	 * @param - ele
	 * @param - value
	 * @author KrishnaPradeep.K
	 * this method is responsible for selecting an element from the drop down based on value
	 */
	
	public void pickFromDropDownByText(WebElement ele, String textValue);
	
	/** This method accepts two arguments one is web element and another one is index value
	 * @param- ele
	 * @param - index
	 * @author KrishnaPradeep.K
	 * This method is responsible for select an element from the drop down by using index
	 */
	
	public void pickFromDropDownByIndex(WebElement ele, int index);
	
	/** This method accepts two arguments one is web element and another one is value
	 * @param- ele
	 * @param - value
	 * @author KrishnaPradeep.K
	 * This method is responsible for select an element from the drop down by using value
	 */
	
	public void pickFromDropDownByValue(WebElement ele, String value);
	
	
	/** This method accepts two arguments one is Web element and another one is a string value 
	 * @param- ele
	 * @param - exptext
	 * @author KrishnaPradeep.K
	 * @return- boolean
	 * This method looks for the exact match of the two values 
	 * This method returns boolean type values such as true or false 
	 */
	
	public boolean verifyExactText(WebElement ele, String expText);
	
	
	/** This method accepts two arguments one is Web element and another one is a string value 
	 * @param -ele
	 * @param - expText
	 * @author KrishnaPradeep.K
	 * @return- boolean
	 * This method looks for the partial match of the two values 
	 * This method returns boolean type values such as true or false 
	 */
	
	public boolean verifyPartialText(WebElement ele, String expText);
	
	
	/** This method accepts one argument which is a web element  
	 * @param - ele
	 * @author KrishnaPradeep.K
	 * @return- String  
	 * This method get the text value of the web element  
	 * This method returns a string value
	 */
	
	public String getText(WebElement ele);
	
	/** This method takes one argument   
	 * @param- expTitle
	 * @author KrishnaPradeep.K
	 * This method returns a boolean value
	 * This method gets the title the web page and verifies with the given title  
	 */
	
	public boolean verifyTitle(String expTitle);
	
	
	/** This method takes one argument which is a webElement
	 * @author KrishnaPradeep.K
	 * @param- ele
	 *@return- boolean
	 *This method responsible for checking whether a particular element is displayed 
	 */ 
	
	public boolean isDisplayed(WebElement ele);
	
	/** This method takes one argument which is a webElement
	 * @author KrishnaPradeep.K
	 * @param- ele
	 *@return- boolean
	 *This method responsible for checking whether a particular element is selected 
	 */ 
	
	public boolean isSelected (WebElement ele);
	
	/** This method takes one argument which is a webElement
	 * @author KrishnaPradeep.K
	 * @param- ele
	 *@return- boolean
	 *This method responsible for checking whether a particular element is enabled 
	 */ 
	
	public boolean isEnabled (WebElement ele);
	
	
	/** This method accepts two arguments which are, a web element and a string attribute value  
	 * @param - ele
	 * @param - attribute
	 * @author KrishnaPradeep.K
	 * @return- String
	 * This method gets the value of the respective attribute sent as an argument with respect to the web element  
	 * This method returns a string value
	 */
	
	public String getAttributeValue(WebElement ele,  String attributeValue);
	
	
	/** This method accepts three arguments which are, a web element and a string attribute and its value  
	 * @param - ele
	 * @param - attribute
	 * @param - attibuteValue
	 * @author KrishnaPradeep.K
	 * @return- boolean
	 * This method responsible for getting the value of an attribute of a webelement then compare with the expected value  
	 * 
	 */
	
	public void verifyAttributeValue(WebElement ele, String attribute, String expAttrVal);
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in switching the focus to an active alert and then click on "OK" button(accept)
	 */
	
	
    public void acceptAlert();
    
    
    /** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in switching the focus to an active alert and then click on "cancel" button(dismiss)
	 */
	
	public void dismissAlert();
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * @return- String
	 * this method helps in switching the focus to an active alert and then get the text present on the alert pop up
	 * this method returns a string value
	 */
	
	public String getAlertText();
	
	/** This method takes one argument which is string value 
	 * @param- text
	 * @author KrishnaPradeep.K
	 * this method helps in typing in the text box present in an alert
	 */
	
	public void typeInAlert(String text);
	
	
	/** This method takes one  argument which is a web element 
	 * @param-ele
	 * @author KrishnaPradeep.K
	
	 * this method helps in switching the focus to a frame 
	 */
	
	public void switchToFrame(WebElement ele);
	
	
	/** This method takes no argument 
	 * @param- index
	 * @author KrishnaPradeep.K
	 * this method helps in switching the focus to a frame based on the index
	 */
	
	public void switchToFrameByIndex(int index);
	
	/** This method takes no argument 
	 * @param- index
	 * @author KrishnaPradeep.K
	 * this method helps in switching the focus to a window of interest based on index
	 */
	
	
	public void switchToWindow(int index);
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in switching the focus back to the default (parent) window from a frame 
	 */
	
	
	
	public void switchBacktoDeafutlWindow();
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in switching the focus back to the previous parent frame from the current  frame 
	 */
	
	public void switchBackToPreviousWindow();
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in capturing a screenshot and string it in a specified path 
	 */
	
	public void takePicture();
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in getting the reference ID of the current window in which the driver object is focused 
	 * This method returns a string value
	 */
	
	public String getWindowhandle();
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method helps in getting the reference IDs of all the windows those are opened by selenium driver 
	 * This method returns a set of strings 
	 */
	
	public Set<String> getWindowHandles();
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * @return- Set <String>
	 * this method is responsible for closing the current browser
	 */
	
	public void closewindow();
	
	
	/** This method takes no argument 
	 * @author KrishnaPradeep.K
	 * this method is responsible for closing all the selenium opened browsers
	 */
	
	public void closeAllWindows();
	
	
	/** This method takes two arguments which are  webElements to drag an element from source to destination droppable web element 
	 * @param- sourceEle
	 * @param- destEle
	 * @author KrishnaPradeep.K
	 * this method is responsible for dragging a web element from the current location to the destination droppable location
	 */
	
	public void dragNdrop(WebElement sourceEle,WebElement destEle);
	
	
	/** This method takes three arguments one is webElement and other two are integer which are x and y co-ordinates 
	 * @param-sourceEle
	 * @param- x
	 * @param -y
	 * @author KrishnaPradeep.K
	 * this method is responsible for dragging a web element from the current location to the destination location 
	 */
	
	public void dragNdropByOffSet(WebElement sourceEle, int x, int y);
	
	
	/** This method takes a web element as an argument 
	 * @param -ele
	 * @author KrishnaPradeep.K
	 * This method is responsible for clicking and holding the webElement 
	 */
	
	public void clickHold(WebElement ele);
	
	
	/** This method takes a web element as an argument 
	 * @param -ele
	 * @author KrishnaPradeep.K
	 * This method is responsible for releasing the webElement 
	 */
	
	
	public void release(WebElement ele);
	
	
	/** This method takes a web element as an argument 
	 * @param-ele
	 * @author KrishnaPradeep.K
	 * This method is responsible for moving to a webElement (not clicking) 
	 */
	
	
	public void hoverOverThenClickAnother(WebElement moveEle, WebElement clickEle);
	
	
	/** This method takes three argument one is a web element and other two are x and y co-ordinates which are integers 
	 * @param-ele
	 * @param-x
	 * @param-y 
	 * @author KrishnaPradeep.K
	 * This method is responsible for sliding the bar from the source location to a destination location 
	 */
	
	
	public void slider(WebElement ele, int x, int y);
	

}
