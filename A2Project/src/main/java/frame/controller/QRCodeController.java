package frame.controller;

import frame.model.QRCodeModel;
import frame.view.QRCodeView;

public class QRCodeController {

    private QRCodeView qrCodeView;
    private QRCodeModel qrCodeModel;

    public QRCodeController(QRCodeView theView, QRCodeModel theModel) {
        this.qrCodeView = theView;
        this.qrCodeModel = theModel;
    }

    public void setQRandUrl(){
        this.qrCodeModel.showQRAndUrl(this.qrCodeView.getQr(), this.qrCodeView.getUrl());
    }
}
