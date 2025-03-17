package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Header {

	private WebDriver driver;

	public Header(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.CSS, using = "ul.HorizontalList.HorizontalList--spacingLoose.hidden-pocket>li:first-child>a")
	private WebElement accountLink;

	@FindBy(how = How.CSS, using = "li>a[data-action='toggle-search']")
	private WebElement searchLink;

	@FindBy(css = "li>a[data-drawer-id='sidebar-cart']")
	private WebElement cartLink;

	@FindBy(css = ".Header__LogoImage--primary")
	private WebElement primaryLogo;

	@FindBy(css = ".Header__LogoImage--transparent")
	private WebElement transparentLogo;

	@FindBy(css = ".Header__LogoLink")
	private WebElement logoLink;

	public boolean isAccountLinkDisplay() {
		return accountLink.isDisplayed();
	}

	public boolean isSearchLinkDisplay() {
		return searchLink.isDisplayed();
	}

	public boolean isCartLinkDisplay() {
		return cartLink.isDisplayed();
	}

	public  boolean isPrimaryLogoDisplay(){
		return primaryLogo.isDisplayed();
	}

	public  boolean isTransparentDisplay(){
		return transparentLogo.isDisplayed();
	}

	public  boolean isLogoLinkDisplay(){
		return logoLink.isDisplayed();
	}

	public String getAccountLinkHref() {
		return accountLink.getDomAttribute("href");
	}

	public String getSearchLinkHref() {
		return searchLink.getDomAttribute("href");
	}

	public String getCartLinkHref() {
		return cartLink.getDomAttribute("href");
	}

	public String getPrimaryLogoAltText(){
		return primaryLogo.getDomAttribute("alt");
	}

	public void clickSearchLink() {
		searchLink.click();
	}

	public void clickAccountLink() {
		accountLink.click();
	}

	public void clickCartLink() {
		cartLink.click();
	}


}
