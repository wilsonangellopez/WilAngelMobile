package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.*;
import util.screens.BaseScreen;


/**
 * Object of the first screen that appears when we open the application.
 * 
 * @author Arley.Bolivar
 *
 */

public class TutorialScreen extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 * @param driver the driver
	 * @author Arley.Bolivar
	 */
	public TutorialScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// AndroidElements
	@AndroidFindBy(accessibility = "Close")
	private AndroidElement closeButton;


	/**
	 * @return DashBoardScreen
	 * @author Hans.Marquez
	 * @description: Returns the DashBoard screen after after handling
	 * popUps.
	 */

	public DashBoardScreen dismiss() {
		alertControl();
		return new DashBoardScreen(driver);
	}

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		click(closeButton);
	}
}
