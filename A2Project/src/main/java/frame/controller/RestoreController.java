package frame.controller;

import frame.model.RestoreModel;
import frame.view.RestoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class RestoreController {

    private RestoreView restoreFrame;
    private RestoreModel restoreModel;

    public RestoreController(RestoreView theView, RestoreModel theModel) {
        this.restoreFrame = theView;
        this.restoreModel = theModel;
        this.restoreFrame.addConfirmActionListener(new ConfrimRestoreListener());
    }

    class ConfrimRestoreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                restoreModel = new RestoreModel(restoreFrame.getBooking(), restoreFrame.getTimeBox(), restoreFrame.getVenueBox());
                restoreModel.confirmRestore();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
