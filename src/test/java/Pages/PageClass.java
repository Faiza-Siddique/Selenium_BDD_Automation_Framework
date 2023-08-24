/**
 * The PageClass class encapsulates interactions with web elements on different pages.
 * It extends the DriverFactory class to manage WebDriver instances.
 */
package Pages;

import Utils.ConfigFileReader;
import Utils.DriverFactory;
import Utils.JsonFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;
import java.util.Properties;

public class PageClass extends DriverFactory {

    private WebElement element;
    private ConfigFileReader configFileReader = new ConfigFileReader();
    private Properties properties = configFileReader.getProperty("Config");
    private JsonFileReader jsonFileReader = new JsonFileReader();

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
        driver.get(properties.getProperty("url"));
    }

    /**
     * Enters text into a field using data from properties file.
     *
     * @param fieldName     The field name associated with the element.
     * @param propertyName  The property name in the configuration properties file.
     * @throws FileNotFoundException if property file is not found.
     */
    public void enterTextInFieldFromProperties(String fieldName, String propertyName) throws FileNotFoundException {
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
    public void enterTextInField(String value, String fieldName) throws FileNotFoundException {
        String xPath = jsonFileReader.readKeyJson(fieldName);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        element = driver.findElement(By.xpath(xPath));
        element.clear();
        element.sendKeys(value);
    }
}
