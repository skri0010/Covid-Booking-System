package utility.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Class represent the ResponseAdapter
 * Reference Adapter: <a href="https://github.com/aaleti/java-design-patterns/tree/master/adapter">...</a>
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see DataAdaptee
 * @see XMLAdaptee
 * @see TextAdaptee
 */
public class ResponseAdapter {

    /**
     * The Adaptee
     */
    private DataAdaptee dataAdaptee;
    /**
     * Constructor for the Adapter
     * @param dataAdaptee Adaptee class
     */
    public ResponseAdapter(DataAdaptee dataAdaptee) {
        this.dataAdaptee = dataAdaptee;
    }

    /**
     * Method to convert the json
     *
     * @param jsonNode JSON
     * @return String
     * @throws JsonProcessingException
     */
    public String convertFormat(JsonNode jsonNode) throws JsonProcessingException {
        return this.dataAdaptee.jsonConverter(jsonNode);
    }
}
