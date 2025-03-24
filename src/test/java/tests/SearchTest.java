package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

	private static final String notExistsText = "no goods";

	@BeforeMethod
	public void precondition(){
		setUp();
		HeaderPage header = new HeaderPage(driver);
		header.clickSearchLink();

	}

	@AfterMethod
	public void closeDriver() {
		if(driver != null) {driver.quit();}
	}

	@Test
	public void searchNoResultTest(){
		SearchPage search = new SearchPage(driver);
		search.fillSearchField(notExistsText);
		Assert.assertTrue(search.isDisplayNoResult(), "The Search element ISN'T display");
		search.getNoResultText();

	}



}
