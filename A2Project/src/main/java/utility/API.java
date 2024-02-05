package utility;

import booking.Booking;
import covidTest.CovidTest;
import user.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Class represent the API
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 */
public class API {

    private final String myApiKey = "qrF6pBC9Hpmd8trBmr8rmQmqrj86RD";
    private static final String rootUrl = "https://fit3077.com/api/v2";
    private final String request;

    public API(String request) throws IOException {

//        this.myApiKey = Files.readString(Path.of("ApiKey.txt"));
        this.request = request;

    }

    /**
     * Get API
     *
     * @return String
     * @throws IOException
     * @throws InterruptedException
     */
    public HttpResponse<String> callGETAPI() throws IOException, InterruptedException {
        String usersUrl = rootUrl + "/" + this.request;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(usersUrl))
                .setHeader("Authorization", myApiKey)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    /**
     * Post Booking API
     *
     * @param booking Booking
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String postBookingAPI(Booking booking) throws IOException, InterruptedException {
        HttpClient client;
        String url = rootUrl + "/" + this.request;
        HttpRequest request;
        HttpResponse<String> response;
        String jsonString = booking.stringify();
        // Note the POST() method being used here, and the request body is supplied to it.
        // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(URI.create(url))
                .setHeader("Authorization", myApiKey)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    /**
     * Post Covid Test API
     *
     * @param covidTest CovidTest
     * @throws IOException
     * @throws InterruptedException
     */
    public void postCovidTestAPI(CovidTest covidTest) throws IOException, InterruptedException {
        HttpClient client;
        String url = rootUrl + "/" + this.request;
        HttpRequest request;
        HttpResponse<String> response;
        String jsonString = covidTest.stringify();
        System.out.println(jsonString);
        // Note the POST() method being used here, and the request body is supplied to it.
        // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(URI.create(url))
                .setHeader("Authorization", myApiKey)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public void postUserAPI(User user) throws IOException, InterruptedException {
        HttpClient client;
        String url = rootUrl + "/" + this.request;
        HttpRequest request;
        HttpResponse<String> response;
        String jsonString = user.stringify();

        System.out.println(jsonString);
        // Note the POST() method being used here, and the request body is supplied to it.
        // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(URI.create(url))
                .setHeader("Authorization", myApiKey)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    /**
     * Patch Booking API
     *
     * @param booking Booking
     * @throws IOException
     * @throws InterruptedException
     */
    public void patchBookingAPI(Booking booking) throws IOException, InterruptedException {
        HttpClient client;
        String url = rootUrl + "/" + this.request + "/" + booking.getId();
        System.out.println(booking.getId());
        HttpRequest request;
        HttpResponse<String> response;
        String jsonString = booking.patchStringify();
        // Note the POST() method being used here, and the request body is supplied to it.
        // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
        HttpRequest.BodyPublisher jsonPayload = HttpRequest.BodyPublishers.ofString(jsonString.toString());
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(URI.create(url))
                .setHeader("Authorization", myApiKey)
                .method("PATCH", jsonPayload)
                .header("Content-Type", "application/json")
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public void deleteBookingAPI(String bookingId) throws IOException, InterruptedException {
        HttpClient client;
        String url = rootUrl + "/" + this.request + "/" + bookingId;
        HttpRequest request;
        HttpResponse<String> response;
        // Note the POST() method being used here, and the request body is supplied to it.
        // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(URI.create(url))
                .setHeader("Authorization", myApiKey)
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .DELETE()
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public void patchUserTestAPI(User user) throws IOException, InterruptedException {
        HttpClient client;
        String url = rootUrl + "/" + this.request + "/" + user.getId();
        System.out.println(user.getId());
        HttpRequest request;
        HttpResponse<String> response;
        String jsonString = user.patchStringify();
        System.out.println(jsonString);
        // Note the POST() method being used here, and the request body is supplied to it.
        // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
        HttpRequest.BodyPublisher jsonPayload = HttpRequest.BodyPublishers.ofString(jsonString.toString());
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(URI.create(url))
                .setHeader("Authorization", myApiKey)
                .method("PATCH", jsonPayload)
                .header("Content-Type", "application/json")
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
