package cucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumberHtmlReport"},
		tags="@apiTesting",
		features="src/test/resources/features",
		glue="stepDefinitions")
public class TestRunner {

}
