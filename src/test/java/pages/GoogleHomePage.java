package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

public class GoogleHomePage extends BasePage {

	public GoogleHomePage(WebDriver driver) {
		super(driver);

	}

	private String srch$Box = "//input[@title='Search']";

	public void enterGoogleSearchString(String srchString) throws AWTException {
		enterText(srch$Box, srchString);
		clickEnter();
		waitForPageToLoad();
		
	}
}
