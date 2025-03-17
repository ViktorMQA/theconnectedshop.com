package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

	private WebDriver driver;

	public HomePage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}

}
