package booking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class represent the HomeBooking
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see Booking
 */
public class HomeBooking extends Booking{

    /**
     * Boolean for havingRATKit
     */
    private boolean hasRATKit;
    /**
     * URL
     */
    private String URL;
    /**
     * QRCode
     */
    private String QRCode;

    /**
     * Constructor for HomeBooking for creating new home booking
     *
     * @param customerId        Customer ID
     * @param testingSiteId     Testing Site ID
     * @param startTime         Booking Start Time
     * @param notes             Booking Notes
     * @param QrCode            QR Code
     * @param URL               URL
     * @param hasRATKit         hasRatkit
     * @throws JsonProcessingException
     */
    public HomeBooking(String customerId, String testingSiteId, String startTime, String notes, String QrCode, String URL, boolean hasRATKit) throws JsonProcessingException {
        super(customerId, testingSiteId, startTime, notes);
        this.QRCode = QrCode;
        this.URL = URL;
        this.hasRATKit = hasRATKit;
    }

    /**
     * Constructor for HomeBooking for creating the booking class that change the attribute
     *
     * @param id                Booking ID
     * @param customerId        Customer ID
     * @param testingSiteId     Testing Site ID
     * @param startTime         Booking Start Time
     * @param notes             Booking Notes
     * @param status            Booking Status
     * @param additionalInfo    Booking additional Information
     */
    public HomeBooking(Booking booking, JsonNode additionalInfo) {
        super(booking, additionalInfo);
    }

    public boolean isHasRATKit() {
        this.hasRATKit = getAdditionalInfo().get("hasRATKit").asBoolean();
        return hasRATKit;
    }

    public String getURL() {
        this.URL = getAdditionalInfo().get("URL").textValue();
        return URL;
    }

    public String getQRCode() {
        this.QRCode = getAdditionalInfo().get("QRCode").textValue();
        return QRCode;
    }

    /**
     * Set additional Info
     *
     */

    public void setAdditionalJson() throws JsonProcessingException {
        String Json = "{" + "\"bookHomeTesting\":" + true + "," +
                "\"bookOnSiteTesting\":" + false + "," +
                "\"hasRATKit\":" + hasRATKit + "," +
                "\"URL\":\"" + URL + "\"," +
                "\"QRCode\":\"" + QRCode + "\"" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(Json);
        super.setAdditionalInfo(jsonNode);
    }

}
