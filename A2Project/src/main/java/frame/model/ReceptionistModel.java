package frame.model;

import booking.Booking;
import booking.HomeBooking;
import booking.OnSiteBooking;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import frame.controller.EditBookingController;
import frame.controller.RepOptionController;
import frame.view.EditBookingView;
import frame.view.RepOptionView;
import user.User;
import utility.API;
import utility.Verification;
import utility.adapter.ResponseAdapter;
import utility.adapter.TextAdaptee;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.net.http.HttpResponse;

public class ReceptionistModel {

    private String customerId;
    private String testingSiteId;
    private String bookingId;

    public ReceptionistModel(String bookingId, String customerId, String testingSiteId) {
        this.customerId = customerId;
        this.testingSiteId = testingSiteId;
        this.bookingId = bookingId;
    }

    public void successSubmit(String startingDate, String startingTime, String notes) throws IOException, InterruptedException {
        String bookingTime = startingDate + "T" + startingTime + "Z";
        OnSiteBooking booking = new OnSiteBooking(customerId,testingSiteId,bookingTime,notes);
        booking.setAdditionalJson();
        API api = new API("booking");
        String response = api.postBookingAPI(booking);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJSONNode = objectMapper.readTree(response);
        String smsPin = responseJSONNode.get("smsPin").asText();
        JOptionPane.showMessageDialog(null, "PIN:" + smsPin);
    }

    public void verifyPIN(String pinCode, String bookingId) throws IOException, InterruptedException {
        Verification verification= new Verification();
        verification.checkPIN(pinCode,bookingId);
    }

    public void qrCodeSubmit(String qrCode) throws IOException, InterruptedException {
        Verification verification= new Verification();
        Booking result = verification.checkQRCode(qrCode);
        if (result==null){
            return;
        }
        if (result.isHasRATKit()){
            JOptionPane.showMessageDialog(null, "Please LEAVEE!!, You have the KIT");
            return;
        }
        String Json = "{" +
                "\"bookHomeTesting\":\"" + result.getBookHomeTesting() + "\"," +
                "\"bookOnSiteTesting\":\"" + result.getBookOnSiteTesting() + "\"," +
                "\"hasRATKit\":\"" + true + "\"," +
                "\"URL\":\"" + result.getURL() + "\"," +
                "\"QRCode\":\"" + result.getQRCode() + "\"" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(Json);
        Booking booking = new HomeBooking(result, (ObjectNode) jsonNode);
//        Booking booking = new HomeBooking(result.getId(),result.getCustomer().get("id").textValue(),result.getTestingSite().get("id").textValue(),result.getStartTime(),result.getNotes(), result.getStatus(),(ObjectNode) jsonNode);
        API api = new API("booking");
        api.patchBookingAPI(booking);
    }

    public void changeBooking(JButton button, JTable bookingTable, User recep){
        if (button.getText().equals("Action")) {
            int row = bookingTable.getSelectedRow();
            int column = bookingTable.getSelectedColumn();
            TableModel model = bookingTable.getModel();
            String bookingId = model.getValueAt(row, 0).toString();
            if(model.getValueAt(row, 4).toString().equals("Delete")){
                JOptionPane.showMessageDialog(null, "This Booking has deleted");
                return;
            }
            Booking booking = (Booking) bookingTable.getValueAt(row, column);
            RepOptionView repOption = new RepOptionView();
            repOption.receivebookId(bookingId);
            repOption.receivebooking(booking);
            repOption.receiveRep(recep);
            RepOptionModel repOptionModel = new RepOptionModel();
            RepOptionController repOptionController = new RepOptionController(repOption, repOptionModel);
            repOption.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            repOption.setVisible(true);
        }
    }

    public void modifyBooking(String bookingId) throws IOException, InterruptedException {
        API api = new API("booking/"+ bookingId);
        HttpResponse<String> response = api.callGETAPI();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        ResponseAdapter responseAdapter = new ResponseAdapter(new TextAdaptee());
        String resultText = responseAdapter.convertFormat(jsonNode);
        Booking booking = objectMapper.readValue(resultText,Booking.class);
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

    public void deleteBooking(String bookingId) throws IOException, InterruptedException {
        API api = new API("booking");
        api.deleteBookingAPI(bookingId);
        JOptionPane.showMessageDialog(null,  "Booking has been deleted!");
    }
}
