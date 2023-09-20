/**
 * The TestRunner class serves as the entry point for running Cucumber tests.
 * It configures Cucumber options and specifies the glue code package and feature file locations.
 */
package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "StepDefination",            // Package containing step definition classes
        features = "src/test/resources/Features",  // Location of feature files
        monochrome = true,
        // Enable readable console output
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}


)
public class TestRunner {
    /**
     * Default constructor for the TestRunner class.
     */
    public TestRunner() {
        // Empty constructor
    }


}
