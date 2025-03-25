package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage{

	private WebDriver driver;

	public ContactUsPage (WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='contact[name]']")
	private WebElement yourNameInputField;
	@FindBy(css = "input[name='contact[email]']")
	private WebElement yourEmailInputField;
	@FindBy(css = "input[name='contact[Your phone]']")
	private WebElement yourPhoneInputField;
	@FindBy(css = "textarea[name='contact[body]']")
	private WebElement  messageInputField;
	@FindBy(css = "form#contact_form>button")
	private WebElement  sendMessageButton;

	private String successAlert = "p.Alert.Alert--success";



	public void fillYourName(String name){
		yourNameInputField.sendKeys(name);
	};

	public void fillYourEmail(String email){
		yourEmailInputField.sendKeys(email);
	};

	public void fillYourPhone(String phone){
		yourPhoneInputField.sendKeys(phone);
	};

	public void fillYourMessage(String message){
		messageInputField.sendKeys(message);
	};

	public void clickSendMessageButton(){
		sendMessageButton.click();
	};

	public boolean sendMessage(String name, String email, String phone, String message){
		fillYourName(name);
		fillYourEmail(email);
		fillYourPhone(phone);
		fillYourMessage(message);
		clickSendMessageButton();
		return isSuccessAlertVisible(By.cssSelector(successAlert));
	}










}
