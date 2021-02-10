package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

public class DucksResultsPage extends BasePage {

	public DucksResultsPage(WebDriver driver) {
		super(driver);

	}

	private String txt$NHLDucks = "//span[contains(text(),'Official Anaheim Ducks Website | NHL.com')]";
	private String txt$DucksByShape = "//span[contains(text(),'Ducks Browse by Shape, All About Birds, Cornell Lab of ...')]";
	private String txt$DucksWiki = "//span[contains(text(),'Duck - Wikipedia')]";
	private String txt$DucksTypes = "//span[contains(text(),'Types of Ducks & Geese | Duck Identification - Ducks Unlimited')]";

	public String getNHLSerachText() {
		return getText(txt$NHLDucks);

	}
	public String getDucksByShapeText() {
		return getText(txt$DucksByShape);

	}
	public String getDucksWikiText() {
		return getText(txt$DucksWiki);

	}
	public String getDucksTypes() {
		return getText(txt$DucksTypes);

	}
}
