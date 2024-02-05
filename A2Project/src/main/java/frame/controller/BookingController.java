package frame.controller;

import frame.model.BookingModel;
import frame.view.BookingView;
import testingSite.TestingSite;
import user.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingController {

    private BookingView bookingView;
    private BookingModel bookingModel;

    public BookingController(BookingView theView, BookingModel theModel) {
        this.bookingView = theView;
        this.bookingModel = theModel;
        this.bookingView.addOnSiteBookingListener(new OnSiteBookingListener());
        this.bookingView.addAtHomeBookingListener(new AtHomeookingListener());
    }

    class OnSiteBookingListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TestingSite testingSite = bookingView.getTestSite();
            User user = bookingView.getUser();
            bookingModel = new BookingModel(testingSite, user);
            bookingModel.onSiteTestingBooking();
        }
    }

    class AtHomeookingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            TestingSite testingSite = bookingView.getTestSite();
            User user = bookingView.getUser();
            bookingModel = new BookingModel(testingSite, user);
            bookingModel.homeTestingBooking();
        }
    }
}
