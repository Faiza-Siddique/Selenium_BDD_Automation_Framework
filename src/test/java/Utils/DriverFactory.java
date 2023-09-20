package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The DriverFactory class provides methods to initialize and manage a WebDriver instance
 * along with a WebDriverWait instance for browser automation.
 */
public class DriverFactory {

    /**
     * The WebDriver instance used for browser automation.
     */
    public static WebDriver driver;

    /**
     * The WebDriverWait instance used for waiting for elements in the WebDriver.
     */
    public static WebDriverWait webDriverWait;

    /**
     * Initializes the WebDriver instance with ChromeOptions, maximizing the browser window,
     * and sets up the WebDriverWait instance with a timeout of 10 seconds.
     */
    public static void initializeDriver() {
        // Create ChromeOptions and add arguments
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        // Initialize WebDriver with ChromeDriver and provided ChromeOptions
        driver = new ChromeDriver(chromeOptions);

        // Initialize WebDriverWait with the WebDriver and a timeout of 10 seconds
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Closes the WebDriver instance.
     */
    public static void quitDriver(){
        driver.close();
    }


}
