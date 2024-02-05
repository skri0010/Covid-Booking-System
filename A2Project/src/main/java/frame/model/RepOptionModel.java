package frame.model;

import booking.Booking;
import frame.controller.EditBookingController;
import frame.view.EditBookingView;
import user.User;
import utility.API;
import utility.viewMessage.RunMessage;

import javax.swing.*;
import java.io.IOException;

public class RepOptionModel {

    private Booking booking;
    private String bookingId;
    private User recep;

    public RepOptionModel(Booking booking, User recep, String bookingId) {
        this.booking = booking;
        this.bookingId = bookingId;
        this.recep = recep;
    }

    public RepOptionModel() {
    }

    public void modifyCancelAction() throws IOException, InterruptedException {
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

    public void deleteAction() throws IOException, InterruptedException {
        if (!booking.getStatus().equals("COMPLETED")){
            API bookingAPI = new API("booking");
            bookingAPI.deleteBookingAPI(bookingId);
            JOptionPane.showMessageDialog(null,  "Booking has been deleted!");
            RunMessage runMessage = new RunMessage();
            runMessage.notifyRecep(bookingId, this.recep.getAdditionalInfo().get("workingTestingSiteId").textValue(), this.recep.getAdditionalInfo().get("workingTestingSiteId").textValue(), "Delete");
        }else{
            JOptionPane.showMessageDialog(null,  "Booking has completed, why delete!!!");
        }
    }


}
