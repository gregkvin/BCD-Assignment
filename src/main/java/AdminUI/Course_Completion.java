/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminUI;

import Blockchain.BlockLogic;
import static Blockchain.BlockLogic.courseBlock;
import Blockchain.Blockchain;
import LoginUI.Login;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gregoriuskevin
 */
public class Course_Completion extends javax.swing.JFrame {

    public Course_Completion() throws IOException {
        initComponents();
        loadtable();
        setResizable(false);

    }

  
    

    public DefaultTableModel tableModel = new DefaultTableModel();
    private void loadtable() throws IOException {
        Blockchain userBlockchain = Blockchain.getInstance(courseBlock);
        List<String> dataList = userBlockchain.getLastBlockData();

        tableModel.addColumn("Credential ID");
        tableModel.addColumn("Student Name");
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Date of Completion");
        tableModel.addColumn("Passing Grade");
        tableModel.addColumn("Grade");
        tableModel.addColumn("Approval");

        for (String data : dataList) {
            String[] splitData = data.split("\\|");
            if (splitData[splitData.length - 1].equals("Unapproved")) {
                tableModel.addRow(splitData);
            }       
        }

        jTable.setModel(tableModel);
    }

    
    
    
    
    
        
    
    private void logout() throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        //FileWrite fh = new FileWrite();
        String[] input = {jMenu1.getText(), "User logout successful.", dtf.format(now)};
        //fh.LoggingActivity(input);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        approveButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jButton4.setText("jButton4");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Credential ID", "Student Name", "Course Name", "Data of Completion", "Passing Grade", "Grade", "Approval"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("• BLOCKCHAIN E-CERTIFICATE SYSTEM");

        jButton7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 51));
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        approveButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        approveButton.setForeground(new java.awt.Color(0, 102, 51));
        approveButton.setText("Approve");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        rejectButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rejectButton.setForeground(new java.awt.Color(0, 102, 51));
        rejectButton.setText("Reject");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton7)
                    .addComponent(approveButton)
                    .addComponent(rejectButton))
                .addGap(18, 18, 18))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jMenuBar1.setForeground(new java.awt.Color(0, 102, 204));
        jMenuBar1.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(0, 102, 51));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Admin");
        jMenu1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem2.setText("Activity Log");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem1.setText("Log Out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu5.setForeground(new java.awt.Color(0, 102, 51));
        jMenu5.setText("Manage Courses");
        jMenu5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int yesno = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Are you sure want to log out?","WARNING", yesno);
        if(yesno == JOptionPane.YES_OPTION) {
            try {
                dispose();
                logout();
                new Login().setVisible(true);
                if(yesno == JOptionPane.NO_OPTION) {
                    remove(yesno);
                }
            } catch (IOException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//     try {
//            // TODO add your handling code here:
//            dispose();
//            new Logging_Activity(jMenu1.getText()).setVisible(true);
//        } catch (IOException ex) {
//            Logger.getLogger(User_Records.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
        String user1 = jMenu1.getText();
        new Admin_Menu(user1).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow != -1) {
            // Update the table model
            BlockLogic bl = new BlockLogic();
            String id = (String) jTable.getValueAt(selectedRow, 0);
            String name = (String) jTable.getValueAt(selectedRow, 1);
            String course = (String) jTable.getValueAt(selectedRow, 2);
            String DoB = (String) jTable.getValueAt(selectedRow, 3);
            String passingGrade = (String) jTable.getValueAt(selectedRow, 4);
            String grade = (String) jTable.getValueAt(selectedRow, 5);
        
            // Generate a public-private key pair for the administrator
            KeyPairGenerator keyGen = null;
            try {
                keyGen = KeyPairGenerator.getInstance("RSA");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Create a digital signature using the private key
            Signature signer = null;
            try {
                signer = Signature.getInstance("SHA256withRSA");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                signer.initSign(privateKey);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String certData = name + "|" + course + "|" + grade + "|" + DoB;
            byte[] dataBytes = null;
            try {
                dataBytes = certData.getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                signer.update(dataBytes);
            } catch (SignatureException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] signatureBytes = null;
            try {
                signatureBytes = signer.sign();
            } catch (SignatureException ex) {
                Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
            }
            String signature = Base64.getEncoder().encodeToString(signatureBytes);
            bl.updateCompletionWithSignature(id, certData, signature);
            
            String newData = name + "|" + course + "|" + DoB + "|" + passingGrade + "|" + grade + "|" + "Approved";
            bl.updateCompletion(id, newData);
            tableModel.setValueAt("Approved", selectedRow, 6);
            tableModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_approveButtonActionPerformed

    
    
    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow != -1) {
            // Update the table model
            BlockLogic bl = new BlockLogic();
            String id = (String) jTable.getValueAt(selectedRow, 0);
            String name = (String) jTable.getValueAt(selectedRow, 1);
            String course = (String) jTable.getValueAt(selectedRow, 2);
            String DoB = (String) jTable.getValueAt(selectedRow, 3);
            String passingGrade = (String) jTable.getValueAt(selectedRow, 4);
            String grade = (String) jTable.getValueAt(selectedRow, 5);
        
            String newData = name + "|" + course + "|" + DoB + "|" + passingGrade + "|" + grade + "|" + "Rejected";
            bl.updateCompletion(id, newData);
            tableModel.setValueAt("Rejected", selectedRow, 6);
            tableModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Course_Completion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Course_Completion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Course_Completion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Course_Completion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String user1 = null;
                try {
                    new Course_Completion().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Course_Completion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton rejectButton;
    // End of variables declaration//GEN-END:variables
}