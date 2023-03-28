/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminUI;

import Cryptography.Asymmetric;
import Cryptography.Symmetric;
import Hashing.Hasher;
import Hashing.Salt;
import KeyGenerator.KeyAccess;
import KeyGenerator.RandomSecret;
import com.mycompany.bcd.assignment.FileHandle;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.Key;
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
public class CourseRecord {
    
    FileHandle fh = new FileHandle();
    Symmetric s = new Symmetric();
    String path = "course.txt";
    
    public String[] readID(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Key k = RandomSecret.generate();
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] courseID = new String[line];
        while(n < line){
            try {
                courseID[n] = fh.getSplit(path, n, demo)[0];
                System.out.println(courseID[n]);
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
        return courseID;
    }
    
      public String[] readName(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Key k = RandomSecret.generate();
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] courseName = new String[line];
        while(n < line){
            try {
                courseName[n] = s.decrypt(fh.getSplit(path, n, demo)[1], k);
                System.out.println(courseName[n]);
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
        return courseName;
    }
      
      public String[] readPassingGrade(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        Key k = RandomSecret.generate();
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] passingGr = new String[line];
        while(n < line){
            try {
                passingGr[n] = s.decrypt(fh.getSplit(path, n, demo)[2], k);
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
        return passingGr;
    }
      
      public String[] readDesc(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] descText = new String[line];
        while(n < line){
            try {
                descText[n] = fh.getSplit(path, n, demo)[3];
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
        return descText;
    }
    
    public void registerCourse(String id, String name, String passGrade, String desc) throws IOException, InvalidKeySpecException, Exception {
        try {
            Symmetric s = new Symmetric();
            PrintWriter pr = fh.setAppend("course.txt");
            Key k = RandomSecret.generate();
            
            //byte [] salt = s.generate();
            String encryptID = id;
            String encryptName = s.encrypt(name, k);
            String encryptGrade = s.encrypt(passGrade, k);
            String encryptDesc = s.encrypt(desc, k);
            pr.println();
            pr.print(id+ "-"); pr.print(encryptName+ "-"); pr.print(encryptGrade+ "-"); pr.print(encryptDesc);
            pr.flush(); pr.close();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
