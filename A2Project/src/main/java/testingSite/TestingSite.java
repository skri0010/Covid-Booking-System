package testingSite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Class representing the TestingSite

 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see TestingSiteSingleton
 * @see TestingSiteType
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestingSite {

    private TestingSiteType testingSiteType;
    private String id;
    private String name;
    private String description;
    private String websiteUrl;
    private String phoneNumber;
    private ObjectNode address;
    private ObjectNode additionalInfo;
    private JsonNode bookings;
    private String openingTime;
    private String closeTime;
    private String type;
    private Boolean isDriveThrough;
    private Boolean isWalkIn;
    private boolean onSiteBooking;
    private boolean onSiteTesting;
    private boolean homeTesting;
    private String suburb;

    public TestingSite() {
        this.testingSiteType = new TestingSiteType();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestingSiteType getTestingSiteType() {
        return testingSiteType;
    }

    public void setTestingSiteType(TestingSiteType testingSiteType) {
        this.testingSiteType = testingSiteType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ObjectNode getAddress() {
        return address;
    }

    public void setAddress(ObjectNode address) {
        this.address = address;
    }

    public ObjectNode getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(ObjectNode additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public JsonNode getBookings() {
        return bookings;
    }

    public void setBookings(JsonNode bookings) {
        this.bookings = bookings;
    }

    public String getOpeningTime() {
        this.openingTime = getAdditionalInfo().get("openingTime").textValue();
        return openingTime;
    }

    public String getSuburbName() {
        this.suburb = getAddress().get("suburb").textValue();
        return suburb;
    }

    public String getCloseTime() {
        this.closeTime = getAdditionalInfo().get("closeTime").textValue();
        return closeTime;
    }

    public String getType() {
        this.type = getAdditionalInfo().get("type").textValue();
        return type;
    }

    public Boolean getDriveThrough() {
        this.isDriveThrough = getAdditionalInfo().get("isDriveThrough").asBoolean();
        return isDriveThrough;
    }

    public Boolean getWalkIn() {
        this.isWalkIn = getAdditionalInfo().get("isWalkIn").asBoolean();
        return isWalkIn;
    }

    public boolean isOnSiteBooking() {
        this.onSiteBooking = getAdditionalInfo().get("onSiteBooking").asBoolean();
        return onSiteBooking;
    }

    public boolean isOnSiteTesting() {
        this.onSiteTesting = getAdditionalInfo().get("onSiteTesting").asBoolean();
        return onSiteTesting;
    }

    public boolean isHomeTesting() {
        this.homeTesting = getAdditionalInfo().get("homeTesting").asBoolean();
        return homeTesting;
    }

    @Override
    public String toString() {
        return name;
    }
}
