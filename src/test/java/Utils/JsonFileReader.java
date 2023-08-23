
package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * The JsonFileReader class provides methods to read values from a JSON file.
 */
public class JsonFileReader {

    /**
     * Reads the value associated with the provided field name from a JSON file.
     *
     * @param fieldName The name of the field for which the value needs to be retrieved.
     * @return The value associated with the provided field name, or an empty string if not found.
     * @throws FileNotFoundException if the JSON file is not found.
     */
    public String readKeyJson(String fieldName) throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src\\test\\resources\\Configuration\\keys.json");
        String value = "";
        try {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            value = (String) jsonObject.get(fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
