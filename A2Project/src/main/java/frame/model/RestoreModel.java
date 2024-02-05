package frame.model;

import booking.Booking;
import booking.BookingMemento;
import booking.BookingMementoInternal;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import testingSite.TestingSite;
import utility.API;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestoreModel {

    private Booking booking;
    private JComboBox<String> timeBox;
    private JComboBox<TestingSite> venueBox;

    public RestoreModel(Booking booking, JComboBox<String> timeBox, JComboBox<TestingSite> venueBox) {
        this.booking = booking;
        this.timeBox = timeBox;
        this.venueBox = venueBox;
    }

    public RestoreModel() {
    }

    public void confirmRestore() throws ParseException, IOException, InterruptedException {
        BookingMementoInternal bookingMemento = new BookingMementoInternal();
        BookingMemento oldBooking = booking.getMemento();

        ObjectMapper objectMapper = new ObjectMapper();
        if (venueBox.getSelectedItem() == null && timeBox == null){
            JOptionPane.showMessageDialog(null,  "Select at least one item to confirm");
            return;
        }
        else if (venueBox.getSelectedItem() == null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date selectedDate = dateFormat.parse(timeBox.getSelectedItem().toString());
            Date currentDate = dateFormat.parse(booking.getStartTime());
            if (selectedDate.compareTo(currentDate) > 0){
                bookingMemento.setStartTime(timeBox.getSelectedItem().toString());
                bookingMemento.setTestingSiteId(booking.getTestingSite().get("id").asText());
            }
            else{
                JOptionPane.showMessageDialog(null,  "Selected date must be in future!");
                return;
            }
        }
        else if (timeBox.getSelectedItem() == null){
            JsonNode testingSite = objectMapper.convertValue(venueBox.getSelectedItem(),JsonNode.class);
            bookingMemento.setTestingSiteId(testingSite.get("id").asText());
        }
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date selectedDate = dateFormat.parse(timeBox.getSelectedItem().toString());
            System.out.println(selectedDate);
            Date currentDate = dateFormat.parse(booking.getStartTime());
            if (selectedDate.compareTo(currentDate) > 0){
                bookingMemento.setStartTime(timeBox.getSelectedItem().toString());
                bookingMemento.setTestingSiteId(booking.getTestingSite().get("id").asText());
            }
            else{
                JOptionPane.showMessageDialog(null,  "Selected date must be in future!");
                return;
            }
            JsonNode testingSite = objectMapper.convertValue(venueBox.getSelectedItem(),JsonNode.class);
            bookingMemento.setTestingSiteId(testingSite.get("id").asText());
        }
        booking.setMemento(bookingMemento);

        JsonNode oldBookingJson = objectMapper.readTree(oldBooking.toString());
        if (booking.getAdditionalInfo().get("bookingMemento").get("bookingThree") != null){
            ((ObjectNode) booking.getAdditionalInfo().get("bookingMemento")).set("bookingOne",oldBookingJson);
        }
        else if (booking.getAdditionalInfo().get("bookingMemento").get("bookingTwo") == null){
            ((ObjectNode) booking.getAdditionalInfo().get("bookingMemento")).set("bookingTwo",oldBookingJson);
        }
        else if (booking.getAdditionalInfo().get("bookingMemento").get("bookingThree") == null){
            ((ObjectNode) booking.getAdditionalInfo().get("bookingMemento")).set("bookingThree",oldBookingJson);
        }
        API api = new API("booking");
        api.patchBookingAPI(booking);
        JOptionPane.showMessageDialog(null,  "Booking has been restored!!!");



    }
}
