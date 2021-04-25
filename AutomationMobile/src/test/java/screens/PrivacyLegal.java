package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

public class PrivacyLegal extends BaseScreen {

	
	//*[@content-desc="Privacy & Legal button"]/*[2]
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains('Privacy & Legal')")
	@AndroidFindBy(xpath = "//*[@content-desc='Privacy & Legal button']/*[2]")
    private AndroidElement privacyLegalBtn;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")")
	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    private AndroidElement menuOptionList;
	
	
	public PrivacyLegal(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@Override
	public void alertControl() {
		
	}
	
	public void scrollToBotton() {
	scrollToText("Privacy & Legal");
		
	}
	
	public void clickOnPrivacyLegalBtn() {
		click(privacyLegalBtn);
	}
	
	public boolean listOptionPrivacyLegal() {
		
		List<AndroidElement> elementos = driver.findElementsByXPath("//*[@class='android.widget.TextView']");
		return (elementos.size()>0)?true:false;
		
	}

}
