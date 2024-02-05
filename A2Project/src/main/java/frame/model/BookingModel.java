package frame.model;

import frame.controller.HomeBookingController;
import frame.controller.OnSiteBookingController;
import frame.view.HomeBookingView;
import frame.view.OnSiteBookingView;
import testingSite.TestingSite;
import user.User;

import javax.swing.*;

public class BookingModel {

    private User user;
    private TestingSite testingSite;

    public BookingModel(TestingSite testingSite, User user) {
        this.testingSite = testingSite;
        this.user = user;
    }

    public BookingModel() {
    }

    public void onSiteTestingBooking(){
        if (testingSite.isOnSiteTesting()) {
            OnSiteBookingView onSiteBookingFrame = new OnSiteBookingView(testingSite, user);
            OnSiteBookingModel onSiteBookingModel = new OnSiteBookingModel(onSiteBookingFrame.getUser(), onSiteBookingFrame.getTestingSite(), onSiteBookingFrame.getNote());
            OnSiteBookingController onSiteBookingController = new OnSiteBookingController(onSiteBookingFrame, onSiteBookingModel);
            onSiteBookingFrame.setVisible(true);
            onSiteBookingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else{
            JOptionPane.showMessageDialog(null, "On Site Testing not provided!");
        }
    }

    public void homeTestingBooking(){
        if (testingSite.isHomeTesting()) {
            HomeBookingView homeBookingFrame = new HomeBookingView(testingSite);
            HomeBookingModel homeBookingModel = new HomeBookingModel();
            HomeBookingController homeBookingController = new HomeBookingController(homeBookingFrame,homeBookingModel);
            homeBookingFrame.setVisible(true);
            homeBookingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Home Testing not provided!");
        }
    }


}
