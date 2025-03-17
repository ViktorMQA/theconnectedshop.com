package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	private static final String expectedTitle = "The Connected Shop - Smart Locks, Smart Sensors, Smart Home & Office";
	private static final String expectedUrl = "https://theconnectedshop.com/";

    @AfterMethod
	public void closeDriver() {
		if(driver != null) {driver.quit();}
	}

	@Test
	public void testHomePageElements(){
		setUp();
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getPageTitle(), expectedTitle, "The home page title is wrong");
		Assert.assertEquals(homePage.getCurrentUrl(), expectedUrl, "The home page URL is wrong");
	}







}
