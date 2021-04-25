package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

public class CategoryList extends BaseScreen{
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/categoryTitle")
	private AndroidElement attractionsList;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@content-desc='Attractions, Category, 1of12, button']/android.widget.TextView[1]") //	//*[@content-desc="Attractions, Category, 1of12, button"]/android.widget.TextView[1]
	private AndroidElement attractionItem;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().className('android.widget.TextView').textContains('Hotels')")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains('Hotels')")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Hotels, Category, Collapsed, 11of12, button']/android.widget.TextView")
	@AndroidFindBy(accessibility="Hotels, Category, 11of12, button")
    private AndroidElement hotelBtn;
	
		

	public CategoryList(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public void attractionListCLick() {
		click(attractionsList);
	}
	
	public boolean attractionIsDefaultOptionSelected() {
		
		String selectedORNot = attractionItem.getAttribute("selected");
		
		List<AndroidElement> iconos = driver.findElementsById("com.disney.wdpro.dlr:id/facilityTypeIcon");
		return (selectedORNot .equalsIgnoreCase("true")&& iconos.get(0).getAttribute("selected").toString().equalsIgnoreCase("true"))?true:false;
		
	}
	
	public boolean isElementAvailable() {
		
		
		scrollToText("Hotels");
		return (hotelBtn.isDisplayed()&&hotelBtn.isEnabled())?true:false;
		
		
		/*
		List<AndroidElement> elementos = driver.findElementsById("com.disney.wdpro.dlr:id/facilityTypeIcon");
		log.info("vamos a validar la ultima opcion atributo en lista:   >>>>>>>>>>" + elementos.get(10).getAttribute("selected"));
		log.info("TAG en lista:   >>>>>>>>>>" + elementos.get(10).getTagName());
		log.info("TEXTO en lista:   >>>>>>>>>>" + elementos.get(10).getText());
		elementos.get(10).click();*/
		
		
		
	}
	

	@Override
	public void alertControl() {
		// TODO Auto-generated method stub
		
	}

}

