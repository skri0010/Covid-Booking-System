package frame.model;

import frame.controller.CustomerController;
import frame.controller.HealthCareWorkerController;
import frame.controller.ReceptionistController;
import frame.view.ReceptionistView;
import frame.view.CustomerView;
import frame.view.HealthCareWorkerFrame;
import user.User;
import user.UserRole;
import user.Users;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Class represent the Login
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 */
public class LoginModel {

    private ArrayList<User> users;

    /**
     * Constructor for login
     */
    public LoginModel() {
    }

    /**
     * Method for different login interface for different users
     *
     * @param userName Username
     * @param password Password
     * @throws IOException
     * @throws InterruptedException
     * @throws ParseException
     */
    public void loginInterface(String userName, String password) throws IOException, InterruptedException, ParseException {

        Users allUsers = new Users();
        this.users = allUsers.getUsers();
        if (userName.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in your Username and Password!");
            return;
        }
        if (!userName.equals(password)) {
            JOptionPane.showMessageDialog(null, "Please fill in the correct Username and Password!");
            return;
        }
        for (User us : this.users) {
            if (userName.equals(us.getUserName())){
                if(us.getIsCustomer()) {
                    us.getRole().setRoleType(UserRole.CUSTOMER);
                    CustomerView customerFrame = new CustomerView(us);
                    customerFrame.setUserName(userName);
                    customerFrame.showLatestTestingSites("");
                    customerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    customerFrame.showBookings();
                    CustomerModel customerModel = new CustomerModel();
                    CustomerController customerController = new CustomerController(customerFrame,customerModel);
                    customerFrame.setVisible(true);
                    return;
                } else if (us.getIsHealthcareWorker()) {
                    us.getRole().setRoleType(UserRole.HEALTHCAREWORKER);
                    HealthCareWorkerFrame healthCareWorkerFrame = new HealthCareWorkerFrame();
                    healthCareWorkerFrame.setHealthCareID(us.getId());
                    HealthCareWorkerModel healthCareWorkerModel = new HealthCareWorkerModel();
                    HealthCareWorkerController healthCareWorkerController = new HealthCareWorkerController(healthCareWorkerFrame, healthCareWorkerModel);
                    healthCareWorkerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    healthCareWorkerFrame.setVisible(true);
                    return;
                }else if (us.getIsReceptionist()) {
                    us.getRole().setRoleType(UserRole.RECEPTIONIST);
                    ReceptionistView receptionistFrame = new ReceptionistView(us);
                    ReceptionistModel receptionistModel = new ReceptionistModel(receptionistFrame.getBookingId(), receptionistFrame.getCustomerId(), receptionistFrame.getTestingSiteId());
                    ReceptionistController receptionistController = new ReceptionistController(receptionistFrame, receptionistModel);
                    receptionistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    receptionistFrame.setVisible(true);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Not a Registered User!!!");
    }

}
