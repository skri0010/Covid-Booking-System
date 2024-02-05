package frame.model;

import booking.Booking;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import frame.controller.BookingController;
import frame.controller.EditBookingController;
import frame.view.BookingView;
import frame.view.EditBookingView;
import testingSite.TestingSite;
import user.User;
import utility.API;
import utility.adapter.ResponseAdapter;
import utility.adapter.TextAdaptee;

import javax.swing.*;
import java.io.IOException;
import java.net.http.HttpResponse;

public class CustomerModel {

    private Booking booking;
    private User user;
    private TestingSite testingSite;

    public CustomerModel(Booking booking,User user,TestingSite testingSite){
        this.booking = booking;
        this.user = user;
        this.testingSite = testingSite;
    }
    public CustomerModel(){

    }
    public void makeBooking(){
        BookingModel bookingModel = new BookingModel();
        BookingView bookingFrame = new BookingView(testingSite, this.user);
        BookingController bookingController = new BookingController(bookingFrame, bookingModel);

        bookingFrame.setVisible(true);
        bookingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void editBooking() throws IOException, InterruptedException {
            if (booking.getStatus().equals("CANCELLED") || booking.getStatus().equals("COMPLETED")){
                JOptionPane.showMessageDialog(null,  "Booking Cant be Modified!");
                return;
            }
            booking.setCustomerId(user.getId());
            EditBookingView eb = new EditBookingView(booking);
            eb.displayTestingSite();
            EditBookingModel editBookingModel = new EditBookingModel();
            EditBookingController editBookingController = new EditBookingController(eb, editBookingModel);
            eb.setVisible(true);
            eb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void searchBooking(String bookingId) throws IOException, InterruptedException {
        API api = new API("booking/" + bookingId);
        HttpResponse<String> response = api.callGETAPI();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        ResponseAdapter responseAdapter = new ResponseAdapter(new TextAdaptee());
        String resultText = responseAdapter.convertFormat(jsonNode);
        Booking booking = objectMapper.readValue(resultText, Booking.class);
        if (booking.getTestingSite() == null){
            JOptionPane.showMessageDialog(null,  "Enter Valid Booking ID!");
            return;
        }
        if (booking.getStatus().equals("CANCELLED") || booking.getStatus().equals("COMPLETED")){
            JOptionPane.showMessageDialog(null,  "Booking Cant be Modified!");
            return;
        }
        EditBookingView eb = new EditBookingView(booking);
        eb.displayTestingSite();
        EditBookingModel editBookingModel = new EditBookingModel();
        EditBookingController editBookingController = new EditBookingController(eb, editBookingModel);
        eb.setVisible(true);
        eb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
