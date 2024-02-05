package covidTest;

import com.fasterxml.jackson.databind.JsonNode;
import user.User;
import utility.API;

import javax.swing.*;
import java.io.IOException;

/**
 * Class represent the Form
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see PCR
 * @see RAT
 * @see CovidTest
 */
public class Form {

    private TestType testType;
    private CovidTest covidTest;

    /**
     * Constructor of the Form class
     */
    public Form() {
    }

    /**
     * Method for create the specific type of test kit
     *
     * @param yesNumber     Number of yes clicked for the form
     * @param patient       Patient Object
     * @param healthCareId  HealthcareWorker ID
     * @param booking       Booking Object
     * @throws IOException
     * @throws InterruptedException
     */
    public void createdTestType(int yesNumber, User patient, String healthCareId, JsonNode booking) throws IOException, InterruptedException {
        API api = new API("covid-test");
        if(yesNumber >=3){
            this.testType = new PCR(CovidResult.PENDING);
            this.covidTest = new CovidTest(testType,patient.getId(),healthCareId,booking.get("id").textValue(),"None");
            api.postCovidTestAPI(this.covidTest);
            JOptionPane.showMessageDialog(null, "Test Type: " + this.testType.toString() + " Test");
        }else{
            this.testType = new RAT(CovidResult.PENDING);
            this.covidTest = new CovidTest(this.testType,patient.getId(),healthCareId,booking.get("id").textValue(),"None");
            api.postCovidTestAPI(this.covidTest);
            JOptionPane.showMessageDialog(null, "Test Type: " + this.testType.toString() + " Test");
        }
    }
}
