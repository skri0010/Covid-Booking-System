package frame.controller;

import frame.model.CustomerModel;
import frame.view.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomerController {
    private CustomerView customerFrame;
    private CustomerModel customerModel;

    public CustomerController(CustomerView theView, CustomerModel theModel) {
        this.customerFrame = theView;
        this.customerModel = theModel;
        customerFrame.addGeneratedBtnListener(new GeneratedBtnAction());
        customerFrame.addSearchBookingBtnListener(new SearchBookingAction());
    }

    class GeneratedBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customerFrame.getGeneratedButtonText() == "Book"){
                customerModel = new CustomerModel(null,customerFrame.getUser(),customerFrame.getTestingSite());
                customerModel.makeBooking();
            }
            else if (customerFrame.getGeneratedButtonText() == "Edit"){
                customerModel = new CustomerModel(customerFrame.getBooking(),customerFrame.getUser(),null);
                try {
                    customerModel.editBooking();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
    class SearchBookingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerModel = new CustomerModel();
            try {
                customerModel.searchBooking(customerFrame.getBookingId());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }


}
