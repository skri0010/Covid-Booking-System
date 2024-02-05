package utility;

import booking.Booking;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import utility.adapter.ResponseAdapter;
import utility.adapter.TextAdaptee;

import javax.swing.*;
import java.io.IOException;
import java.net.http.HttpResponse;

/**
 * Class represent the Verification
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 */
public class Verification {

    private ResponseAdapter responseAdapter;

    /**
     * Constructor for Verification
     */
    public Verification() {
        this.responseAdapter = new ResponseAdapter(new TextAdaptee());
    }

    /**
     * Check the smsPIN code
     *
     * @param pinCode PIN code
     * @throws IOException
     * @throws InterruptedException
     */
    public void checkPIN(String pinCode,String bookingId) throws IOException, InterruptedException {
        Booking[] bookings = getBookings();
        for (Booking bk: bookings) {
            if(bk.getSmsPin().equals(pinCode) && bk.getId().equals(bookingId)) {
                JOptionPane.showMessageDialog(null, "Your Booking Status: " + bk.getStatus());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Wrong SMS PIN Code or Booking ID!");
    }
    


    /**
     * Check the QR Code
     *
     * @param qrCode qrCode
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public Booking checkQRCode(String qrCode) throws IOException, InterruptedException {
        Booking[] bookings = getBookings();
        for (Booking bk: bookings) {
            if(bk.getQRCode().equals(qrCode)) {
                JOptionPane.showMessageDialog(null, "QR Code is scanned and here is your RAT Kit");
                System.out.println(bk.getId());
                return bk;
            }
        }
        JOptionPane.showMessageDialog(null, "Wrong QR Code Code");
        return null;
    }

    private Booking[] getBookings() throws IOException, InterruptedException {
        API bookingApi = new API("booking");
        HttpResponse<String> response = bookingApi.callGETAPI();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        String resultText = this.responseAdapter.convertFormat(jsonNode);
        Booking[] bookings = objectMapper.readValue(resultText, Booking[].class);
        return bookings;
    }


}
