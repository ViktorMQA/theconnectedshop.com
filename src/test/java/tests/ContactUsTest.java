package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

	private static final String name = "testName";
	private static final String email = "test@Email.com";
	private static final String phone = "testPhone";
	private static final String message = "testMessage";

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
		HeaderPage header = new HeaderPage(driver);
		header.getContactUsPage(driver)
				.sendMessage(name, email, phone, message);
	}

}
