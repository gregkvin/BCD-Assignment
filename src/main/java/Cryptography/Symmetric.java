/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cryptography;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author gregoriuskevin
 */
public class Symmetric {
    private Cipher cipher;
    
    public Symmetric(){
        this("AES");
    }
    
    private Symmetric(String algorithm){
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String encrypt(String data, Key key) throws Exception {
        String cipherText = null;
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherBytes = cipher.doFinal(data.getBytes());
        cipherText = Base64.getEncoder().encodeToString(cipherBytes);
        return cipherText;
        
    }
    
    public String decrypt(String cipherText, Key key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        String data = null;
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        data = new String(cipher.doFinal(cipherBytes));
        return data;
        
    }
}
