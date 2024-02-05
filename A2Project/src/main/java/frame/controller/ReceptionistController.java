package frame.controller;

import frame.model.ReceptionistModel;
import frame.view.ReceptionistView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReceptionistController {

    private ReceptionistView receptionistFrame;
    private ReceptionistModel receptionistModel;

    public ReceptionistController(ReceptionistView theView, ReceptionistModel theModel) {
        this.receptionistFrame = theView;
        this.receptionistModel = theModel;
        this.receptionistFrame.addSubmitBtnListener(new SubmitBookingListener());
        this.receptionistFrame.addVerifyBtnListener(new VerifyPINListener());
        this.receptionistFrame.addQRCodeBtnListener(new QRCodeListener());
        this.receptionistFrame.addButtonActionBtnListener(new ButtonActionListener());
        this.receptionistFrame.addModifyBtnListener(new ModifyBookingListener());
        this.receptionistFrame.addDeleteBtnListener(new DeleteBookingListener());
    }

    class SubmitBookingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                receptionistModel.successSubmit(receptionistFrame.getStartingDate(), receptionistFrame.getStartingTime(), receptionistFrame.getNotes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class VerifyPINListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                receptionistModel.verifyPIN(receptionistFrame.getPINCode(), receptionistFrame.getBookingId());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class QRCodeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                receptionistModel = new ReceptionistModel(receptionistFrame.getBookingId(), receptionistFrame.getCustomerId(), receptionistFrame.getTestingSiteId());
                receptionistModel.qrCodeSubmit(receptionistFrame.getQRCode());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            receptionistModel.changeBooking(receptionistFrame.getButton(), receptionistFrame.getBookingTable(), receptionistFrame.getRecep());
        }
    }

    class ModifyBookingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                receptionistModel.modifyBooking(receptionistFrame.getBookingId());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class DeleteBookingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                receptionistModel.deleteBooking(receptionistFrame.getBookingId());
                JOptionPane.showMessageDialog(null,  "Booking is Deleted!!");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
