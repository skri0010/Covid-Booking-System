import frame.controller.LoginController;
import frame.model.LoginModel;
import frame.view.LoginView;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;

/***
 * Reference Library: <a href="https://www.tutorialspoint.com/jackson/jackson_pdf_version.htm">...</a>
 *
 *
 */

public class Application {
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LoginModel loginModel = new LoginModel();
                LoginView lg = new LoginView();
                LoginController loginController = new LoginController(loginModel,lg);
                try {
                    lg.showTestingSites("");
                } catch (IOException | InterruptedException | ParseException e) {
                    throw new RuntimeException(e);
                }
                lg.setVisible(true);
                lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
