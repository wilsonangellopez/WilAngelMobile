package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;

import screens.CategoryList;
import screens.DashBoardScreen;
import screens.LoginScreen;
import screens.PlanOption;
import screens.PrivacyLegal;
import util.tests.BaseMobileTest;

public class PlansOptionTest extends BaseMobileTest {

	Assert myAssert;
	@Description(value = "Privacy & Legal test ID:0003")
	@Test()
	public void planOptionTest() {
		log.info("Starting Privacy & Legal test");
		DashBoardScreen dashBoard = dismissTutorial();
		dashBoard.clickPlanOption();
		PlanOption plan = new PlanOption(driver);
		myAssert.assertTrue(plan.validateListElements(),"The system doesn't display a list plans");
		myAssert.assertTrue(plan.validateReserveDiningInList(),"The system doesn't display the Dining option");
		/*myAssert.assertTrue(plan.validateReservation(), "The system not redirect");*/
		
	
				
		
		

	}
	
	
}
