package booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;


/**
 * Class representing the Booking.

 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see HomeBooking
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking implements BookingInterface{

    /**
     * Booking ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * Customer ID
     */
    private String customerId;
    /**
     * Customer Object
     */
    private JsonNode customer;
    /**
     * Testing Site Object
     */
    private JsonNode testingSite;
    /**
     * Testing Site ID
     */
    private String testingSiteId;
    /**
     * Booking Start Time
     */
    private String startTime;
    /**
     * Booking Note
     */
    private String notes;
    /**
     * Booking Sms PIN code
     */
    private String smsPin;
    /**
     * Status of the booking
     */
    private String status;
    private JsonNode additionalInfo;

    private boolean bookHomeTesting;
    private boolean bookOnSiteTesting;
    private boolean hasRATKit;
    private String URL;
    private String QRCode;
    private JsonNode bookingMemento;

    /**
     * Constructor of the Booking for creating new Booking
     *
     * @param customerId        Customer ID
     * @param testingSiteId     Testing Site ID
     * @param startTime         Booking Start Time
     * @param notes             Booking Notes
     */
    public Booking(String customerId, String testingSiteId, String startTime, String notes) {
        this.customerId = customerId;
        this.testingSiteId = testingSiteId;
        this.startTime = startTime;
        this.notes = notes;
    }

    /**
     * Constructor of Booking which create for patching the data
     * @param booking Booking object
     * @param additionalInfo    Booking additional Information
     */
    public Booking(Booking booking, JsonNode additionalInfo) {
        this.id = booking.getId();
        this.customerId = booking.getCustomer().get("id").textValue();
        this.testingSiteId = booking.getTestingSite().get("id").textValue();
        this.startTime = booking.getStartTime();
        this.notes = booking.getNotes();
        this.status = booking.getStatus();
        this.additionalInfo = additionalInfo;
    }
    public Booking() {
    }

    /**
     * Method for create the String for the attributes inside the additionalInfo
     *
     * @return String
     */
    public String stringify(){
        return "{" +
                "\"customerId\":\"" + customerId + "\"," +
                "\"testingSiteId\":\"" + testingSiteId + "\"," +
                "\"startTime\":\"" + startTime + "\"," +
                "\"notes\":\"" + notes + "\"," +
                "\"additionalInfo\":" + additionalInfo +
                "}";
    }

    /**
     * Method for create the  Patch String for the attributes inside the additionalInfo
     *
     * @return String
     */
    public String patchStringify(){
        return "{" +
                "\"customerId\":\"" + customerId + "\"," +
                "\"testingSiteId\":\"" + testingSiteId + "\"," +
                "\"startTime\":\"" + startTime + "\"," +
                "\"notes\":\"" + notes + "\"," +
                "\"status\":\"" + status + "\"," +
                "\"additionalInfo\":" + additionalInfo +
                "}";
    }

    public JsonNode getCustomer() {
        return customer;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer(JsonNode customer) {
        this.customer = customer;
    }

    public JsonNode getTestingSite() {
        return testingSite;
    }

    public void setTestingSite(JsonNode testingSite) {
        this.testingSite = testingSite;
        this.testingSiteId = testingSite.get("id").asText();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdditionalInfo(JsonNode additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSmsPin() {
        return smsPin;
    }

    public String getStatus() {
        return status;
    }

    public JsonNode getAdditionalInfo() {
        return additionalInfo;
    }

    public boolean getBookHomeTesting() {
        this.bookHomeTesting = getAdditionalInfo().get("bookHomeTesting").asBoolean();
        return bookHomeTesting;
    }

    public boolean getBookOnSiteTesting() {
        this.bookOnSiteTesting = getAdditionalInfo().get("bookOnSiteTesting").asBoolean();
        return bookOnSiteTesting;
    }

    public boolean isHasRATKit() {
        this.hasRATKit = getAdditionalInfo().get("hasRATKit").asBoolean();
        return hasRATKit;
    }
    public JsonNode getBookingMemento(){
        return this.additionalInfo.get("bookingMemento");
    }

    public String getURL() {
        this.URL = getAdditionalInfo().get("URL").textValue();
        return this.URL;
    }

    public String getQRCode() {
        this.QRCode = getAdditionalInfo().get("QRCode").textValue();
        return QRCode;
    }
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    public void  setTestingSiteId(String testingSiteId){
        this.testingSiteId = testingSiteId;
    }
    public BookingMemento getMemento() {
        BookingMementoInternal state = new BookingMementoInternal();
        state.setStartTime(startTime);
        state.setTestingSiteId(this.getTestingSite().get("id").asText());
        return state;
    }
    public void setMemento(BookingMemento memento) {
        BookingMementoInternal state = (BookingMementoInternal) memento;
        this.startTime = state.getStartTime();
        this.testingSiteId = state.getTestingSiteId();
    }


    @Override
    public void setAdditionalJson() throws JsonProcessingException {

    }

}
