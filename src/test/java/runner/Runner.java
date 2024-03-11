package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/OrangeAutomationTest.feature"},
        glue = "stepDefinitions",
        plugin = {"junit:target/cucumber/result.xml", "json:target/cucumber/calculator.json"}
)
public class Runner {
}
