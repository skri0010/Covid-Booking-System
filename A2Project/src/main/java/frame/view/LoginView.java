/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame.view;

import utility.search.SearchFacade;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
//
/**
 *
 * @author Jacky
 */
public class LoginView extends javax.swing.JFrame {

    public LoginView loginFrame;

    /**
     * Creates new form LoginFrame
     */
    public LoginView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        psword = new javax.swing.JPasswordField();
        usrname = new javax.swing.JTextField();
        loginButt = new javax.swing.JButton();
        testingSitePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchBut = new javax.swing.JButton();
        refreshBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        testingSiteType = new javax.swing.JComboBox<>();
        testingSiteWay = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Username: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Password: ");

        psword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        usrname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        loginButt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginButt.setText("Login");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usrname)
                            .addComponent(psword, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(354, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginButt)
                .addGap(42, 42, 42))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usrname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(psword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(loginButt)
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab("Login", loginPanel);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Testing Sites");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Search: ");

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        searchBut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchBut.setText("Search");


        refreshBut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refreshBut.setText("Refresh");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Open Time", "Close Time", "Waiting Time", "Site Type", "Status"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        testingSiteType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        testingSiteType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Hospital", "Clinic", "GPs" }));


        testingSiteWay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        testingSiteWay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Drive-Through", "Walk In" }));


        javax.swing.GroupLayout testingSitePanelLayout = new javax.swing.GroupLayout(testingSitePanel);
        testingSitePanel.setLayout(testingSitePanelLayout);
        testingSitePanelLayout.setHorizontalGroup(
            testingSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testingSitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testingSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testingSitePanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(793, Short.MAX_VALUE))
                    .addGroup(testingSitePanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(testingSiteType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(testingSiteWay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBut)
                        .addGap(55, 55, 55))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testingSitePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshBut)
                .addGap(20, 20, 20))
        );
        testingSitePanelLayout.setVerticalGroup(
            testingSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testingSitePanelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(testingSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testingSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(testingSiteType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(testingSiteWay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(testingSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(searchBut)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshBut)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Testing Site", testingSitePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getUserName(){
        return usrname.getText();
    }
    public String getPassword(){
        return String.valueOf(psword.getPassword());
    }

    public void showTestingSites(String buttonClick) throws IOException, InterruptedException, ParseException {
        jTable1.setDefaultEditor(Object.class, null);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        SearchFacade disCen = new SearchFacade();
        String suburb = searchField.getText();
        String tsType = testingSiteType.getSelectedItem().toString();
        String tsWay = testingSiteWay.getSelectedItem().toString();

        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        disCen.viewTestingSite(model, suburb, tsType, tsWay, buttonClick);
    }
    public void addSearchListener(ActionListener listener){
        loginButt.addActionListener(listener);
    }
    public void addRefreshListener(ActionListener listener){
        loginButt.addActionListener(listener);
    }

    public void addLoginListener(ActionListener listener){
        loginButt.addActionListener(listener);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginButt;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField psword;
    private javax.swing.JButton refreshBut;
    private javax.swing.JButton searchBut;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel testingSitePanel;
    private javax.swing.JComboBox<String> testingSiteType;
    private javax.swing.JComboBox<String> testingSiteWay;
    private javax.swing.JTextField usrname;
    // End of variables declaration//GEN-END:variables
}
