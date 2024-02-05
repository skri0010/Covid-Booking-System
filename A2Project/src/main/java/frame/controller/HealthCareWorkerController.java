package frame.controller;

import frame.model.HealthCareWorkerModel;
import frame.view.HealthCareWorkerFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HealthCareWorkerController {

    private HealthCareWorkerFrame healthCareWorkerFrame;
    private HealthCareWorkerModel healthCareWorkerModel;

    public HealthCareWorkerController(HealthCareWorkerFrame theView, HealthCareWorkerModel theModel) {
        this.healthCareWorkerFrame = theView;
        this.healthCareWorkerModel = theModel;
        this.healthCareWorkerFrame.addVerifyActionListener(new VerifyPatientIDListener());
    }

    class VerifyPatientIDListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                healthCareWorkerModel = new HealthCareWorkerModel(healthCareWorkerFrame.getPatientID(), healthCareWorkerFrame.getBookingID(), healthCareWorkerFrame.getHealthcareId());
                healthCareWorkerModel.verifyPatient();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
