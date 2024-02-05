/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame.view;

import booking.Booking;
import booking.Bookings;
import user.User;
import utility.viewMessage.ViewMessages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jacky
 */
public class ReceptionistView extends javax.swing.JFrame {

    private User recep;

    /**
     * Creates new form ReceptionistFrame
     */
    public ReceptionistView(User us) {
        this.recep = us;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        onSiteBookTitle = new javax.swing.JLabel();
        customerIdLbl = new javax.swing.JLabel();
        welcomeRecep = new javax.swing.JLabel();
        testSiteIdLbl = new javax.swing.JLabel();
        strtTimeLbl = new javax.swing.JLabel();
        notesLbl = new javax.swing.JLabel();
        customerId = new javax.swing.JTextField();
        testingSiteId = new javax.swing.JTextField();
        startingDate = new javax.swing.JTextField();
        notes = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        startDateLbl = new javax.swing.JLabel();
        startingTime = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pinCodeField = new javax.swing.JTextField();
        verifyPINBut = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bookingIdFld = new javax.swing.JTextField();
        deleteBookingBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qrCodeField = new javax.swing.JTextField();
        qrCodeBut = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        bookRefreshBut = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();
        messageBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        onSiteBookTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        onSiteBookTitle.setText("COVID-19 On-Site Booking");

        customerIdLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerIdLbl.setText("Customer ID: ");

        welcomeRecep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        welcomeRecep.setText("Welcome Receptionist");

        testSiteIdLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        testSiteIdLbl.setText("Testing Site ID: ");

        strtTimeLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        strtTimeLbl.setText("Starting Time: ");

        notesLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        notesLbl.setText("Notes: ");

        customerId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        testingSiteId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        startingDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        startingDate.setText("YYYY-MM-DD");

        notes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        submitBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        submitBtn.setText("Submit");

        startDateLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        startDateLbl.setText("Starting Date");

        startingTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        startingTime.setText("HH:MM:SS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(submitBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(notesLbl)
                                        .addGap(77, 77, 77))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(startDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notes)
                                    .addComponent(startingDate)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(onSiteBookTitle))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(welcomeRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(testSiteIdLbl)
                                    .addComponent(customerIdLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerId)
                                    .addComponent(testingSiteId))))
                        .addGap(40, 40, 40)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(strtTimeLbl)
                .addGap(18, 18, 18)
                .addComponent(startingTime)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onSiteBookTitle)
                .addGap(2, 2, 2)
                .addComponent(welcomeRecep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIdLbl)
                    .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testSiteIdLbl)
                    .addComponent(testingSiteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLbl))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(strtTimeLbl)
                    .addComponent(startingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(notesLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(notes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitBtn)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        customerId.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("On-Site Booking", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Verify PIN Code");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("PIN Code: ");

        pinCodeField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        verifyPINBut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        verifyPINBut.setText("Verify");

        modifyBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modifyBtn.setText("Modify Booking");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Booking ID:");

        bookingIdFld.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bookingIdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingIdFldActionPerformed(evt);
            }
        });

        deleteBookingBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBookingBtn.setForeground(new java.awt.Color(255, 0, 51));
        deleteBookingBtn.setText("Delete Booking");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifyPINBut)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pinCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(bookingIdFld)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(deleteBookingBtn)))
                        .addGap(0, 111, Short.MAX_VALUE)))
                .addGap(374, 374, 374))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pinCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bookingIdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(verifyPINBut)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyBtn)
                    .addComponent(deleteBookingBtn))
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("Verify PIN", jPanel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("QR Code Scanner");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("QR Code: ");

        qrCodeField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        qrCodeBut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        qrCodeBut.setText("Submit");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qrCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 451, Short.MAX_VALUE)
                .addComponent(qrCodeBut)
                .addGap(373, 373, 373))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qrCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(qrCodeBut)
                .addGap(61, 61, 61))
        );

        jTabbedPane1.addTab("QR Code Scanner", jPanel3);

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Customer ID", "Testing Site", "Start Time", "Status", "Note", "Booking Type", "Action"
            }
        ));
        jScrollPane1.setViewportView(bookingTable);

        bookRefreshBut.setText("Refresh");
        bookRefreshBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bookRefreshButActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookRefreshBut)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookRefreshBut)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Bookings", jPanel4);

        messageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Message"
            }
        ));
        messageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(messageTable);

        messageBut.setText("Refresh");
        messageBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    messageButActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(messageBut)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(messageBut)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Messages", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getStartingDate(){
        return startingDate.getText();
    }

    public String getStartingTime(){
        return startingTime.getText();
    }

    public String getCustomerId(){
        return customerId.getText();
    }

    public String getTestingSiteId(){
        return testingSiteId.getText();
    }

    public String getNotes(){
        return notes.getText();
    }

    public String getPINCode(){
        return pinCodeField.getText();
    }

    public String getBookingId(){
        return bookingIdFld.getText();
    }

    public String getQRCode(){
        return qrCodeField.getText();
    }

    public JButton getButton(){
        return button;
    }

    public JTable getBookingTable() {
        return bookingTable;
    }

    public User getRecep(){
        return this.recep;
    }

    public void addSubmitBtnListener(ActionListener actionListener){
        submitBtn.addActionListener(actionListener);
    }

    public void addVerifyBtnListener(ActionListener actionListener){
        verifyPINBut.addActionListener(actionListener);
    }

    public void addQRCodeBtnListener(ActionListener actionListener){
        qrCodeBut.addActionListener(actionListener);
    }

    private void showBookings() throws IOException, InterruptedException {
        bookingTable.setDefaultEditor(Object.class, null);
        DefaultTableModel model = (DefaultTableModel) bookingTable.getModel();

        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        Bookings bks = new Bookings();
        bks.loadBookings();
        ArrayList<Booking> bookings = bks.getBookings();

        Object[] rowData = new Object[8];

        for (Booking bookingObject : bookings) {
            rowData[0] = bookingObject.getId();
            rowData[1] = bookingObject.getCustomer().get("id").textValue();;
            rowData[2] = bookingObject.getTestingSite().get("id").textValue();;
            rowData[3] = bookingObject.getStartTime();
            rowData[4] = bookingObject.getStatus();
            rowData[5] = bookingObject.getNotes();
            rowData[6] = this.checkBookingType(bookingObject);
            rowData[7] = bookingObject;
            model.addRow(rowData);
        }
        bookingTable.getColumn("Action").setCellRenderer(new ButtonRenderer("Action"));
        bookingTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(),"Action"));
    }

    public String checkBookingType(Booking booking){
        if(booking.getBookOnSiteTesting()){
            return "On-site Testing";
        } else if (booking.getBookHomeTesting()) {
            return "Home Testing";
        }
        return null;
    }



    public void addButtonActionBtnListener(ActionListener actionListener){
        button.addActionListener(actionListener);
    }

    private void showMessages() throws IOException, InterruptedException {
        messageTable.setDefaultEditor(Object.class, null);
        DefaultTableModel model = (DefaultTableModel) messageTable.getModel();

        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        ViewMessages viewMessages = new ViewMessages();
        viewMessages.showMessage(model, this.recep.getId());
    }

    private void bookRefreshButActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {//GEN-FIRST:event_bookRefreshButActionPerformed
        this.showBookings();
    }//GEN-LAST:event_bookRefreshButActionPerformed

    private void messageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_messageTableMouseClicked

    private void messageButActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {//GEN-FIRST:event_messageButActionPerformed
        this.showMessages();
    }//GEN-LAST:event_messageButActionPerformed

    public void addModifyBtnListener(ActionListener actionListener){
        modifyBtn.addActionListener(actionListener);
    }

    private void bookingIdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingIdFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingIdFldActionPerformed

    public void addDeleteBtnListener(ActionListener actionListener){
        deleteBookingBtn.addActionListener(actionListener);
    }

    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    class ButtonRenderer extends JButton implements TableCellRenderer
    {
        private String btnTxt;
        public ButtonRenderer(String btnTxt) {
            this.btnTxt = btnTxt;
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? btnTxt : btnTxt);
            return this;
        }
    }
    class ButtonEditor extends DefaultCellEditor
    {
        private String label;
        private String btnTxt;

        public ButtonEditor(JCheckBox checkBox,String btnTxt)
        {
            super(checkBox);
            this.btnTxt = btnTxt;
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column)
        {
            label = (value == null) ? btnTxt : btnTxt;
            button.setText(label);
            return button;
        }
        public Object getCellEditorValue()
        {
            return new String(label);
        }
    }

    JButton button = new JButton();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookRefreshBut;
    private javax.swing.JTextField bookingIdFld;
    private javax.swing.JTable bookingTable;
    private javax.swing.JTextField customerId;
    private javax.swing.JLabel customerIdLbl;
    private javax.swing.JButton deleteBookingBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton messageBut;
    private javax.swing.JTable messageTable;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JTextField notes;
    private javax.swing.JLabel notesLbl;
    private javax.swing.JLabel onSiteBookTitle;
    private javax.swing.JTextField pinCodeField;
    private javax.swing.JButton qrCodeBut;
    private javax.swing.JTextField qrCodeField;
    private javax.swing.JLabel startDateLbl;
    private javax.swing.JTextField startingDate;
    private javax.swing.JTextField startingTime;
    private javax.swing.JLabel strtTimeLbl;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel testSiteIdLbl;
    private javax.swing.JTextField testingSiteId;
    private javax.swing.JButton verifyPINBut;
    private javax.swing.JLabel welcomeRecep;
    // End of variables declaration//GEN-END:variables
}