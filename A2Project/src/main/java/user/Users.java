package user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import utility.API;
import utility.adapter.ResponseAdapter;
import utility.adapter.TextAdaptee;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class represent the Users
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see User
 * @see UserRole
 */
public class Users {

    /**
     * Array for storing the users
     */
    private static ArrayList<User> users;

    /**
     * Adapter for the reponse
     */
    private ResponseAdapter responseAdapter;

    /**
     * Constructor for the Users
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public Users() throws IOException, InterruptedException {
        users = new ArrayList<>();
    }

    /**
     * This method call the loadUsers that call the api and return the users
     *
     * @return ArrayList of users
     * @throws IOException
     * @throws InterruptedException
     */
    public ArrayList<User> getUsers() throws IOException, InterruptedException {
        this.loadUsers();
        return users;
    }

    /**
     * This method will call the api and retrieve the users
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void loadUsers() throws IOException, InterruptedException {
        API userApi = new API("user?fields=bookings");
        HttpResponse<String> response = userApi.callGETAPI();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        this.responseAdapter = new ResponseAdapter(new TextAdaptee());
        String resultText = this.responseAdapter.convertFormat(jsonNode);
        User[] us = objectMapper.readValue(resultText, User[].class);
        users.clear();
        users.addAll(Arrays.asList(us));
    }

}