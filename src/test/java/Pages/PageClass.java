/**
 * The PageClass class encapsulates interactions with web elements on different pages.
 * It extends the DriverFactory class to manage WebDriver instances.
 */
package Pages;

import Utils.CommonFunctionalities;
import Utils.DriverFactory;
import java.io.FileNotFoundException;


public class PageClass extends DriverFactory {
    CommonFunctionalities commonFunctionalities = new CommonFunctionalities();

    /**
     * Default constructor for the PageClass.
     */
    public PageClass() {
        // Empty constructor
    }

    /**
     * Opens the URL specified in the configuration properties.
     */
    public void openURL() {
       commonFunctionalities.navigateToURL();
    }

    /**
     * Enters text into a field using data from properties file.
     *
     * @param fieldName     The field name associated with the element.
     * @param propertyName  The property name in the configuration properties file.
     * @throws FileNotFoundException if property file is not found.
     */
    public void enterTextInFieldFromProperties(String fieldName, String propertyName) throws FileNotFoundException {
       commonFunctionalities.enterTextInFieldFromPropertiesFile(fieldName, propertyName);
    }

    /**
     * Clicks a button based on the provided name using XPath from JSON file.
     *
     * @param name The name associated with the button element in JSON file.
     * @throws FileNotFoundException if JSON file is not found.
     */
    public void click(String name) throws FileNotFoundException {
       commonFunctionalities.clickButton(name);

    }

    /**
     * Enters text into a field using provided value and XPath from JSON file.
     *
     * @param value     The text value to enter.
     * @param fieldName The field name associated with the element in JSON file.
     * @throws FileNotFoundException if JSON file is not found.
     */
    public void enterTextInField(String value, String fieldName) throws FileNotFoundException {
       commonFunctionalities.enterTextValue(value, fieldName);
    }
}
