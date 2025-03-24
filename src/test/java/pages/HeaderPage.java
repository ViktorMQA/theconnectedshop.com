package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




@Slf4j
public class HeaderPage {

	private WebDriver driver;

	public HeaderPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.CSS, using = "ul.HorizontalList.HorizontalList--spacingLoose.hidden-pocket>li:first-child>a")
	public WebElement accountLink;

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

	@FindBy(css = "li>a[href='/pages/contact-us'].Heading.u-h6")
	private WebElement contactUs;

	// isDisplay
	public boolean isAccountLinkDisplay() {
		try{
			boolean result = accountLink.isDisplayed();
			if (result) {
				log.info("The element: {} is display", accountLink.getText());
			}
			return result;
		} catch (NoSuchElementException e) {
			return  false;
		}
	}

	public boolean isDisplay(WebElement element){
		return element.isDisplayed();
	}

	public boolean isSearchLinkDisplay() {
		try{
			return searchLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return  false;
		}
	}

	public boolean isCartLinkDisplay() {
		try{
			return cartLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return  false;
		}
	}

	public  boolean isPrimaryLogoDisplay(){
		try{
			return primaryLogo.isDisplayed();
		} catch (NoSuchElementException e) {
			return  false;
		}
	}

	public  boolean isTransparentLogoDisplay(){
		try{
			return transparentLogo.isDisplayed();
		} catch (NoSuchElementException e) {
			return  false;
		}
	}

	public  boolean isLogoLinkDisplay(){
		try{
			return logoLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return  false;
		}
	}

    // getAttributes
	public String getAccountLinkHref() {
		return accountLink.getDomAttribute("href");
	}

	public String getSearchLinkHref() { return searchLink.getDomAttribute("href"); }

	public String getCartLinkHref() {
		return cartLink.getDomAttribute("href");
	}

	public String getPrimaryLogoAltText(){
		return primaryLogo.getDomAttribute("alt");
	}

    // clickElements
	public void clickSearchLink() {
		searchLink.click();
	}

	public void clickAccountLink() { accountLink.click(); }

	public void clickCartLink() {
		cartLink.click();
	}

	public ContactUsPage getContactUsPage(WebDriver driver){
		contactUs.click();
		return new ContactUsPage(driver);
	}


}
