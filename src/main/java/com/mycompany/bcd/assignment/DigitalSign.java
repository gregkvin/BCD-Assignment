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
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

/**
 *
 * @author gregoriuskevin
 */
public class DigitalSign {
    private static final String ALGORITHM = "SHA256WithRSA";
    
    public static String create(String input, PrivateKey Key) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException{
       Signature sign = Signature.getInstance(ALGORITHM);
       sign.initSign(Key);
       sign.update(input.getBytes());
       return Base64.getEncoder().encodeToString(sign.sign());
       
    }
    
    public static boolean verify(String input, String signature, PublicKey Key) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException{
        Signature sign = Signature.getInstance(ALGORITHM);
        sign.initVerify(Key);
        sign.update(input.getBytes());
        return sign.verify( Base64.getDecoder().decode(signature));
    }
}
