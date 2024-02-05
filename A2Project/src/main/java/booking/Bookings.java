package booking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import utility.API;
import utility.adapter.ResponseAdapter;
import utility.adapter.TextAdaptee;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class Bookings {

    private ResponseAdapter responseAdapter;

    private ArrayList<Booking> bookings;

    public Bookings() {
        bookings = new ArrayList<>();
    }

    public ArrayList<Booking> getBookings() throws IOException, InterruptedException {
        this.loadBookings();
        return bookings;
    }

    public void  loadBookings() throws IOException, InterruptedException {
        API bookingAPI = new API("booking");
        HttpResponse<String> response = bookingAPI.callGETAPI();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        this.responseAdapter= new ResponseAdapter(new TextAdaptee());
        String resultText = this.responseAdapter.convertFormat(jsonNode);
        Booking[] bk = objectMapper.readValue(resultText, Booking[].class);
        bookings.clear();
        bookings.addAll(Arrays.asList(bk));
    }
}
