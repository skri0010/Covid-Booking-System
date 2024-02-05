package frame.model;

import booking.Booking;
import booking.BookingMemento;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import frame.controller.RestoreController;
import frame.view.RestoreView;
import testingSite.TestingSite;
import utility.API;
import utility.viewMessage.RunMessage;

import javax.swing.*;
import java.io.IOException;

public class EditBookingModel {

    private Booking booking;
    private JComboBox<TestingSite> testingSiteOpt;
    private String date;
    private String time;

    public EditBookingModel(Booking booking, JComboBox<TestingSite> testingSiteOpt, String time, String date) {
        this.booking = booking;
        this.testingSiteOpt = testingSiteOpt;
        this.date = date;
        this.time = time;
    }

    public EditBookingModel() {
    }

    public void confirmEdit() throws IOException, InterruptedException {
        BookingMemento memento = booking.getMemento();
        if (time.equals("") && date.equals("") && testingSiteOpt.getSelectedItem()==null) {
            JOptionPane.showMessageDialog(null,  "Change at least one item!");
            return;
        }
        else if (time.equals("") || date.equals("")){
            JOptionPane.showMessageDialog(null,  "Time and Date Cant be empty!");
            return;
        }
        else if (testingSiteOpt == null){
            String datetime = date + "T" + time+ ":00Z";
            RunMessage runMessage = new RunMessage();
            runMessage.notifyRecep(booking.getId(), booking.getTestingSite().get("id").textValue(), booking.getTestingSite().get("id").textValue(), "Modify");
            booking.setStartTime(datetime);
        }
        else if (time.equals("") && date.equals("")){
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode testingSite = objectMapper.convertValue(testingSiteOpt.getSelectedItem(),JsonNode.class);
            RunMessage runMessage = new RunMessage();
            runMessage.notifyRecep(booking.getId(), booking.getTestingSite().get("id").textValue(), testingSite.get("id").textValue(), "Modify");
            booking.setTestingSite(testingSite);
        }
        else{
            String datetime = date + "T" + time + ":00Z";
            booking.setStartTime(datetime);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode testingSite = objectMapper.convertValue(testingSiteOpt.getSelectedItem(),JsonNode.class);
            RunMessage runMessage = new RunMessage();
            runMessage.notifyRecep(booking.getId(), booking.getTestingSite().get("id").textValue(), testingSite.get("id").textValue(), "Modify");
            booking.setTestingSite(testingSite);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode newBooking = objectMapper.readTree(memento.toString());
        if (booking.getAdditionalInfo().get("bookingMemento") != null){

            if (booking.getAdditionalInfo().get("bookingMemento").get("bookingThree") != null){
                ((ObjectNode) booking.getAdditionalInfo().get("bookingMemento")).set("bookingOne",newBooking);
            }
            else if (booking.getAdditionalInfo().get("bookingMemento").get("bookingTwo") == null){
                ((ObjectNode) booking.getAdditionalInfo().get("bookingMemento")).set("bookingTwo",newBooking);
            }
            else if (booking.getAdditionalInfo().get("bookingMemento").get("bookingThree") == null){
                ((ObjectNode) booking.getAdditionalInfo().get("bookingMemento")).set("bookingThree",newBooking);
            }
        }
        else{
            String mementoString = "{" +
                    "\"bookingOne\":" + memento.toString() + "" +
                    "}";
            System.out.println(mementoString);
            JsonNode mementoJson = objectMapper.readTree(mementoString);
            ((ObjectNode) booking.getAdditionalInfo()).set("bookingMemento",mementoJson);
        }
        booking.setTestingSiteId(booking.getTestingSite().get("id").asText());
        booking.setStatus("MODIFIED");
        API api = new API("booking");
        api.patchBookingAPI(booking);
        JOptionPane.showMessageDialog(null,  "Booking has been modified!");
    }

    public void cancelEdit() throws IOException, InterruptedException {
        RunMessage runMessage = new RunMessage();
        runMessage.notifyRecep(booking.getId(), booking.getTestingSite().get("id").textValue(), booking.getTestingSite().get("id").textValue(), "Cancel");
        booking.setStatus("CANCELLED");
        API api = new API("booking");
        api.patchBookingAPI(booking);
        JOptionPane.showMessageDialog(null,  "Booking has been cancelled!");
    }

    public void restore() throws IOException, InterruptedException {
        RestoreView restoreFrame = new RestoreView(booking);
        restoreFrame.showBookings();
        RestoreModel restoreModel = new RestoreModel();
        RestoreController restoreController = new RestoreController(restoreFrame, restoreModel);
        restoreFrame.setVisible(true);
        restoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
