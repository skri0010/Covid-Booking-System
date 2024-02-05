package utility.search;

import testingSite.TestingSite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Class represent the CheckStatus
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see SearchFacade
 * @see SearchCentre
 */
public class CheckStatus {

    /**
     * Method for checking the open and close of the Testing SIte
     *
     * @param openTime  Opening Time
     * @param closeTime Close Time
     * @return String
     * @throws ParseException
     */
    public String checkStatus(String openTime, String closeTime) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        Date open = parser.parse(openTime);
        Date close = parser.parse(closeTime);

        LocalTime time = LocalTime.now();
        String t = time.format(DateTimeFormatter.ofPattern("HH:mm"));
        Date userDate = parser.parse(t);
        if (userDate.after(open) && userDate.before(close)) {
            return "OPEN";
        }else{
            return "CLOSE";
        }
    }

    /**
     * Method for get the status of the Testing Site
     *
     * @param ts Testing Site
     * @return String of status
     */
    public String getOnSiteStatus(TestingSite ts) {
        String result = "";
        if (ts.isOnSiteBooking() && ts.isOnSiteTesting()){
            result += "Provide On-Site Booking and On-site Testing";
            return result;
        }
        if (ts.isOnSiteBooking()){
            result += "Provide On-Site Booking";
            return result;
        }
        if (ts.isOnSiteTesting()){
            result += "Provide On-Site Testing";
            return result;
        }
        return "No Available";
    }
}
