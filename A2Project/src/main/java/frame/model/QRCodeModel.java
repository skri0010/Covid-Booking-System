package frame.model;

import javax.swing.*;

public class QRCodeModel {

    private final JLabel qrBox;
    private final JLabel urlBox;

    public QRCodeModel(JLabel qrBox, JLabel urlBox) {
        this.qrBox = qrBox;
        this.urlBox = urlBox;
    }

    public void showQRAndUrl(String QRString, String URLString){
        qrBox.setText(QRString);
        urlBox.setText(URLString);
    }
}
