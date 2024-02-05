package booking;


public class BookingMementoInternal implements  BookingMemento{

    /**
     * Testing Site ID
     */
    private String testingSiteId;
    /**
     * Booking Start Time
     */
    private String startTime;



    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTestingSiteId() {
        return testingSiteId;
    }

    public void setTestingSiteId(String testingSiteId) {
        this.testingSiteId = testingSiteId;
    }

    public String toString(){
        return "{" +
                "\"testingSiteId\":\"" + testingSiteId + "\"," +
                "\"startTime\":\"" + startTime + "\"" +
                "}";
    }
}
