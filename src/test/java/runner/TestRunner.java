package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        monochrome = true,
        glue = "stepDefs",
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        tags = "@Regression"
)

public class TestRunner {

}
