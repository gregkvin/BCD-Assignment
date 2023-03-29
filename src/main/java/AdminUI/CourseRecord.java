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
import java.util.Base64;


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
                courseName[n] = fh.getSplit(path, n, demo)[1];
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
                passingGr[n] = fh.getSplit(path, n, demo)[2];
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
      
      public String[] readEx(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] exText = new String[line];
        while(n < line){
            try {
                exText[n] = fh.getSplit(path, n, demo)[3];
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
        return exText;
    }
      
    public String[] readQuestion(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] question = new String[line];
        while(n < line){
            try {
                question[n] = fh.getSplit(path, n, demo)[4];
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
        return question;
    }
    
    public String[] readAnswer1(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] answer1 = new String[line];
        while(n < line){
            try {
                answer1[n] = fh.getSplit(path, n, demo)[5];
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
        return answer1;
    }
    
    public String[] readAnswer2(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] answer2 = new String[line];
        while(n < line){
            try {
                answer2[n] = fh.getSplit(path, n, demo)[6];
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
        return answer2;
    }
    
    public String[] readAnswer3(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] answer3 = new String[line];
        while(n < line){
            try {
                answer3[n] = fh.getSplit(path, n, demo)[7];
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
        return answer3;
    }
    
    public String[] readAnswer4(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] answer4 = new String[line];
        while(n < line){
            try {
                answer4[n] = fh.getSplit(path, n, demo)[8];
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
        return answer4;
    }
    
    public void registerCourse(String id, String name, String passGrade, String explanation, String question, String ans1, String ans2, String ans3, String ans4) throws IOException, InvalidKeySpecException, Exception {
        try {
            Symmetric s = new Symmetric();
            PrintWriter pr = fh.setAppend("course.txt");
            PrintWriter key = fh.setAppend("courseKey.txt");
            Key k = RandomSecret.generate();
            
            //byte [] salt = s.generate();
            String encryptID = id;
            String encryptName = s.encrypt(name, k);
            String encryptGrade = s.encrypt(passGrade, k);
            String encryptExplanation = s.encrypt(explanation, k);
            String encryptQuestion = s.encrypt(question, k);
            String encryptAnswer1 = s.encrypt(ans1, k);
            String encryptAnswer2 = s.encrypt(ans2, k);
            String encryptAnswer3 = s.encrypt(ans3, k);
            String encryptAnswer4 = s.encrypt(ans4, k);
            
            if (fh.readLineNumber("course.txt") != 0 && fh.readLineNumber("courseKey.txt") != 0) {
                key.println();
                pr.println();
            }
            
            pr.print(id+ "-"); pr.print(encryptName+ "-"); pr.print(encryptGrade+ "-"); 
            pr.print(encryptExplanation+"-"); pr.print(encryptQuestion+"-"); pr.print(encryptAnswer1+"-"); 
            pr.print(encryptAnswer2+"-"); pr.print(encryptAnswer3+"-"); pr.print(encryptAnswer4+"-");
            
            byte[] keyBytes = k.getEncoded();
            String keyString = Base64.getEncoder().encodeToString(keyBytes);
            key.print(id+"-"); key.print(keyString+"-");

            
            key.flush();key.close();
            pr.flush(); pr.close();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AdminRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
