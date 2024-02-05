package covidTest;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Class representing the Covid Test.

 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see CovidResult
 * @see TestType
 */
public class CovidTest {

    /**
     * Test Type
     */
    private String type;
    /**
     * Patient ID
     */
    private String patientId;
    private String administererId;
    private String bookingId;
    private Enum<CovidResult> result;
    private String status;
    private String notes;

    /**
     * Constructor for creating the covid test class
     *
     * @param testType          Test Type
     * @param patientId         Patient ID
     * @param administererId    Administerer ID
     * @param bookingId         Booking ID
     * @param notes             Notes
     */
    public CovidTest(TestType testType, String patientId, String administererId, String bookingId, String notes) {
        this.type = testType.toString();
        this.patientId = patientId;
        this.administererId = administererId;
        this.bookingId = bookingId;
        this.result = testType.getResult();
        this.status = "CREATED";
        this.notes = notes;
    }

    /**
     * Method for creating the Json string for post this covid test object
     *
     * @return String Covid Test
     * @throws JsonProcessingException
     */
    public String stringify() throws JsonProcessingException {
        return "{" +
                "\"type\":\"" + type + "\"," +
                "\"patientId\":\"" + patientId + "\"," +
                "\"administererId\":\"" + administererId + "\"," +
                "\"bookingId\":\"" + bookingId + "\"," +
                "\"result\":\"" + result + "\"," +
                "\"status\":\"" + status + "\"," +
                "\"notes\":\"" + notes + "\"" +
                "}";
    }

}
