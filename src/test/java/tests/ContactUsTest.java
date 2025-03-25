package tests;

import base.BaseTest;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HeaderPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

	private static String name;
	private static String email;
	private static String phone;
	private static String message;

	@BeforeMethod
	public void setUpDriver(){
		setUp();
		try{
			String content = new String(Files.readAllBytes(Paths.get("src/test/resources/contactUsData.json")));
			JSONObject jsonObject = new JSONObject(content);
			JSONObject contactUs = jsonObject.getJSONObject("contactUs");
			name = contactUs.getString("name");
			email = contactUs.getString("email");
			phone = contactUs.getString("phone");
			message = contactUs.getString("message");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void closeDriver() {
		if(driver != null) {driver.quit();}
	}

	@Test
	public void testUrlAndTitle(){
		HeaderPage header = new HeaderPage(driver);
		ContactUsPage contact = header.getContactUsPage(driver);
		Assert.assertTrue(contact.sendMessage(name, email, phone, message), "There ISN'T success alert");
	}

}
