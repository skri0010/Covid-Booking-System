package booking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class represent the OnSiteBooking
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see Booking
 */
public class OnSiteBooking extends Booking{

    /**
     * Constructor for on-site booking
     *
     * @param customerId        Customer ID
     * @param testingSiteId     Testing Site ID
     * @param startTime         Booking Start Time
     * @param notes             Booking Notes
     */
    public OnSiteBooking(String customerId, String testingSiteId, String startTime, String notes) {
        super(customerId, testingSiteId, startTime, notes);
    }

    /**
     * Set additional Info
     *
     * @throws JsonProcessingException
     */
    public void setAdditionalJson() throws JsonProcessingException {
        String Json = "{" +
                "\"bookHomeTesting\":" + false + "," +
                "\"bookOnSiteTesting\":" + true + "," +
                "\"hasRATKit\":" + false + "," +
                "\"URL\":\"" + "" + "\"," +
                "\"QRCode\":\"" + "" + "\"" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(Json);
        super.setAdditionalInfo(jsonNode);
    }
}
