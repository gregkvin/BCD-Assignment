/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author gregoriuskevin
 */
public class Hashing {
    

    public static String hash (String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(input.getBytes());
        byte[] hashBytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<hashBytes.length;i++){
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
        
    }
    
 
}
