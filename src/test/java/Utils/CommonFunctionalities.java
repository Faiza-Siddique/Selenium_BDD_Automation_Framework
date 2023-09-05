package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.util.Properties;

public class CommonFunctionalities extends DriverFactory {
    private WebElement element;
    private ConfigFileReader configFileReader = new ConfigFileReader();
    private Properties properties = configFileReader.getProperty("Config");
    private JsonFileReader jsonFileReader = new JsonFileReader();

    /**
     * Default constructor for the PageClass.
     */
    public CommonFunctionalities() {
        // Empty constructor
    }

    /**
     * Navigates to the URL specified in the configuration properties.
     */
    public void navigateToURL() {
        driver.get(properties.getProperty("url"));
    }

    /**
     * Enters text into a field using data from properties file.
     *
     * @param fieldName     The field name associated with the element.
     * @param propertyName  The property name in the configuration properties file.
     * @throws FileNotFoundException if property file is not found.
     */
    public void enterTextInFieldFromPropertiesFile(String fieldName, String propertyName) throws FileNotFoundException {
        String xPath = jsonFileReader.readKeyJson(fieldName);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        element = driver.findElement(By.xpath(xPath));
        element.clear();
        element.sendKeys(properties.getProperty(propertyName));
    }

    /**
     * Clicks a button based on the provided name using XPath from JSON file.
     *
     * @param name The name associated with the button element in JSON file.
     * @throws FileNotFoundException if JSON file is not found.
     */
    public void clickButton(String name) throws FileNotFoundException {
        String xPath = jsonFileReader.readKeyJson(name);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        element = driver.findElement(By.xpath(xPath));
        element.click();
    }

    /**
     * Enters text into a field using provided value and XPath from JSON file.
     *
     * @param value     The text value to enter.
     * @param fieldName The field name associated with the element in JSON file.
     * @throws FileNotFoundException if JSON file is not found.
     */
    public void enterTextValue(String value, String fieldName) throws FileNotFoundException {
        String xPath = jsonFileReader.readKeyJson(fieldName);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        element = driver.findElement(By.xpath(xPath));
        element.clear();
        element.sendKeys(value);
    }
    /**
     * Selects a value from a dropdown list based on the visible text.
     *
     * @param value The visible text of the option to be selected from the dropdown.
     * @param fieldname The identifier for the dropdown element, used to retrieve its XPath from a JSON configuration.
     * @throws FileNotFoundException If the JSON configuration file containing the XPaths is not found.
     */
    public void selectValueFromTheDropdown(String value, String fieldname) throws FileNotFoundException {
        // Read the XPath from the JSON configuration file based on the provided fieldname
        String xPath = jsonFileReader.readKeyJson(fieldname);

        // Find the web element using the obtained XPath
        element = driver.findElement(By.xpath(xPath));

        // Wait for the element to become visible before interacting with it
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));

        // Create a Select object from the found element
        Select dropdown = new Select(element);

        // Select the dropdown option by its visible text
        dropdown.selectByVisibleText(value);
    }

    public  void selectCheckBox(String Name) throws FileNotFoundException {
        String xPath = jsonFileReader.readKeyJson(Name);
        element = driver.findElement(By.xpath(xPath));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        element.click();
    }
}

