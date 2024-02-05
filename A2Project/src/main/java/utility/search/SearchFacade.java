package utility.search;

import testingSite.TestingSiteSingleton;
import testingSite.TestingSite;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Class represent the SearchFacade
 * Reference Facade: <a href="https://github.com/aaleti/java-design-patterns/tree/master/facade">...</a>
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see SearchCentre
 * @see EstimatedTime
 */
public class SearchFacade {
    private SearchCentre searchCentre;
    private EstimatedTime waitingTime;
    private CheckStatus checkStatus;

    /**
     * constructor for creating the SearchFacade
     */
    public SearchFacade() {
        this.waitingTime = new EstimatedTime();
        this.checkStatus = new CheckStatus();
        this.searchCentre = new SearchCentre();
    }

    /**
     * Method for viewing the Testing Sites
     *
     * @param model     frame
     * @param suburb    Suburb search
     * @param type      type search
     * @param way       way search
     * @param buttonClick   button click on
     * @throws IOException
     * @throws InterruptedException
     * @throws ParseException
     */
    public void viewTestingSite(DefaultTableModel model, String suburb, String type, String way, String buttonClick) throws IOException, InterruptedException, ParseException {
        TestingSiteSingleton testingSiteSingleton = TestingSiteSingleton.getInstance();

        ArrayList<TestingSite> searchResult = null;
        if(buttonClick.equals("") || buttonClick.equals("Refresh")){
            testingSiteSingleton.loadTestingSites();
            searchResult = testingSiteSingleton.getTestingSites();
        }else if (buttonClick.equals("Search")) {
            if (testingSiteSingleton.getTestingSites().size() == 0) {
                testingSiteSingleton.loadTestingSites();
            }
            searchResult = this.searchCentre.filterTestingSites(testingSiteSingleton.getTestingSites(), suburb, type, way);
        }

        Object[] rowData = new Object[7];

        assert searchResult != null;
        for (TestingSite testingSiteObject : searchResult) {
            rowData[0] = testingSiteObject.getName();
            rowData[1] = testingSiteObject.getOpeningTime();
            rowData[2] = testingSiteObject.getCloseTime();
            rowData[3] = this.waitingTime.calculateWaitingTime(testingSiteObject);
            rowData[4] = this.checkStatus.getOnSiteStatus(testingSiteObject);
            rowData[5] = this.checkStatus.checkStatus(testingSiteObject.getOpeningTime(), testingSiteObject.getCloseTime());
            rowData[6] = testingSiteObject;
            model.addRow(rowData);
        }
    }


}
