package screens.components;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class AlertPopup extends BaseScreen {

	public AlertPopup(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*button1.*\")")
	@AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*button1.*\").textContains(\"OK\")")
	@AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*permission.*allow.*button.*\")")
	private AndroidElement AcceptButton;

	public AlertPopup accept() {
		alertControl();
		return new AlertPopup(driver);
	}

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		click(AcceptButton);
	}
}
