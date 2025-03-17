package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;

public class HeaderPageTest extends BaseTest {

	@AfterMethod
	public void closeDriver() {
		if(driver != null) {driver.quit();}
	}

	@Test
	public void testHomePageElements(){
		setUp();
		Header header = new Header(driver);
		Assert.assertTrue(header.isAccountLinkDisplay(), "the account link ISN'T display");
		Assert.assertTrue(header.isSearchLinkDisplay(), "the search link ISN'T display");
		Assert.assertTrue(header.isCartLinkDisplay(), "the cart link ISN'T display");

		//Assert.assertTrue(header.isPrimaryLogoDisplay(), "the primary ISN'T display");
		Assert.assertTrue(header.isTransparentDisplay(), "the transparent link ISN'T display");
		Assert.assertTrue(header.isLogoLinkDisplay(), "the logoLink ISN'T display");


	}


}
