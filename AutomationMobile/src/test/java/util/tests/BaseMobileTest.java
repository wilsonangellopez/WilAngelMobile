package util.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import screens.DashBoardScreen;
import screens.TutorialScreen;
import util.ConfigCapabilities;

/**
 * Base class for Test classes.
 * 
 * @author helberth.bolivar
 *
 */
public abstract class BaseMobileTest {

	protected TutorialScreen tutorialScreen;
	public static AndroidDriver<AndroidElement> driver;
	public Logger log = Logger.getLogger(BaseMobileTest.class);

	public void setUpStartApp() {
		tutorialScreen = new TutorialScreen(getDriver());
	}

	/**
	 * SetUp before to run suite of test.
	 * 
	 * @author Arley.Bolivar
	 * 
	 */
	@BeforeMethod(alwaysRun = true)
	public void environmentSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ConfigCapabilities.deviceSetUp(capabilities);
		ConfigCapabilities.applicationSetUp(capabilities);
		try {
			driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		}
		setUpStartApp();
	}

	/**
	 * Close the application after completing the test.
	 * 
	 * @author Arley.Bolivar
	 * 
	 */
	@AfterMethod(alwaysRun = true)
	public void mobileApplicationEnd() {
		//driver.quit();
	}

	/**
	 * return the driver.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @return driver
	 */
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	/**
	 * Dismiss tutorial screen in order to load Dashboard
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @return DashBoardScreen
	 */
	protected DashBoardScreen dismissTutorial() {
		DashBoardScreen dashBoardScreen = tutorialScreen.dismiss();
		dashBoardScreen.alertControl();
		return dashBoardScreen;
	}
}
