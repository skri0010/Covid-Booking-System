package utility.search;

import testingSite.TestingSite;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class represent the SearchCentre
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see SearchFacade
 * @see EstimatedTime
 */
public class SearchCentre {

    /**
     * Constructor for the SearchCentre
     *
     */
    public SearchCentre() {
    }

    /**
     * Method for filter the testing sites after the user use the search feature
     *
     * @param apiTestingSites   testing sites
     * @param suburb            suburb search
     * @param type              type search
     * @param way               type way
     * @return                  Testing Sites
     * @throws IOException
     * @throws InterruptedException
     */
    public ArrayList<TestingSite> filterTestingSites(ArrayList<TestingSite> apiTestingSites, String suburb, String type, String way) throws IOException, InterruptedException {
        ArrayList<TestingSite> filteredTestingSites = new ArrayList<>();
        for (TestingSite testingSiteObject : apiTestingSites) {
            boolean searchDrive = false;
            boolean searchWalk = false;
            String tsSuburb = testingSiteObject.getSuburbName();
            String tsType = testingSiteObject.getType();
            boolean tsDriveThrough = testingSiteObject.getDriveThrough();
            boolean tsWalkIn= testingSiteObject.getWalkIn();

            if (way.equals("Drive-Through") && tsDriveThrough){
                searchDrive = true;
            }
            if (way.equals("Walk In") && tsWalkIn) {
                searchWalk = true;
            }
            if (tsSuburb.equals(suburb) || tsType.equals(type) || searchDrive || searchWalk){
                filteredTestingSites.add(testingSiteObject);
            }
        }
        if (suburb.equals("") && type.equals("None") && way.equals("None")){
            return  apiTestingSites;
        }
        return filteredTestingSites;
    }


}
