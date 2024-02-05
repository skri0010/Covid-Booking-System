package frame.controller;

import frame.model.EditBookingModel;
import frame.view.EditBookingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EditBookingController {

    private EditBookingView editBookingFrame;
    private EditBookingModel editBookingModel;

    public EditBookingController(EditBookingView theView, EditBookingModel theModel) {
        this.editBookingFrame = theView;
        this.editBookingModel = theModel;
        this.editBookingFrame.addConfirmActionListener(new ConfirmEditListener());
        this.editBookingFrame.addCancelActionListener(new CancelEditListener());
        this.editBookingFrame.addRestoreActionListener(new RestoreEditListener());
    }

    class ConfirmEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                editBookingModel = new EditBookingModel(editBookingFrame.getBooking(), editBookingFrame.getTestingSiteOpt(), editBookingFrame.getTime(), editBookingFrame.getDate());
                editBookingModel.confirmEdit();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class CancelEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                editBookingModel = new EditBookingModel(editBookingFrame.getBooking(), editBookingFrame.getTestingSiteOpt(), editBookingFrame.getTime(), editBookingFrame.getDate());
                editBookingModel.cancelEdit();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class RestoreEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                editBookingModel = new EditBookingModel(editBookingFrame.getBooking(), editBookingFrame.getTestingSiteOpt(), editBookingFrame.getTime(), editBookingFrame.getDate());
                editBookingModel.restore();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
