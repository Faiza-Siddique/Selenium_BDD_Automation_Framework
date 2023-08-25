
package Utils;

import java.io.*;
import java.util.Properties;

/**
 * The ConfigFileReader class provides methods to read properties from configuration files.
 */
public class ConfigFileReader {

    /**
     * Retrieves properties from a configuration file based on the provided filename.
     *
     * @param property The name of the configuration file (without extension) to read properties from.
     * @return A Properties object containing the properties read from the configuration file.
     */
    static public Properties getProperty(String property) {
        Properties properties = new Properties();

        try {
            File propertyFile = new File("src/test/resources/Configuration/" + property + ".properties");
            if (propertyFile.exists())
                properties.load(new FileInputStream(propertyFile));
            else
                System.out.println("File not found: " + property);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
