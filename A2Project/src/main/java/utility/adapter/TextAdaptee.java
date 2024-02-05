package utility.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class represent the TextAdaptee
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see DataAdaptee
 * @see XMLAdaptee
 */
public class TextAdaptee implements DataAdaptee {

    /**
     * Constructor for the TextAdaptee
     */
    public TextAdaptee() {
    }

    /**
     * Convert the JSON to Text
     *
     * @param jsonNode JSON
     * @return String
     * @throws JsonProcessingException
     */
    @Override
    public String jsonConverter(JsonNode jsonNode) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(jsonNode);
        return result;
    }
}
