package pages;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver){
		this.driver = driver;
	}


	private void waitForElement(
			long timeoutInMillis,
			ExpectedCondition<?> condition) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofMillis(timeoutInMillis))
				.pollingEvery(Duration.ofMillis(500L))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(condition);
	}

	public void expectElementVisibleDuringTimeout(
			By by,
			long timeoutInMs) {
		try {
			waitForElement(timeoutInMs, ExpectedConditions.visibilityOfElementLocated(by));
			log.info("Element with locator: {} is visible during timeout: {}", by, timeoutInMs);
		} catch (TimeoutException e) {
			throw new TimeoutException(String.format("the element with locator: %s is NOT visible during %s ms", by, timeoutInMs));
		}
	}

	public boolean isSuccessAlertVisible(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successAlertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return successAlertElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}


}
