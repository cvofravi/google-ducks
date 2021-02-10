package pages;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	protected WebDriver driver;
	private FluentWait<WebDriver> fluentWait;
	private Duration fluentWaitDuration = Duration.ofSeconds(2000);
	private Duration fluentPollDuration = Duration.ofSeconds(2000);
	private final JavascriptExecutor javaScriptExecutor;
	private static final String Enter_Value_JS = "arguments[0].value='%s';";

	public BasePage(WebDriver driver) {
		this.driver = driver;
		fluentWait = new FluentWait<WebDriver>(driver).withTimeout(fluentWaitDuration).pollingEvery(fluentPollDuration)
				.ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(NoSuchElementException.class);
		javaScriptExecutor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @param locator
	 * @return WebElement
	 */
	protected WebElement getElementByxPath(final String locator) {
		return fluentWait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});
	}

	/**
	 * 
	 * @param locator
	 * @return boolean
	 */
	protected boolean isDisplayed(final String locator) {
		return getElementByxPath(locator).isDisplayed() == true ? true : false;
	}

	/**
	 * 
	 * @param locator
	 * @param value
	 */
	protected void enterText(final String locator, final String value) {
		WebElement ele = getElementByxPath(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	/**
	 * 
	 * @param locator
	 * @param value
	 */
	protected void enterTextJS(final String locator, final String value) {
		WebElement ele = getElementByxPath(locator);
		ele.clear();
		javaScriptExecutor.executeScript(String.format(Enter_Value_JS, value), ele);
	}

	/**
	 * 
	 * @param locator
	 */
	protected void clickElement(final String locator) {
		getElementByxPath(locator).click();
	}

	/**
	 * 
	 * @param locator
	 * @return
	 */
	protected String getText(final String locator) {
		return getElementByxPath(locator).getText();
	}

	/**
	 * 
	 * @throws AWTException
	 */
	protected void clickEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * 
	 */
	protected void waitForPageToLoad() {
		javaScriptExecutor.executeScript("return document.readyState").equals("complete");
	}
}
