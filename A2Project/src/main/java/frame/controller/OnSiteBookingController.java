package frame.controller;

import frame.model.OnSiteBookingModel;
import frame.view.OnSiteBookingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OnSiteBookingController {

    private OnSiteBookingView onSiteBookingFrame;
    private OnSiteBookingModel onSiteBookingModel;

    public OnSiteBookingController(OnSiteBookingView theView, OnSiteBookingModel theModel) {
        this.onSiteBookingFrame = theView;
        this.onSiteBookingModel = theModel;
        this.onSiteBookingFrame.addSubmitActionListener(new SubmitActionListener());
    }

    class SubmitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                onSiteBookingModel = new OnSiteBookingModel(onSiteBookingFrame.getUser(), onSiteBookingFrame.getTestingSite(), onSiteBookingFrame.getNote());
                onSiteBookingModel.submitAction(onSiteBookingFrame.getStartingTime(), onSiteBookingFrame.getStartingDate());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
