package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {

	private WebDriver driver;

	public SearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='q']")
	private WebElement searchField;
	@FindBy(xpath = "//div[@class='Segment__Content']/p[text()='No results could be found']")
	private WebElement noResult;

	public boolean isDisplaySearchField(){
		return searchField.isDisplayed();
	}

	public boolean isEnabledSearchField(){
		return searchField.isEnabled();
	}

	public void fillSearchField(String text){
		searchField.sendKeys(text);
		Assert.assertEquals(searchField.getDomAttribute("value"), text);
	}

	public  boolean isDisplayNoResult() {
		return noResult.isDisplayed();
	}

	public String getNoResultText() {
		return noResult.getText();
	}

}
