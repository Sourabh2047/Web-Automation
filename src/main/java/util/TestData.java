package util;

import browser.Constants;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestData {

    public static JsonNode jsonNode = null;

    public static JsonNode getJsonNode() {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(Constants.TEST_DATA_PATH);
            jsonNode = objectMapper.readValue(file, JsonNode.class);
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    public static String getDataValue(String parentNode, String key) {
        return jsonNode.get(parentNode).get(key).asText();
    }
}
