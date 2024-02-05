package frame.model;

import booking.OnSiteBooking;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import testingSite.TestingSite;
import user.User;
import utility.API;

import javax.swing.*;
import java.io.IOException;

public class OnSiteBookingModel {

    private User user;
    private TestingSite testingSite;
    private String note;
    private String startingTime;
    private String startingDate;

    public OnSiteBookingModel(User user,TestingSite testingSite, String note) {
        this.user = user;
        this.testingSite = testingSite;
        this.note = note;
    }

    public void submitAction(String startingTime, String startingDate) throws IOException, InterruptedException {
        String bookingTime = startingDate+ "T" + startingTime + "Z";
        String customerId = user.getId();
        String testingId = testingSite.getId();
        OnSiteBooking booking = new OnSiteBooking(customerId,testingId,bookingTime,note);
        booking.setAdditionalJson();
        API api = new API("booking");
        String response = api.postBookingAPI(booking);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJSONNode = objectMapper.readTree(response);
        String smsPin = responseJSONNode.get("smsPin").asText();
        JOptionPane.showMessageDialog(null, "PIN:" + smsPin);
    }
}
