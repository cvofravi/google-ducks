package stepDefinitions;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class GoogleDucksSteps extends BaseSteps {

	@Given("I am on Google WebSite")
	public void i_am_on_google_web_site(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String url = data.get(0).get("URL");
		getDriverObject().get("http://www.google.com");
	}

	@Given("Search for Ducks")
	public void search_for_ducks(io.cucumber.datatable.DataTable dataTable) throws AWTException {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String srchString = data.get(0).get("Search");
		pageObjectManager.getGoogleSearchPage().enterGoogleSearchString(srchString);
	}

	@When("results are Displayed")
	public void results_are_displayed() {

	}

	@Then("verify Anaheim NHL Ducks is in the result")
	public void verify_anaheim_nhl_ducks_is_in_the_result() {
		String expected = "Official Anaheim Ducks Website";
		String actual = pageObjectManager.getDucksResultsPage().getNHLSerachText();

		Assert.assertTrue("NHL Ducks text Verified in the Google Ducks Search Results Successfully",
				actual.contains(expected));
		log.info("NHL Ducks text Verified in the Google Ducks Search Results Successfully");
	}

	@Then("verify Ducks By Shapes in the result")
	public void verify_ducks_by_shapes_in_the_result() {
		String expected = "Ducks Browse by Shape";
		String actual = pageObjectManager.getDucksResultsPage().getDucksByShapeText();

		Assert.assertTrue("Ducks By Shape text Verified in the Google Ducks Search Results Successfully",
				actual.contains(expected));
		log.info("Ducks By Shape text Verified in the Google Ducks Search Results Successfully");
	}

	@Then("verify Ducks Wiki in the result")
	public void verify_ducks_wiki_in_the_result() {
		String expected = "Duck - Wikipedia";
		String actual = pageObjectManager.getDucksResultsPage().getDucksWikiText();

		Assert.assertTrue("Ducks Wiki text Verified in the Google Ducks Search Results Successfully",
				actual.contains(expected));
		log.info("Ducks Wiki text Verified in the Google Ducks Search Results Successfully");
	}

	@Then("verify Ducks Types in the result")
	public void verify_ducks_types_in_the_result() {
		String expected = "Types of Ducks & Geese";
		String actual = pageObjectManager.getDucksResultsPage().getDucksTypes();

		Assert.assertTrue("Ducks Types text Verified in the Google Ducks Search Results Successfully",
				actual.contains(expected));
		log.info("Ducks Types text Verified in the Google Ducks Search Results Successfully");
	}

	@Then("Navigate to Anaheim Ducks Website Successfully")
	public void navigate_to_anaheim_ducks_website_successfully() {

	}
}
