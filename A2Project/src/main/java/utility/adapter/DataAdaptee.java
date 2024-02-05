package utility.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Interface Class represent the Adaptee
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see TextAdaptee
 * @see XMLAdaptee
 */
public interface DataAdaptee {

    /**
     * Method for convert the json to other format
     *
     * @param jsonNode JSON
     * @return String
     * @throws JsonProcessingException
     */
    public String jsonConverter(JsonNode jsonNode) throws JsonProcessingException;
}
