package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;

import screens.CategoryList;
import screens.DashBoardScreen;
import screens.LoginScreen;
import util.tests.BaseMobileTest;

public class CategoryListTest extends BaseMobileTest {

	Assert myAssert;
	@Description(value = "Category List test ID:0002")
	@Test()
	public void failedLoginTest() {
		log.info("Starting category list test");
		DashBoardScreen dashBoard = dismissTutorial();
		dashBoard.clickMapBtn();
		CategoryList categoryList = new CategoryList(getDriver());
		categoryList.attractionListCLick();
		myAssert.assertTrue(categoryList.attractionIsDefaultOptionSelected(),"the Attraction is not selected by default");
		categoryList.isElementAvailable();
		
		
		/*LoginScreen login = dashBoard.goToLoginScreen();		
		login.fillInLoginData("email", "password");
		String bannerText = login.getBannerText();
		Assert.assertEquals(bannerText, "Something's not right…. We're sorry for the inconvenience!");*/
	}
	
	
}
