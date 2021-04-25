package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

public class PlanOption extends BaseScreen {

	
	
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Make a Reservation\")")
	@AndroidFindBy(xpath = "//android.widget.TextSwitcher[@content-desc=\"Make a Reservation, heading\"]/android.widget.TextView")
    private AndroidElement reservation;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id= "com.disney.wdpro.dlr:id/btnCloseActionSheet")
    private AndroidElement closeReservationBtn;
	
	
	
	
	public PlanOption(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@Override
	public void alertControl() {
		
	}
	
	public boolean validateListElements() {
		
		isElementAvailable(closeReservationBtn);
		List<AndroidElement> plans = driver.findElementsByXPath("//*[@class='android.widget.TextView']");
				
		System.out.println("lista planes " + plans.size());
		return (plans.size()>0)?true:false;
		
	}
	
	public boolean validateReserveDiningInList() {
		
		List<AndroidElement> plans = driver.findElementsByXPath("//*[@class='android.widget.TextView']");	
		isElementAvailable(closeReservationBtn);
		
		System.out.println("info de la lista");
		log.info("Plans size "+plans.size());
		log.info("Plans [0] "+plans.get(0).getText());
		log.info("Plans [1] "+plans.get(1).getText());
		log.info("Plans [2] "+plans.get(2).getText());
		
		if(plans.stream().count()>0) {
			
			plans.stream().filter(x-> x.getText().equalsIgnoreCase("Reserve Dining")).findFirst().get().click();
			return true;
			
		}
		return false;
		
	}
	
	public boolean validateReservation() {
		return reservation.isDisplayed()?true:false;
		
	}
	
	
	

}
