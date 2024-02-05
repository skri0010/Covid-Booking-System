package frame.model;

import booking.HomeBooking;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import frame.controller.QRCodeController;
import frame.view.QRCodeView;
import testingSite.TestingSite;
import utility.API;
import utility.StringGenerator;

import javax.swing.*;
import java.io.IOException;

public class HomeBookingModel {

    private String bookingDate;
    private String bookTime;
    private String customerId;
    private boolean yesCheckBox;
    private boolean noCheckBox;
    private TestingSite testingSite;

    public HomeBookingModel(TestingSite testingSite,  String bookingDate, String bookTime, String customerId) {
        this.testingSite = testingSite;
        this.bookingDate = bookingDate;
        this.bookTime = bookTime;
        this.customerId = customerId;
    }

    public HomeBookingModel() {
    }

    public void submitBooking(boolean yesCheckBox, boolean noCheckBox) throws IOException, InterruptedException {
        StringGenerator randomStr = new StringGenerator();

        String QRCode = randomStr.createString();
        String Url = "https://test.com/" + randomStr.createString();
        boolean hasRATKit = false;

        if ((yesCheckBox && noCheckBox) || (!yesCheckBox && !noCheckBox) ){
            JOptionPane.showMessageDialog(null,"Select one option please!");
        }
        else if (noCheckBox){
            hasRATKit = false;
            confirmBooking(QRCode,Url,hasRATKit);
        }
        else if (yesCheckBox){
            hasRATKit = true;
            confirmBooking(QRCode,Url,hasRATKit);
        }
    }

    public void confirmBooking(String QRCode, String Url, boolean hasRATKit) throws IOException, InterruptedException {
        String bookingTime = bookingDate + "T" + bookTime + "Z";
        HomeBooking booking = new HomeBooking(customerId, testingSite.getId(),bookingTime,"None",QRCode, Url, hasRATKit);
        booking.setAdditionalJson();
        API api = new API("booking");
        String response = api.postBookingAPI(booking);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJSONNode = objectMapper.readTree(response);
        String smsPin = responseJSONNode.get("smsPin").asText();
        QRCodeView qrCodeFrame = new QRCodeView();
        qrCodeFrame.setBoxText(QRCode, Url);
        QRCodeModel qrCodeModel = new QRCodeModel(qrCodeFrame.getQRBox(), qrCodeFrame.getUrlBox());
        QRCodeController qrCodeController = new QRCodeController(qrCodeFrame, qrCodeModel);
        qrCodeController.setQRandUrl();
        qrCodeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qrCodeFrame.setVisible(true);
        JOptionPane.showMessageDialog(null, "QR CODE: " + QRCode  + "\nURL: " + Url + "\nPIN:" + smsPin);

    }
}
