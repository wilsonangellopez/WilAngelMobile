package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import screens.components.AlertPopup;
import util.CustomWait;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * DashBoard screen.
 * 
 * @author Hans.Marquez
 *
 */
public class DashBoardScreen extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * @author Hans.Marquez
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	
	
	CustomWait customwait;
	
	public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_primary\")")
    private AndroidElement signInButton;
	
	
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@content-desc='Map, Tab, 2of5']")
	private AndroidElement mapBtn;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Tab, 5of5,')]")
	private AndroidElement privacyLegalBtn;
	
	
	@AndroidFindBy(id = "com.disney.wdpro.dlr:id/tab_animated_icon")
	private AndroidElement addPlanBtn;
	
	

	/**
	 * @author Hans.Marquez
	 *
	 * @description: Handle with random PopUps available in DashBoard Screen.
	 *
	 */
	public LoginScreen goToLoginScreen() {
		click(signInButton);
		return new LoginScreen(driver);
	}
	
	public void clickMapBtn() {
		click(mapBtn);
	}
	
	public void clickPrivacyLegal() {
		click(privacyLegalBtn);
	}
	
	public void clickPlanOption() {
		click(addPlanBtn);
		
	}
	
	

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		int retries = 0;
		try {
			while(retries < 3) {
				AlertPopup alertPopup = new AlertPopup(driver);
				alertPopup.accept();
				retries++;
			}
		} catch (Exception e) {
			log.info("No alerts found.");
			log.info(e);
		}
	}
}
