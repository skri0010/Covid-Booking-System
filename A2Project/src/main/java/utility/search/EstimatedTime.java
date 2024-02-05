package utility.search;

import testingSite.TestingSite;

/**
 * Class represent the EstimatedTime
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see SearchFacade
 * @see SearchCentre
 */
public class EstimatedTime {
    /**
     * Waiting Time
     */
    private int waitingTime;

    /**
     * Method for calculate waiting time of testing site
     *
     * @param testingSite
     * @return
     */
    public String calculateWaitingTime(TestingSite testingSite) {
        if (!testingSite.getBookings().equals("[]")) {
            this.waitingTime = testingSite.getBookings().size();
            return waitingTime + " hour";
        } else {
            return "Not Available";
        }
    }

    public int getWaitingTime() {
        return waitingTime;
    }
}
