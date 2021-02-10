package pages;

import java.util.HashMap;

import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import net.minidev.json.JSONArray;

public class RestApiPage {

	/**
	
	 */
	public RestApiPage() {

	}

	public static Response response;

	public Response getRequest(String endpoint) {
		try {
			response = RestAssured.given().headers("Content-Type", "application/Json").get(endpoint);
			System.out.println("Print response Body" + response.getBody().asString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public Response postAPIResponse(String endpoint, String payload) {

		try {
			response = RestAssured.given().body(payload).delete(endpoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public Integer getResponseNumberOfIDs() {
		JSONArray responserows = null;
		HashMap<String, String> EmployeeDetails = new HashMap<String, String>();
		ResponseBody body = response.getBody();
		String responseBody = body.asString();
		System.out.println("Response body::" + responseBody);
		
		
		try {
			 responserows = JsonPath.read(responseBody, "[*].id");
			System.out.println("Total ID's::" + responserows.size());
		} catch (Exception e) {

		}
		return responserows.size();
	}

	public void deleteAPIResponse() {

	}
}
