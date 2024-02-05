package frame.controller;

import frame.model.LoginModel;
import frame.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class LoginController {
    LoginModel loginModel;
    LoginView loginFrame;

    public LoginController(LoginModel loginModel, LoginView loginFrame) {
        this.loginModel = loginModel;
        this.loginFrame = loginFrame;
        this.loginFrame.addLoginListener(new LoginListener());
        this.loginFrame.addSearchListener(new SearchListener());
        this.loginFrame.addRefreshListener(new RefreshListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = loginFrame.getUserName();
            String password = loginFrame.getPassword();
            LoginModel loginFeature = new LoginModel();
            try {
                loginFeature.loginInterface(userName, password);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }
    
    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                loginFrame.showTestingSites("Refresh");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }

    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                loginFrame.showTestingSites("Search");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }



}

