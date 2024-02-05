package testingSite;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import utility.API;
import utility.adapter.ResponseAdapter;
import utility.adapter.TextAdaptee;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class representing the TestingSiteSingleton
 * Reference Singleton: <a href="https://github.com/aaleti/java-design-patterns/tree/master/singleton">...</a>
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see TestingSite
 * @see TestingSiteType
 *
 */
public class TestingSiteSingleton {

    /**
     * ArrayList for saving the testingSites
     */
    private static ArrayList<TestingSite> testingSites;

    /**
     * The instance of the testingSite Singleton
     */
    private static TestingSiteSingleton instance;

    /**
     * The adapter for the reponse
     */
    private ResponseAdapter responseAdapter;

    /**
     * Class represent the singleton of the TestingSiteSingleton
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public TestingSiteSingleton() throws IOException, InterruptedException {
        testingSites = new ArrayList<>();
    }

    /**
     * Get the instance of the TestingSites array
     *
     * @return Object of TestingSiteSingleton
     * @throws IOException
     * @throws InterruptedException
     */
    public static TestingSiteSingleton getInstance() throws IOException, InterruptedException {
        if(instance == null){
            instance = new TestingSiteSingleton();
        }
        return instance;
    }

    public ArrayList<TestingSite> getTestingSites() {
        return testingSites;
    }

    /**
     * This method run the api call for retrieve the testing sites from the server
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void loadTestingSites() throws IOException, InterruptedException {
        API tsApi = new API("testing-site?fields=bookings");
        HttpResponse<String> response = tsApi.callGETAPI();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        this.responseAdapter= new ResponseAdapter(new TextAdaptee());
        String resultText = this.responseAdapter.convertFormat(jsonNode);
        TestingSite[] testings = objectMapper.readValue(resultText, TestingSite[].class);
        testingSites.clear();
        testingSites.addAll(Arrays.asList(testings));
        this.setTestingSitesType(testingSites);
    }

    /**
     * This method will set the enum type for each Testing Sites that are retrieved
     *
     * @param testingSites Array of the Testing Sites
     */
    public void setTestingSitesType(ArrayList<TestingSite> testingSites) {
        for (TestingSite ts: testingSites){
            String tsType = ts.getType();
            switch (tsType) {
                case "Clinic" -> ts.getTestingSiteType().setTSType(TestingSiteTypeEnum.CLINIC);
                case "Hospital" -> ts.getTestingSiteType().setTSType(TestingSiteTypeEnum.HOSPITAL);
                case "GPs" -> ts.getTestingSiteType().setTSType(TestingSiteTypeEnum.GPs);
            }
        }
    }
}
