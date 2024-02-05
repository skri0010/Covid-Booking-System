package frame.controller;

import frame.model.RepOptionModel;
import frame.view.RepOptionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RepOptionController {

    private RepOptionView repOption;
    private RepOptionModel repOptionModel;

    public RepOptionController(RepOptionView theView, RepOptionModel theModel) {
        this.repOption = theView;
        this.repOptionModel = theModel;
        this.repOption.addModifyCancelActionListener(new ModifyCancelListener());
        this.repOption.addDeleteActionListener(new DeleteListener());
    }

    class ModifyCancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                repOptionModel = new RepOptionModel(repOption.getBooking(), repOption.getRecep(), repOption.getBookingId());
                repOptionModel.modifyCancelAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                repOptionModel = new RepOptionModel(repOption.getBooking(), repOption.getRecep(), repOption.getBookingId());
                repOptionModel.deleteAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
