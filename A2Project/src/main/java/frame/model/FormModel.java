package frame.model;

import com.fasterxml.jackson.databind.JsonNode;
import covidTest.Form;
import user.User;

import java.io.IOException;

public class FormModel {

    private JsonNode booking;
    private User patient;
    private String healthcareId;

    public FormModel(JsonNode booking, User patient, String healthcareId) {
        this.booking = booking;
        this.patient = patient;
        this.healthcareId = healthcareId;
    }

    public void doneForm(boolean cb1, boolean cb2, boolean cb3, boolean cb4, boolean cb5, boolean cb6) throws IOException, InterruptedException {
        int yesNumber = 0;
        if(cb1) {
            yesNumber += 1;
        }
        if(cb2) {
            yesNumber += 1;
        }
        if(cb3) {
            yesNumber += 1;
        }
        if(cb4) {
            yesNumber += 1;
        }
        if(cb5) {
            yesNumber += 1;
        }
        if(cb6) {
            yesNumber += 1;
        }
        Form form = new Form();
        form.createdTestType(yesNumber, this.patient, this.healthcareId, this.booking);

    }
}
