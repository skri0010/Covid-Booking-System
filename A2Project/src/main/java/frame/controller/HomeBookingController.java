package frame.controller;

import frame.model.HomeBookingModel;
import frame.view.HomeBookingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomeBookingController {

    private HomeBookingView homeBookingFrame;
    private HomeBookingModel homeBookingModel;

    public HomeBookingController(HomeBookingView theView, HomeBookingModel theModel) {
        this.homeBookingFrame = theView;
        this.homeBookingModel = theModel;
        this.homeBookingFrame.addSubmitActionListener(new SubmitActionListener());
    }

    class SubmitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                homeBookingModel = new HomeBookingModel(homeBookingFrame.getTestingSite(), homeBookingFrame.getBookingDate(), homeBookingFrame.getBookingTime(), homeBookingFrame.getCustomerId());
                homeBookingModel.submitBooking(homeBookingFrame.getYesCheckBox(), homeBookingFrame.getNoCheckBox());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
