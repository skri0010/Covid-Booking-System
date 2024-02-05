package frame.controller;

import frame.model.FormModel;
import frame.view.FormView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FormController {

    private FormView formFrame;
    private FormModel formModel;

    public FormController(FormView theView, FormModel theModel) {
        this.formFrame = theView;
        this.formModel = theModel;
        this.formFrame.addDoneFormActionListener(new DoneFormListener());
    }

    class DoneFormListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                formModel = new FormModel(formFrame.getBooking(), formFrame.getPatient(), formFrame.getHealthCareId());
                formModel.doneForm(formFrame.getCb1(), formFrame.getCb2(), formFrame.getCb3(), formFrame.getCb4(), formFrame.getCb5(), formFrame.getCb6());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
