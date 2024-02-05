package utility.viewMessage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import user.User;
import user.Users;
import utility.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RunMessage {

    private List<String> al;
    private StringBuffer sb;

    public void messageToArray(String messages){
        String[] str = messages.split(",");
        this.al = new ArrayList<String>(Arrays.asList(str));
    }

    public void addNewMessage(String newMessage){
        this.al.add(newMessage);
    }

    public List<String> getArrayMessages() {
        return this.al;
    }

    public String arrayToAPI(){
        this.sb = new StringBuffer();
        for (String s : this.al) {
            sb.append(s);
            if (!s.equals(""))
                sb.append(", ");
        }
        String str = sb.toString();
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 2);
        }
        return result;
    }

    public void notifyRecep(String bookingId, String previousTsId, String modifiedTsId, String status) throws IOException, InterruptedException {

        String message = this.createMessage(bookingId, status);

        if (previousTsId.equals(modifiedTsId)){
            Users u = new Users();
            ArrayList<User> users = u.getUsers();
            for (User user: users){
                if (user.getAdditionalInfo().has("workingTestingSiteId")){
                    if (user.getWorkingSiteId().equals(modifiedTsId)){
                        this.updateMessage(modifiedTsId, user, message);
                    }
                }
            }
        }else{
            Users u = new Users();
            ArrayList<User> users = u.getUsers();
            for (User user: users){
                if (user.getAdditionalInfo().has("workingTestingSiteId")){
                    if (user.getWorkingSiteId().equals(modifiedTsId)){
                        this.updateMessage(modifiedTsId, user, message);
                    }
                    if (user.getWorkingSiteId().equals(previousTsId)){
                        this.updateMessage(previousTsId, user, message);
                    }

                }
            }
        }

    }

    public void updateMessage(String testingSiteID, User user, String message) throws IOException, InterruptedException {
        String messages = user.getMessages();
        this.messageToArray(messages);
        this.addNewMessage(message);
        String Json = "{" +
                "\"workingTestingSiteId\":\"" + testingSiteID + "\"," +
                "\"messages\":\"" + this.arrayToAPI() + "\"" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(Json);
        User updatedUser = new User(user, (ObjectNode)jsonNode);
        API api = new API("user");
        api.patchUserTestAPI(updatedUser);
    }

    public String createMessage(String bookingId, String status){
        String message = "Booking " + bookingId;
        var currentdate = new Date();
        var datetime = "DateTime: " + currentdate.getDate() + "/"
                + (currentdate.getMonth()+1)  + "/"
                + currentdate.getYear() + " @ "
                + currentdate.getHours() + ":"
                + currentdate.getMinutes() + ":"
                + currentdate.getSeconds();
        return switch (status) {
            case "Modify" -> message + " has modified" + " (" + datetime + ")";
            case "Cancel" -> message + " has cancelled" + " (" + datetime + ")";
            case "Delete" -> message + " has deleted" + " (" + datetime + ")";
            default -> message;
        };
    }
}
