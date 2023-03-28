/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.security.MessageDigest;
import java.util.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author putubgs
 */
public class Hasher {
    
    /* sha256 */
    public static String sha256(String input){
        return hash(input, "SHA-256");
    }
    
    public static String sha256_salted(String input, byte[] salt){
        return hash(input, "SHA-256", salt);
    }
      
    private static String hash(String input, String algorithm){
        String hashCode = "";
        
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte[] hashBytes = md.digest();
            
            //1)
            hashCode = Base64.getEncoder().encodeToString(hashBytes);
            //2) hex format output - recommended!
            hashCode = Hex.encodeHexString(hashBytes);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return hashCode;
    }
    
    private static String hash(String input, String algorithm, byte[] salt){
        String hashCode = "";
        
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            md.update(salt);
            byte[] hashBytes = md.digest();
            
            //1)
            hashCode = Base64.getEncoder().encodeToString(hashBytes);
            //2) hex format output - recommended!
            hashCode = Hex.encodeHexString(hashBytes);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return hashCode;
    }
}

