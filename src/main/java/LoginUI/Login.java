package LoginUI;

import AdminUI.Admin_Menu;
import Blockchain.BlockLogic;
import static Blockchain.BlockLogic.userBlock;
import Blockchain.Blockchain;
import Class.User;
import UserUI.User_Menu;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gregoriuskevin
 */
public class Login extends javax.swing.JFrame {
    private String user, pass;
    
    public String getUser(){
        return user;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setUser(String usernme){
        user = usernme;
    }
    
    public void setPass(String passwrd){
        pass = passwrd;
    }
    
    public boolean checkUser(String user, String[]usernamee, String[] level, int line){
        for(int n=0; n < line; n++){
           if(user.equals(usernamee[n])){
               return true;
               
        } 
        }
        return false;
    }
    
    public int userIndex (String[]usernamee, String username){
        if (usernamee == null) return -1;
        int len = usernamee.length;
        int i = 0;
        while (i < len) {
            if (usernamee[i].equals(username)) 
                return i;
            else i=i+1;
        }
        return -1;
    
    }
    public int checkPass(String[] usernamee, String username, 
            String pass, String[]passwordd, String[] level, int line){
        int nos = 0;
        int no = userIndex(usernamee, username);
        if(pass.equals(passwordd[no]) && level[no].equals("Personnel")){
            return 1;
        } else if (pass.equals(passwordd[no]) && level[no].equals("People")){
            return 2;
        }
        else {
            return 0;
    }
    }
    
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        UIManager ui = new UIManager();
        ui.put("OptionPane.messageFont", new Font("Poppins", Font.PLAIN, 13));
        ui.put("OptionPane.buttonFont", new Font("Poppins", Font.BOLD, 12));
        ui.put("OptionPane.background", Color.white);
        ui.put("Panel.background", Color.white);
        setResizable(false);
        jLabel3.setVisible(false);
        jButton3.setEnabled(false);
        jButton1.setVisible(true);
        password.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        username.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        jLabel3.setText("Password");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(username)
                    .addComponent(password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*Login lo = new Login();
        FileWrite fh = new FileWrite();
        User read = new User();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  

        String path = "login.txt";
        try {
            int line = fh.readLineNumber(path);
            String[] usernamee = read.readUsername(path);
            String usernme = username.getText();
            String[] passwordd = read.readPass(path);
            String[] date = read.readDOB(path);
            String [] datedose1 = read.readFirstDate(path);
            String [] datedose2 = read.readSecondDate(path);
            String [] statusdose1 = read.readFirstStatus(path);
             String [] statusdose2 = read.readSecondStatus(path);
            int n = userIndex(usernamee, usernme);
            String dob = date[n];
            String passwrd = String.valueOf(password.getPassword());
            String[] level = read.readLevel(path);
            lo.setUser(usernme);
            lo.setPass(passwrd);
            
            int boo = lo.checkPass(usernamee, lo.getUser(), lo.getPass(), passwordd, level, line);
            if(boo == 1) {
                String user1 = lo.getUser();
                String[] input = {user1, "User login successful.", dtf.format(now)};
                fh.LoggingActivity(input);
                dispose();
                JOptionPane.showMessageDialog(null, "Login successfully, please proceed!");
                new Personnel_Menu(user1).setVisible(true);
                
            } else if(boo == 2){
                String user1 = lo.getUser();
                String pass1 = lo.getPass();
                dispose();
                
                String[] input = {user1, "User login successful.", dtf.format(now)}; fh.LoggingActivity(input);
                JOptionPane.showMessageDialog(null, "Login successfully, please proceed!"); 
                if(lo.getPass().equals(dob)){
                    JOptionPane.showMessageDialog(null, "Please change your password immediately.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
                    }
                   new People_Menu(user1).setVisible(true);
                   if(statusdose1[n].equalsIgnoreCase("No") && !datedose1[n].equals("TBA") ||
                           statusdose2[n].equalsIgnoreCase("No") && !datedose2[n].equals("TBA")){
                     JOptionPane.showMessageDialog(null, "Vaccination appointment updated!\n"
                             + "Please confirm or cancel your appointment immediately!", "Warning",
                    JOptionPane.WARNING_MESSAGE);  
                   }
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid password");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        BlockLogic bl = new BlockLogic();

        Blockchain userBlockchain = Blockchain.getInstance(userBlock);
        
        User foundUser = bl.findUser(username.getText(), String.valueOf(password.getPassword()), userBlockchain);
        
        if (foundUser != null) {
            System.out.println("User found: " + foundUser);
            new User_Menu().setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        /*Login lo = new Login();
        FileWrite fh = new FileWrite();
        User read = new User();
        String path = "login.txt";
        try {
            int line = fh.readLineNumber(path);
            String[] usernamee = read.readUsername(path);
            String usernme = username.getText();
            String[] level = read.readLevel(path);
            lo.setUser(usernme);
            boolean boo = lo.checkUser(lo.getUser(), usernamee, level, line);
            if(boo == true) {
                jLabel3.setVisible(true);
                jButton3.setVisible(false);
                jButton1.setVisible(true);
                username.setEditable(false);
                password.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Username not found.");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
         /*jLabel3.setVisible(true);
                jButton3.setVisible(false);
                jButton1.setVisible(true);
                username.setEditable(false);
                password.setVisible(true);*/
//         dispose();
         password.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
