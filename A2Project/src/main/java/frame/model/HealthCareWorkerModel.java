package frame.model;

import com.fasterxml.jackson.databind.JsonNode;
import frame.controller.FormController;
import frame.view.FormView;
import user.User;
import user.Users;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class HealthCareWorkerModel {

    private String patientId;
    private String bookingId;
    private String healthcareId;

    public HealthCareWorkerModel(String patientID, String bookingID, String healthCareID) {
        this.patientId = patientID;
        this.bookingId = bookingID;
        this.healthcareId = healthCareID;
    }

    public HealthCareWorkerModel() {

    }

    public void verifyPatient() throws IOException, InterruptedException {
        Users allUsers = new Users();
        ArrayList<User> users = allUsers.getUsers();
        for (User user: users){
            if(user.getId().equals(patientId)) {
                for (JsonNode booking : user.getBookings()) {
                    if (booking.get("id").textValue().equals(bookingId)) {
                        FormView ff = new FormView();
                        ff.setName(user.getUserName());
                        ff.setHealthCareId(this.healthcareId);
                        ff.setPatient(user);
                        ff.setBooking(booking);
                        FormModel formModel = new FormModel(ff.getBooking(), ff.getPatient(), ff.getHealthCareId());
                        FormController formController = new FormController(ff, formModel);
                        ff.setVisible(true);
                        ff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JOptionPane.showMessageDialog(null, "Booking ID and Patient ID are correct!!");
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Please fill in your correct patient ID!!!");

    }
}
