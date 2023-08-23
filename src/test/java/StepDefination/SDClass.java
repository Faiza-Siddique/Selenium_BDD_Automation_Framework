package StepDefination;

import Pages.PageClass;
import Utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.FileNotFoundException;

/**
 * The SDClass class defines step definitions for Cucumber scenarios related to browser automation.
 * It extends the DriverFactory class to manage WebDriver instances and encapsulates interactions
 * with the PageClass for page-specific actions.
 */

public class SDClass extends DriverFactory {

    PageClass pageClass;

    /**
     * Initializes a new instance of the SDClass and creates an instance of PageClass.
     *
     * @throws Exception if an error occurs during PageClass instantiation.
     */

    public SDClass() throws Exception {
        pageClass = new PageClass();
    }

    /**
     * Initiates the browser by initializing the WebDriver.
     */
    @Given("user opens the browser")
    public void userOpensTheBrowser() {
        initializeDriver();
    }

    /**
     * Navigates the user to a specific URL.
     */
    @Then("user navigates to the URL")
    public void userNavigatesToTheURL() {
        pageClass.openURL();
    }

    /**
     * Enters text into the username field.
     *
     * @throws InterruptedException if the operation is interrupted.
     * @throws FileNotFoundException if the property file is not found.
     */
    @When("user enter text in username field")
    public void userEnterTextInUsernameField() throws InterruptedException, FileNotFoundException {
        pageClass.enterTextInFieldFromProperties("Username","username");
    }

    /**
     * Enters text into the password field.
     *
     * @throws FileNotFoundException if the property file is not found.
     */
    @When("user enter text in password field")
    public void userEnterTextInPasswordField() throws FileNotFoundException {
        pageClass.enterTextInFieldFromProperties("Password", "password");
    }

    /**
     * Clicks on a specified element based on the given field name.
     *
     * @param fieldName The name of the element to click.
     * @throws FileNotFoundException if the property file is not found.
     */
    @Then("user click on the {string}")
    public void userClickOnThe(String fieldName) throws FileNotFoundException {
        pageClass.clickButton(fieldName);
    }

    /**
     * Enters specified text into a specified field.
     *
     * @param value     The text value to enter.
     * @param fieldName The name of the field to enter text into.
     * @throws FileNotFoundException if the property file is not found.
     */
    @When("user enter text {string} in {string} field")
    public void userEnterTextInField(String value, String fieldName) throws FileNotFoundException {
        pageClass.enterTextInField(value, fieldName);
    }

    /**
     * Closes the browser by quitting the WebDriver.
     */
    @Given("user Close The Browser")
    public void userCloseTheBrowser() {
        quitDriver();
    }
}
