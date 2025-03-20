package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HeaderPage;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	private static final String expectedTitle = "The Connected Shop - Smart Locks, Smart Sensors, Smart Home & Office";
	private static final String expectedUrl = "https://theconnectedshop.com/";
	private static final String accountLinkHref = "/account";
	private static final String searchLinkHref = "/search";
	private static final String cartLinkHref = "/cart";
	private static final String primaryLogoAltText = "The Connected Shop Logo";

	@BeforeMethod
    public void setUpDriver(){
		setUp();
	}

    @AfterMethod
	public void closeDriver() {
		if(driver != null) {driver.quit();}
	}

	@Test
	public void testUrlAndTitle(){
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getPageTitle(), expectedTitle, "The home page title is wrong");
		Assert.assertEquals(homePage.getCurrentUrl(), expectedUrl, "The home page URL is wrong");
	}

	@Test
	public void testHeaderElements(){
		HeaderPage header = new HeaderPage(driver);
		SoftAssert softAssert = new SoftAssert();

		// checking that elements display
		softAssert.assertTrue(header.isAccountLinkDisplay(), "the account link ISN'T display");
		softAssert.assertTrue(header.isSearchLinkDisplay(), "the search link ISN'T display");
		softAssert.assertTrue(header.isCartLinkDisplay(), "the cart link ISN'T display");
		//Assert.assertTrue(header.isPrimaryLogoDisplay(), "the primary ISN'T display");
		softAssert.assertTrue(header.isTransparentLogoDisplay(), "the transparent link ISN'T display");
		softAssert.assertTrue(header.isLogoLinkDisplay(), "the logoLink ISN'T display");

		// checking that elements contain correct attributes
		softAssert.assertEquals(header.getAccountLinkHref(), accountLinkHref, "Account link href is incorrect");
		softAssert.assertEquals(header.getSearchLinkHref(), searchLinkHref, "Search link href is incorrect");
		softAssert.assertEquals(header.getCartLinkHref(), cartLinkHref, "Cart link href is incorrect");
		softAssert.assertEquals(header.getPrimaryLogoAltText(), primaryLogoAltText, "Primary logo alt text is incorrect");

		softAssert.assertAll();
	}









}
