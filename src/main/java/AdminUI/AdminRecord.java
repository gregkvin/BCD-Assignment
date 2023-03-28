/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminUI;

import Cryptography.Asymmetric;
import Hashing.Hasher;
import Hashing.Salt;
import KeyGenerator.KeyAccess;
import com.mycompany.bcd.assignment.FileHandle;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author gregoriuskevin
 */
public class AdminRecord {
    
    FileHandle fh = new FileHandle();
    KeyAccess k = new KeyAccess();
    

    public String[] readID(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        Asymmetric a = new Asymmetric("RSA");
        String[]demo = fh.declareArray();
        int n = 0;
        String[] userID = new String[line];
        while(n < line){
            try {
                userID[n] = a.decrypt(fh.getSplit(path, n, demo)[0], k.getPrivateKey("KeyPair/private-key"));
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return userID;
    }
    
      public String[] readUsername(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Asymmetric a = new Asymmetric("RSA");
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] usernamee = new String[line];
        while(n < line){
            try {
                usernamee[n] = a.decrypt(fh.getSplit(path, n, demo)[2], k.getPrivateKey("KeyPair/private-key"));
                System.out.println(usernamee[n]);
                n=n+1;
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return usernamee;
    }
      
      public String[] readPassword(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Asymmetric a = new Asymmetric("RSA");
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] passwordd = new String[line];
        while(n < line){
            try {
                passwordd[n] = a.decrypt(fh.getSplit(path, n, demo)[3], k.getPrivateKey("KeyPair/private-key"));
                System.out.println(passwordd[n]);
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return passwordd;
    }
      
      public String[] readName(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        Asymmetric a = new Asymmetric("RSA");
        String[]demo = fh.declareArray();
        int n = 0;
        String[] nama = new String[line];
        while(n < line){
            try {
                nama[n] = a.decrypt(fh.getSplit(path, n, demo)[1], k.getPrivateKey("KeyPair/private-key"));
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return nama;
    }
      
       public String[] readGender(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        Asymmetric a = new Asymmetric("RSA");
        String[]demo = fh.declareArray();
        int n = 0;
        String[] genderText = new String[line];
        while(n < line){
            try {
                genderText[n] = a.decrypt(fh.getSplit(path, n, demo)[4], k.getPrivateKey("KeyPair/private-key"));
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return genderText;
    }
       
        public String[] readDOB(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        Asymmetric a = new Asymmetric("RSA");
        String[]demo = fh.declareArray();
        int n = 0;
        String[] dobText = new String[line];
        while(n < line){
            try {
                dobText[n] = a.decrypt(fh.getSplit(path, n, demo)[5], k.getPrivateKey("KeyPair/private-key"));
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return dobText;
    }
        
         public String[] readEmail(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        Asymmetric a = new Asymmetric("RSA");
        String[]demo = fh.declareArray();
        int n = 0;
        String[] emailText = new String[line];
        while(n < line){
            try {
                emailText[n] = a.decrypt(fh.getSplit(path, n, demo)[6], k.getPrivateKey("KeyPair/private-key"));
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return emailText;
    }
         
        public String[] readUsernameWODecryption(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Asymmetric a = new Asymmetric("RSA");
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] usernamee = new String[line];
        while(n < line){
            try {
                usernamee[n] = fh.getSplit(path, n, demo)[2];
                System.out.println(usernamee[n]);
                n=n+1;
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return usernamee;
    }
      
      public String[] readPasswordWODecryption(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Asymmetric a = new Asymmetric("RSA");
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] passwordd = new String[line];
        while(n < line){
            try {
                passwordd[n] = fh.getSplit(path, n, demo)[3];
                System.out.println(passwordd[n]);
                n=n+1;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fs.close();
        return passwordd;
    }
    
    
    public void registerAdmin(String id, String name, String username, String password, String gender, String dob, String email) throws IOException, InvalidKeySpecException, Exception {
        try {
            String path = "KeyPair/public-key";
            Salt s = new Salt();
            Hasher h = new Hasher();
            Asymmetric a = new Asymmetric("RSA");
            PrintWriter pr = fh.setAppend("admin.txt");
            KeyAccess k = new KeyAccess();
            
            //byte [] salt = s.generate();
            String encryptID = a.encrypt(id, k.getPublicKey(path));
            String encryptName = a.encrypt(name, k.getPublicKey(path));
            String encryptUser = a.encrypt(username, k.getPublicKey(path));
            String encryptHashPass = a.encrypt(h.sha256(password), k.getPublicKey(path));
            String encryptGender = a.encrypt(gender, k.getPublicKey(path));
            String encryptDOB = a.encrypt(dob, k.getPublicKey(path));
            String encryptEmail = a.encrypt(email, k.getPublicKey(path));
            pr.println();
            pr.print(encryptID+ "-"); pr.print(encryptName+ "-"); pr.print(encryptUser+ "-"); pr.print(encryptHashPass+ "-");
            pr.print(encryptGender+ "-"); pr.print(encryptDOB+ "-"); pr.print(encryptEmail);
            pr.flush(); pr.close();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
