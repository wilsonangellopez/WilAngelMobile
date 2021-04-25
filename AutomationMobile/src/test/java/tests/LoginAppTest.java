package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;

import screens.DashBoardScreen;
import screens.LoginScreen;
import util.tests.BaseMobileTest;

public class LoginAppTest extends BaseMobileTest {

	@Description(value = "Failed assertive login test ID:0001")
	@Test()
	public void failedLoginTest() {
		log.info("Starting Failed assertive login test");
		DashBoardScreen dashBoard = dismissTutorial();
		LoginScreen login = dashBoard.goToLoginScreen();		
		login.fillInLoginData("email", "password");
		String bannerText = login.getBannerText();
		Assert.assertEquals(bannerText, "Something's not right…. We're sorry for the inconvenience!");
	}
	
	
}
