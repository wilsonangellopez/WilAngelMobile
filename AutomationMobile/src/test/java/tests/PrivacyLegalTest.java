package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;

import screens.CategoryList;
import screens.DashBoardScreen;
import screens.LoginScreen;
import screens.PrivacyLegal;
import util.tests.BaseMobileTest;

public class PrivacyLegalTest extends BaseMobileTest {

	Assert myAssert;
	@Description(value = "Plan option test ID:0004")
	@Test()
	public void privacyLegalTest() {
		log.info("Plan option test");
		DashBoardScreen dashBoard = dismissTutorial();
		dashBoard.clickPrivacyLegal();
		PrivacyLegal privacyLegal = new PrivacyLegal(driver);
		privacyLegal.scrollToBotton();
		privacyLegal.clickOnPrivacyLegalBtn();
		myAssert.assertTrue(privacyLegal.listOptionPrivacyLegal(),"Not list option available");
				
		
		

	}
	
	
}
