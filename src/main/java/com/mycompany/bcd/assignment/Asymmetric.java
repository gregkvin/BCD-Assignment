/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

import java.security.InvalidKeyException;
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
public class Asymmetric {
    private Cipher cipher;
    
    public Asymmetric(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException{

            cipher = Cipher.getInstance(algorithm);

    }
    
    public String encrypt(String data, PublicKey key) throws Exception {
        String cipherText = null;
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherBytes = cipher.doFinal(data.getBytes());
        cipherText = Base64.getEncoder().encodeToString(cipherBytes);
        return cipherText;
        
    }
    
    public String decrypt(String cipherText, PrivateKey key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        String ohgee = null;
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        ohgee = new String(cipher.doFinal(cipherBytes));
        return ohgee;
        
    }
}
