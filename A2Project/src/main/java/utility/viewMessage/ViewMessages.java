package utility.viewMessage;

import user.User;
import user.Users;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class ViewMessages {

    public void showMessage(DefaultTableModel model, String recepId) throws IOException, InterruptedException {
        Users u = new Users();
        ArrayList<User> users = u.getUsers();
        Object[] rowData = new Object[1];
        String messages = null;

        for (User user : users) {
            if(user.getId().equals(recepId)){
                messages = user.getMessages();
            }
        }

        RunMessage runMessage = new RunMessage();
        assert messages != null;
        runMessage.messageToArray(messages);

        for (String msg: runMessage.getArrayMessages()){
            rowData[0] = msg;
            model.addRow(rowData);
        }
    }

}
