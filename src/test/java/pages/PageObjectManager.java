package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;
	private BasePage basePage;
	private GoogleHomePage googleHomePage;
	private DucksResultsPage ducksResultsPage;

	/**
	 * @return the ducksResultsPage
	 */
	public DucksResultsPage getDucksResultsPage() {
		return ducksResultsPage == null ? ducksResultsPage = new DucksResultsPage(driver) : ducksResultsPage;
	}

	/**
	 * @return the googleSearchPage
	 */
	public GoogleHomePage getGoogleSearchPage() {
		return googleHomePage == null ? googleHomePage = new GoogleHomePage(driver) : googleHomePage;
	}

	/**
	 * @return the basePage
	 */
	public BasePage getBasePage() {
		return basePage == null ? basePage = new BasePage(driver) : basePage;
	}

	/**
	 * @param driver
	 */
	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
