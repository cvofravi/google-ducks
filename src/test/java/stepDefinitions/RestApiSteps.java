package stepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.restassured.response.Response;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.RestApiPage;

public class RestApiSteps {
	RestApiPage restfulPage = new RestApiPage();
	Response response;

	@Given("I Hit Get Request and verify")
	public void i_hit_get_request_and_verify(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String url = data.get(0).get("URL");

		response = restfulPage.getRequest(url);

		int successCode = response.getStatusCode();
		if (successCode != 200) {
			System.out.println("Expected Success Code 200 Not Displayed::");
			Assert.assertTrue("Expected Success Code::" + 200 + "Actual Code::"+successCode, successCode == 200);
		} else {
			Assert.assertTrue("Expected Success Code::" + 200 + "Actual Code::"+successCode, successCode == 200);
			System.out.println("Verify Expected Success Code 200 Successfully");
		}
		

	}

	@Then("Verify Total Number of ID")
	public void verify_total_number_of_id(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		Integer expectedNoOfIDs = Integer.parseInt(data.get(0).get("ExpectedIDs"));
		
		Integer actualNoOfIDs = restfulPage.getResponseNumberOfIDs();
		Assert.assertTrue("Expected ID's::" + expectedNoOfIDs + "Actual ID's::"+actualNoOfIDs, expectedNoOfIDs == actualNoOfIDs);
		System.out.println("Verify Number of ID is Successful::");
	}
}
