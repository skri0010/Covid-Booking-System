package user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Class represent the User
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see Role
 * @see UserRole
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("userName")
    private String userName;

    private Role role;

    @JsonProperty("id")
    private String id;

    @JsonProperty("givenName")
    private String givenName;

    @JsonProperty("familyName")
    private String familyName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("isCustomer")
    private Boolean isCustomer;

    @JsonProperty("isReceptionist")
    private Boolean isReceptionist;

    @JsonProperty("isHealthcareWorker")
    private Boolean isHealthcareWorker;

    @JsonProperty("additionalInfo")
    private ObjectNode additionalInfo;

    @JsonProperty("bookings")
    private JsonNode bookings;

    @JsonProperty("testsTaken")
    private ObjectNode testsTaken;

    @JsonProperty("testsAdministered")
    private ObjectNode testsAdministered;
    private String workingSiteId;
    private String messages;

    /**
     * Constructor of the User class
     */
    public User() {
        super();
        this.role = new Role();
    }

//    Patch
    public User(User user, ObjectNode additionalInfo){
        this.id = user.getId();
        this.givenName = user.getGivenName();
        this.familyName = user.getFamilyName();
        this.userName = user.getUserName();
        this.isCustomer = user.getIsCustomer();
        this.isReceptionist = user.getIsReceptionist();
        this.isHealthcareWorker = user.getIsHealthcareWorker();
        this.additionalInfo = additionalInfo;
    }

//    //Post
//    public User(String givenName, String familyName, String userName, String phoneNumber, Boolean isCustomer, Boolean isReceptionist, Boolean isHealthcareWorker, ObjectNode additionalInfo){
//        this.givenName = givenName;
//        this.familyName = familyName;
//        this.userName = userName;
//        this.phoneNumber = phoneNumber;
//        this.isCustomer = isCustomer;
//        this.isReceptionist = isReceptionist;
//        this.isHealthcareWorker = isHealthcareWorker;
//        this.additionalInfo = additionalInfo;
//    }

    public String patchStringify(){
        return "{" +
                "\"givenName\":\"" + this.givenName + "\"," +
                "\"familyName\":\"" + this.familyName + "\"," +
                "\"password\":\"" + this.userName + "\"," +
                "\"isCustomer\":" + this.isCustomer + "," +
                "\"isReceptionist\":" + this.isReceptionist + "," +
                "\"isHealthcareWorker\":" + this.isHealthcareWorker + "," +
                "\"additionalInfo\":" + additionalInfo +
                "}";
    }

    public String stringify() throws JsonProcessingException {
        return "{" +
                "\"givenName\":\"" + this.givenName + "\"," +
                "\"familyName\":\"" + this.familyName + "\"," +
                "\"userName\":\"" + this.userName + "\"," +
                "\"password\":\"" + this.userName + "\"," +
                "\"phoneNumber\":\"" + this.phoneNumber + "\"," +
                "\"isCustomer\":" + this.isCustomer + "," +
                "\"isReceptionist\":" + this.isReceptionist + "," +
                "\"isHealthcareWorker\":\"" + this.isHealthcareWorker + "," +
                "\"additionalInfo\":" + additionalInfo +
                "}";
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public JsonNode getBookings() {
        return bookings;
    }

    public void setBookings(JsonNode bookings) {
        this.bookings = bookings;
    }

    public ObjectNode getTestsTaken() {
        return testsTaken;
    }

    public void setTestsTaken(ObjectNode testsTaken) {
        this.testsTaken = testsTaken;
    }

    public ObjectNode getTestsAdministered() {
        return testsAdministered;
    }

    public void setTestsAdministered(ObjectNode testsAdministered) {
        this.testsAdministered = testsAdministered;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ObjectNode getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(ObjectNode additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getWorkingSiteId() {
        this.workingSiteId = getAdditionalInfo().get("workingTestingSiteId").textValue();
        return workingSiteId;
    }

    public String getMessages() {
        this.messages = getAdditionalInfo().get("messages").textValue();
        return messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public Boolean getIsReceptionist() {
        return isReceptionist;
    }

    public void setIsReceptionist(Boolean isReceptionist) {
        this.isReceptionist = isReceptionist;
    }

    public Boolean getIsHealthcareWorker() {
        return isHealthcareWorker;
    }

    public void setIsHealthcareWorker(Boolean isHealthcareWorker) {
        this.isHealthcareWorker = isHealthcareWorker;
    }
}
