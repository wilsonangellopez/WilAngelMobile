package util.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import screens.AlertHandler;
import util.CustomWait;

import static java.lang.String.format;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// TODO: Auto-generated Javadoc
/**
 * Base class for all screens Objects.
 * 
 * @author Arley.Bolivar
 *
 */
public abstract class BaseScreen implements AlertHandler{
	
	protected CustomWait customWait = new CustomWait();
	protected final AndroidDriver<AndroidElement> driver;
	public Logger log = Logger.getLogger(BaseScreen.class);
	private static final int PERCENT = 100;

	/**
	 * Constructor method for standard screens object.
	 * 
	 * @author Arley.Bolivar, Hans.Marquez
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public BaseScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
	}

	/**
	 * Tab on back button.
	 * 
	 * @author Arley.Bolivar
	 */
	public void tapBack() {
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate()
		.back();
	}

	
	/**
	 * Scroll down (From Top to Bottom).
	 *
	 * @author Hans.Marquez
	 * @param swipes the swipes
	 */
	public void scrollDown(int swipes) {
		String locator = "new UiScrollable(.scrollable(true)).scrollToEnd(1)";
		
		scroll(locator, swipes);
	}

	/**
	 * Scroll Up (From Bottom to Top).
	 *
	 * @author Hans.Marquez
	 * @param swipes the swipes
	 */
	public void scrollUp(int swipes) {
		String locator = "new UiScrollable(.scrollable(true)).scrollToBeginning(1)";
		scroll(locator, swipes);
	}


	/**
	 * Scroll.
	 *
	 * @param locator the locator
	 * @param swipes  the swipes
	 */
	public void scroll(String locator, int swipes) {
		int swipesAmount = 0;
		while (swipesAmount < swipes) {
			try {
				driver.findElementByAndroidUIAutomator(locator);
				swipesAmount++;
			} catch (Exception e) {
				swipesAmount++;
			}
		}
	}

	/**
	 * Swipe vertical.
	 *
	 * @param percentage of swipe
	 */
	@SuppressWarnings({ "rawtypes" })
	public void swipeVertical (double startY, double endY, double startX) {
		Dimension windowSize = driver.manage().window().getSize();
		int starty = (int) (windowSize.height * (startY / PERCENT));
		int endy = (int) ((windowSize.height * endY / PERCENT));
		int startx = (int) (windowSize.width * startX / PERCENT);
		
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, 
				endy)).release().perform();
	}

	/**
	 * Scroll to the text attribute received by parameter.
	 *
	 * @author Arley.Bolivar
	 *
	 * @param text
	 *            : String
	 */
	public void scrollToText(String text) {
		String automator = "new UiScrollable(.scrollable(true)).scrollIntoView(new UiSelector().textContains(\"%s\"))";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		log.info(textOnElement.getText());
	}
	
	
	/**
	 * Scroll to the description attribute received by parameter.
	 *
	 * @author Hans.Marquez
	 *
	 * @param text
	 *            : String
	 */
	public void scrollToDescription(String text) {
		String automator = "new UiScrollable(.scrollable(true)).scrollDescriptionIntoView(\"%s\")";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		log.info(textOnElement.getText());
	}
	
	
	/**
	 * Wrapper for click  event specifying custom wait.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public void click(AndroidElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	
	/**
	 * Wrapper for click  event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public void click(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	
	/**
	 * Wrapper for sendKeys event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 * @param sequence: String
	 */
	public void sendKeys(AndroidElement element, String sequence) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(sequence);
	}
	
	/**
	 * Wrapper for sendKeys event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 * @param sequence: String
	 */
	public boolean isElementAvailable(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	
}
